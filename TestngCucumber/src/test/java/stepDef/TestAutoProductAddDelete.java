package stepDef;

import Base.DriverManager;
import Hooks.ApplicationHooks;
import Pages.AddIntoCartPage;
import Pages.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestAutoProductAddDelete {
	
	private AddIntoCartPage aip_obj=new AddIntoCartPage(DriverManager.getDriver());
	private String ProductName;
	private String ProductPrice;
	private CartPage cp_obj;

	
	
	@Given("^User is already having URL of Auto Application$")
	public void user_is_already_having_URL_of_Auto_Application() {
	   System.out.println("URL :http://automationpractice.com/index.php");
	   DriverManager.getDriver().get(ApplicationHooks.prop.getProperty("url"));
	}

	@Given("^sort dresses by Evening dress, large and dressy$")
	public void sort_dresses_by_Evening_dress_lasrge_and_dressy() {
		aip_obj.selectDress();
	    
	}

	@Given("^verify dress name and price$")
	public void verify_dress_name_and_price() {
	   this.ProductName=aip_obj.getDressName();
	   this.ProductPrice=aip_obj.getDressPrice();
	}

	@When("^clicks on Add to cart$")
	public void clicks_on_Add_to_cart() {
		cp_obj=aip_obj.addTocart();
		cp_obj.proceedToCheckout();
	}

	@When("^verify that added product is correct$")
	public void verify_that_added_product_is_correct() {
		String ProductOnCart=cp_obj.verifyProductName();
		String ProductPriceOnCart=cp_obj.verifyProductPrice();
		System.out.println("Is product name is correct as product page:"+ProductName.equals(ProductOnCart));
		System.out.println("Is product price is correct as product page:"+ProductPrice.equals(ProductPriceOnCart));
	}

	@Then("^Delete added product$")
	public void delete_added_product() {
		cp_obj.deleteProduct();
	}

	@Then("^Verify that product is deleted$")
	public void verify_that_product_is_deleted() {
	    System.out.println("Product is deleted Successful:"+cp_obj.VerifyDelete());
	    
	}

}
