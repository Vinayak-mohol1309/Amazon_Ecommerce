package java_selenium_project_pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutomationTest {
    public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Instantiate ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open Amazon website
        driver.get("https://www.amazon.com");

        // Perform a product search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.sendKeys(Keys.ENTER);

        // Click on the first product in the search results
        WebElement firstProduct = driver.findElement(By.cssSelector("div[data-component-type='s-search-result']"));
        firstProduct.click();

        // Check if the product page is loaded successfully
        WebElement productTitleElement = driver.findElement(By.id("productTitle"));
        String productTitle = productTitleElement.getText();
        System.out.println("Product Title: " + productTitle);

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Check if the product is successfully added to the cart
        WebElement cartCountElement = driver.findElement(By.id("nav-cart-count"));
        int cartCount = Integer.parseInt(cartCountElement.getText());
        if (cartCount == 1) {
            System.out.println("Product added to cart successfully.");
        } else {
            System.out.println("Failed to add product to cart.");
        }

        // Go to the cart page
        WebElement cartLink = driver.findElement(By.id("nav-cart"));
        cartLink.click();

        // Check if the cart is empty
        WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[contains(text(),'Your Amazon Cart is empty')]"));
        if (emptyCartMessage.isDisplayed()) {
            System.out.println("Product removed from cart successfully.");
        } else {
            System.out.println("Failed to remove product from cart.");
        }

        // Increase the quantity of the product in the cart
        WebElement quantityDropdown = driver.findElement(By.cssSelector("select[name='quantity']"));
        quantityDropdown.sendKeys(Keys.ARROW_DOWN);
        quantityDropdown.sendKeys(Keys.ENTER);

        // Check the updated quantity in the cart
        WebElement updatedQuantityElement = driver.findElement(By.cssSelector("span.a-dropdown-prompt"));
        String updatedQuantity = updatedQuantityElement.getText();
        System.out.println("Updated Quantity: " + updatedQuantity);

        // Proceed to checkout
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("input[name='proceedToRetailCheckout']"));
        proceedToCheckoutButton.click();

        // Fill in the shipping address
        WebElement addressInput = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
        addressInput.sendKeys("John Doe");

        // Fill in other address details

        // ...

        // Place the order
        WebElement placeOrderButton = driver.findElement(By.cssSelector("input[name='placeYourOrder1']"));
        placeOrderButton.click();

        // Verify the order confirmation
        WebElement orderConfirmationElement = driver.findElement(By.cssSelector(".a-alert-success h1"));
        String orderConfirmation = orderConfirmationElement.getText();
        System.out.println("Order Confirmation: " + orderConfirmation);

        // Close the browser
        driver.quit();
    }
}

