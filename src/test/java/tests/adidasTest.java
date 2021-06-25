package tests;
import org.testng.annotations.Test;
import java.util.Map;

public class adidasTest extends BaseTest {
    @Test
    public void testcase1() {
        storePage.searchProduct("adidas shoes men");
        storePage.setSneakersType();
        storePage.setMinPriceFilter("40");
        storePage.goSearch();
        Map<String, String> mapOfDistinctSneakers = storePage.getAllDistinctProducts();
        mapOfDistinctSneakers.forEach((key, value) -> System.out.println(key + " --- " + value));
    }
}
