package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorePage {
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(xpath = "//a[normalize-space()='Sneakers']")
    WebElement sneakersFilterButton;

    @FindBy(id = "low-price")
    WebElement minPriceFilter;

    @FindBy(id = "a-autoid-1")
    WebElement goButton;

    @FindBy(xpath = "//*[contains(@data-component-type,'s-search-result')]")
    List<WebElement> allSneakers;

    public Map<String, String> getAllDistinctProducts() {
        Map<String, String> result = new HashMap<>();
        for (WebElement el : allSneakers) {

            String name = el.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal")).getText();
            try{ String listOfPrices = el.findElement(By.cssSelector(".a-row.a-size-base.a-color-base")).getText();
                result.put(name, listOfPrices);
            }
            catch(Exception ex){
                result.put(name, "$0.00");
            }
        }
        return result;
    }

    public void searchProduct(String text) {
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void setMinPriceFilter(String text) {
        minPriceFilter.sendKeys(text);
    }

    public void setSneakersType() {
        sneakersFilterButton.click();
    }

    public void goSearch() {
        goButton.click();
    }
}
