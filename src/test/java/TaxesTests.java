import Taxes.*;
import org.junit.jupiter.api.*;

public class TaxesTests {
    TaxType vaTax, incomeTax, progressiveTax;

    @BeforeEach
    public void init() {
        vaTax = new VATax();
        incomeTax = new IncomeTax();
        progressiveTax = new ProgressiveTax();
    }

    @BeforeAll
    public static void start() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test complete");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("All test completed");
    }

    @Test
    public void testVATax() {
        //arrange
        double sum = 10000, expected = 10000 * 0.2;

        //act
        double result = vaTax.calculateTaxFor(sum);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testProgressiveTax() {
        //arrange
        double sum = 100000, expected = 100000 * 0.15;

        //act
        double result = progressiveTax.calculateTaxFor(sum);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testProgressiveTaxVarTwo() {
        //arrange
        double sum = 10000, expected = 10000 * 0.1;

        //act
        double result = progressiveTax.calculateTaxFor(sum);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIncomeTax() {
        //arrange
        double sum = 50000, expected = 50000 * 0.13;

        //act
        double result = incomeTax.calculateTaxFor(sum);

        //assert
        Assertions.assertEquals(expected, result);
    }
}