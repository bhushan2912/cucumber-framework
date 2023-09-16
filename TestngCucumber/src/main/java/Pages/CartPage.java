package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public CartPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".layer_cart_cart .button-container a")
	private WebElement proceedToCheckout;
	
	@FindBy(css=".shopping_cart>a")
	private WebElement cart;
	
	@FindBy(css="#product_4_16_0_0 .cart_description>p>a")
	private WebElement AddedProductName;
	
	@FindBy(css="#product_4_16_0_0>:nth-child(4)>span>span")
	private WebElement AddedProductPrice;
	
	@FindBy(css=".cart_quantity_delete>i")
	private WebElement DeleteButton;
	
	@FindBy(xpath="//p[text()='Your shopping cart is empty.']")
	private WebElement emptycart;
	
	public void proceedToCheckout() {
		proceedToCheckout.click();;
	}
	public String verifyProductName() {
		return AddedProductName.getText();
	}
	public String verifyProductPrice() {
		return AddedProductPrice.getText();
	}
	public void deleteProduct() {
		DeleteButton.click();;
	}
	public boolean VerifyDelete() {
		cart.click();;
		return emptycart.isDisplayed();
	}

}
