package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;


public class TaskPageVtiger{

	private WebDriver driver;
	public TaskPageVtiger(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Contacts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addcontact;
	
	@FindBy(id="select2-chosen-2")
	private WebElement selectdropdown;
	
	@FindBy(css="#select2-results-2>:nth-child(2)>div")
	private WebElement selectmr;
	
	@FindBy(css="input[name='firstname']")
	private WebElement firstNameInputField;
	
	@FindBy(css="input[name='lastname']")
	private WebElement lastNameInputField;
	
	@FindBy(css="input[name='mobile']")
	private WebElement mobileInputField;
	
	@FindBy(css="button[type='submit']")
	private WebElement submitbutton;
	
	@FindBy(css=".col-lg-7>:nth-child(2)>a")
	private WebElement allcontactsbutton;
	
	@FindBy(xpath="//a[text()='Patil']")
	private WebElement verify_new_created_contact;
	
	@FindBy(css="span[title='Atlas Jeniffer(admin)']")
	private WebElement logoutlink;
	
	@FindBy(id="menubar_item_right_LBL_SIGN_OUT")
	private WebElement signout;
	
	@FindBy(xpath="//tr[td[span[span[a[text()='Patil']]]]]/td[1]//input[@class='listViewEntriesCheckBox']")
	private WebElement checkbox;
	
	@FindBy(id="Contacts_listView_massAction_LBL_DELETE")
	private WebElement dltbutton;
	
	@FindBy(css="button[data-bb-handler='confirm']")
	private WebElement confirm;
	
	@FindBy(css="#listview-table tbody>tr>:nth-child(3) a")
	private WebElement listOfLastNames;
	
	@FindBy(css=".emptyRecordsContent")
	private WebElement noContacts;
	
	
	public void addContactButton() {
		ElementUtil.eu.clickOnElement(addcontact);
	}
	
	public void newContactCreate(String firstName,String lastName,String mobileNumber) {
		ElementUtil.eu.clickOnElement(selectdropdown);
		ElementUtil.eu.clickOnElement(selectmr);
		ElementUtil.eu.typeInput(firstNameInputField,firstName);
		ElementUtil.eu.typeInput(lastNameInputField,lastName);
		ElementUtil.eu.typeInput(mobileInputField,mobileNumber);
		ElementUtil.eu.clickOnElement(submitbutton);
		
	}
	public boolean checkNewlyCreatedContact() {
		ElementUtil.eu.clickOnElement(allcontactsbutton);
		
		return ElementUtil.eu.isElementExist(verify_new_created_contact);
	}
	
	public void deleteCreatedContact() {
		ElementUtil.eu.clickOnElement(dltbutton);
		ElementUtil.eu.clickOnElement(confirm);
		driver.navigate().refresh();
		
	}
	public void selectCheckboxOfContact() {
		ElementUtil.eu.clickOnElement(checkbox);
	}
	public void signOut() {
		ElementUtil.eu.clickOnElement(logoutlink);
		ElementUtil.eu.clickOnElement(signout);
	}
	public void checkContactDelete() {
	
		try {
			List<WebElement> lastName = driver.findElements(By.cssSelector("#listview-table tbody>tr>:nth-child(3) a"));
			int cntr=0;
			for(int i=0; i<lastName.size();i++) {
				WebElement listName = lastName.get(i);
				String lastName1 = listName.getText();
				
				String expectName= "Patil";
				if(lastName1.equals(expectName)) {
					cntr++;
				}
			}
			if(cntr==0) {
				System.out.println("Contact is deleted Successful..");
			}
			if(cntr==1){
				System.out.println("Contact is not deleted");
			}
		}
		catch(NoSuchElementException e) {
		}
	}
	
}
