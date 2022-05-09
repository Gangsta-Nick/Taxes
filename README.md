## Полиморфизм

### Задача "От бухгалтеров"

В данной работе реализован подсчет налогов

Класс налоговой службы TaxService
```java
class TaxService{
    public void payOut(double taxAmount){
        System.out.format("уплачен в размере %.2f%n", taxAmount);
    }
}
```
Сообщает какой налог и в каком размере был уплачен

В директорию ```Taxes``` были помещены классы, рассчитывающие налог:
```TaxType``` является родительским классом, по этому может возвращать 0
```java
public class TaxType {
    public double calculateTaxFor(double amount) {
        return 0.0;
    }
}
```

```IncomeTax``` наследует своего родителя ```TaxType``` и рассчитывает подоходный налог в размере 13%
```java
public class IncomeTax extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        System.out.print("Подоходный налог ");
        return amount * 0.13;
    }
}
```
```VATax``` так же наследует ```TaxType``` и отвечает за расчет НДС в размере 20%
```java
public class VATax extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        System.out.print("НДС ");
        return amount * 0.2;
    }
}
```
```ProgressiveTax``` тоже является наследником ```TaxType``` и ведет расчет прогрессивного налога
```java
public class ProgressiveTax extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        System.out.print("Прогрессивный налог ");
        return amount < 100000.0 ? amount * 0.1 : amount * 0.15;
    }
}

```
в прогрессивном налоге был применен тернарный оператор, так как у него есть две процентные ставки, 10% до 100 тыс. и 15% на 100 тыс. и выше

К работе были написаны юнит тесты для каждого налога методом "arrange, аct, аssert".
```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
```

На прогрессивный налог было написано два юнит теста

`public void testProgressiveTax()` при сумме 100 тыс. или более

`public void testProgressiveTaxVarTwo()` при сумме до 100 тыс.