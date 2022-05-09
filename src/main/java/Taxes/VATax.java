package Taxes;

public class VATax extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        System.out.print("НДС ");
        return amount * 0.2;
    }
}
