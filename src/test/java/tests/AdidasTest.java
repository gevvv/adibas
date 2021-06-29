package tests;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.StorePage;

import java.util.Map;

public class AdidasTest extends BaseTest {
    @Test
    public void testcase1() {
        storePage = PageFactory.initElements(driver, StorePage.class);
        storePage.searchProduct("adidas shoes men");
        storePage.setSneakersType();
        storePage.setMinPriceFilter("40");
        storePage.goSearch();
        Map<String, String> mapOfDistinctSneakers = storePage.getAllDistinctProducts();
        mapOfDistinctSneakers.forEach((key, value) -> System.out.println(key + " --- " + value));
    }
}