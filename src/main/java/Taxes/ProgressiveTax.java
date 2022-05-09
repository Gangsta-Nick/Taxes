package Taxes;

public class ProgressiveTax extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        System.out.print("Прогрессивный налог ");
        return amount < 100000.0 ? amount * 0.1 : amount * 0.15;
    }
}
