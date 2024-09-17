package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Enum.MobilePage;
import Enum.Mobile;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddMultipleProductsToWishlistAndSelectOneProductFromWishlistAndAddItToCart extends BaseClass {

    String mobile = "//div[@class='%s']//img[@alt='%s']";
    String mobileDetail = "//a[@id='%s' and @class='%s']";
    String printMobileDetail = "//div[@class='%s']";
    String productColourXpath = "//div[@id='%s']//ul//li";
    String variantDetail = "//div[@class='%s']";
    String searchInput = "//input[@id='%s']";
    String expectedResult = "Samsung Galaxy M13 (Midnight Blue, 4GB, 64GB Storage) | 6000mAh Battery | Upto 8GB RAM with RAM Plus";
    By questionAndAnswerLink = By.xpath("//a[@id='askATFLink']");
    By seeMoreQuestionAndAnswer = By.partialLinkText("See more answered questions");
    By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    By clickOnCart = By.xpath("//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attach-sidesheet-view-cart-button-announce']");
    By quantity = By.xpath("//span[@class='a-button-text a-declarative']");
    By quantityDrop = By.xpath("//li[@aria-labelledby='quantity_4']");
    By subTotal = By.xpath("//div[@data-name='Subtotals' and @class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']");
    By checkBoxInput = By.xpath("//input[@id='sc-buy-box-gift-checkbox']");
    By productVerify = By.xpath("(//span[contains(text(),'Samsung Galaxy M13 (Midnight Blue, 4GB, 64GB Storage) | 6000mAh Battery | Upto 8GB RAM with RAM Plus')])[2]");

    @Given("Navigate to website.")
    public void navigate_to_website() throws IOException {
        Setup();
    }

    @And("Navigate to search section and search for mobiles")
    public void navigate_to_search_section_and_search_for_mobiles(DataTable productToSearch) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(searchInput, Mobile.searchInput.getTitle()))));
        List<List<String>> data = Collections.singletonList(productToSearch.values());
        driver.findElement(By.xpath(String.format(searchInput, Mobile.searchInput.getTitle()))).sendKeys(data.get(0).get(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(searchInput, Mobile.searchInput.getTitle()))));
        driver.findElement(By.xpath(String.format(searchInput, Mobile.searchButton.getTitle()))).click();
    }

    @And("Select the specific mobile, capture the Name of the product as displayed on UI")
    public void select_the_specific_mobile_capture_the_name_full_of_the_product_as_displayed_on_ui() {
        driver.findElement(By.xpath(String.format(mobile, MobilePage.samsungGalaxyM32.getTitle(), MobilePage.samsungGalaxyM32.getValue()))).click();
        String mainWindow = driver.getWindowHandle();
        ArrayList<String> childTabWindow = new ArrayList<>(driver.getWindowHandles());
        System.out.println(mainWindow);
        System.out.println(childTabWindow);
        driver.switchTo().window(String.valueOf(childTabWindow.get(1)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(mobileDetail, MobilePage.mobileDetail.getTitle(), MobilePage.mobileDetail.getValue()))));
        driver.findElement(By.xpath(String.format(mobileDetail, MobilePage.mobileDetail.getTitle(), MobilePage.mobileDetail.getValue())));
        List<WebElement> myElements = driver.findElements(By.xpath(String.format(String.format(printMobileDetail, Mobile.productTitle.getTitle()))));
        for (WebElement e : myElements) {
            System.out.println(e.getText());
        }
    }

    @And("Check for the Size Name and colors available and print the same on console.")
    public void check_for_the_size_name_and_colors_available_and_print_the_same_on_console() {
        List<WebElement> productColour;
        By productColourValueDisplayed = By.xpath("//div[@id='variation_color_name']//label[@class='a-form-label']//following::span[1]");
        productColour = driver.findElements(By.xpath(String.format(productColourXpath, Mobile.productColour.getTitle())));
        int numberOfProductColour = productColour.size();
        System.out.println(numberOfProductColour);
        for (WebElement webElement : productColour) {
            Actions action = new Actions(driver);
            action.moveToElement(webElement).perform();
            String productColourValue = driver.findElement(productColourValueDisplayed).getText();
            System.out.println(productColourValue);
        }
        List<WebElement> myElement = driver.findElements(By.xpath(String.format(String.format(variantDetail, Mobile.variantDetail.getTitle()))));
        for (WebElement f : myElement) {
            System.out.println(f.getText());
        }
    }

    @And("Navigate to Customer questions & answers and list top 3 questions and answers.")
    public void navigate_to_customer_questions_answers_and_list_top_questions_and_answers() {
        driver.findElement(questionAndAnswerLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(seeMoreQuestionAndAnswer));
        driver.findElement(seeMoreQuestionAndAnswer).click();
        List<WebElement> myElement = driver.findElements(By.xpath("//div[@class='a-fixed-left-grid-col a-col-right' and @style='padding-left:1%;float:left;']"));
        int count = 0;
        for (WebElement g : myElement) {
            System.out.println(g.getText());
            count++;
            if (count == 3) {
                break;
            }
        }
    }

    @And("Add the item to the cart, put assertion on the product added to cart.")
    public void add_the_item_to_the_cart_put_assertion_on_the_product_added_to_cart() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(3000,0)", "");
        act.moveToElement(driver.findElement(addToCartButton)).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCart));
        driver.findElement(clickOnCart).click();
        String VerifyingProduct = driver.findElement(productVerify).getText();
        Assert.assertEquals(VerifyingProduct, expectedResult);
    }

    @When("Navigate to Shopping Cart button, increase the order Quantity to.")
    public void navigate_to_shopping_cart_button_increase_the_order_quantity_to() {
        driver.findElement(quantity).click();
        wait.until(ExpectedConditions.elementToBeClickable(quantityDrop));
        driver.findElement(quantityDrop).click();
    }

    @Then("Verify the item quantity inside the cart and list the total amount for the order.")
    public void verify_the_item_quantity_inside_the_cart_and_list_the_total_amount_for_the_order() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxInput));
        driver.findElement(checkBoxInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(subTotal));
        String subtotalPrint = driver.findElement(subTotal).getText();
        System.out.println(subtotalPrint);
        close();
    }
}