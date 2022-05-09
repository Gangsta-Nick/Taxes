import Taxes.*;

public class Main {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        TaxType vaTax = new VATax();
        TaxType incomeTax = new IncomeTax();
        TaxType progressiveTax = new ProgressiveTax();
        Bill[] payments = new Bill[]{
                new Bill(1957, vaTax, taxService),
                new Bill(80523.49, incomeTax, taxService),
                new Bill(100000, progressiveTax, taxService)
        };
        for (Bill bill : payments) {
            bill.payTaxes();
        }
    }
}


