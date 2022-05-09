package Taxes;

public class IncomeTax extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        System.out.print("Подоходный налог ");
        return amount * 0.13;
    }
}
