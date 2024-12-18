package pages;

import Base.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends AbstractPage {
    private final By productSortFilter = By.cssSelector("select[data-test='product-sort-container']");
    private final By productPrice=By.cssSelector("[data-test='inventory-item-price']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void sortBy(String sorting){
        waitAndSelect(productSortFilter,sorting);
    }
    public List<String> getProductPricesList(){
        waitForVisible(productPrice);
        List<WebElement> elementList = driver.findElements(productPrice);
        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
