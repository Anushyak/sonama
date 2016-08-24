import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomepageFunctions {
    private WebDriver driver;
    private PageObject pageObject;
    private static Logger logger;

    public HomepageFunctions(WebDriver driver){
        this.driver =  driver;
        pageObject = new PageObject(driver);
        logger = Logger.getLogger("HomepageFunctions");
        PropertyConfigurator.configure("log4j.properties");
    }

    //Add an item to Saved items list
    public void addItemToSaveForLater(String topMenuText, String menuText, String itemText){
        try {
            logger.info("in method addItemToSaveForLater");
            pageObject.clickTopLink(topMenuText);
            logger.info("in page: " + driver.getTitle());
            pageObject.clickMenuItem(menuText);
            logger.info("in page: " + driver.getTitle());
            pageObject.clickItem(itemText);
            logger.info("in page: " + driver.getTitle());
            pageObject.clickAddToCart();
            logger.info("in page: " + driver.getTitle());
            pageObject.clickCheckout();
            logger.info("in page: " + driver.getTitle());
            pageObject.clickSaveForLater();
            logger.info("in page: " + driver.getTitle());
            logger.info("Item: " + itemText + " successfully added to Saved item list");
        } catch(Exception e){
            logger.error(e);
        }
    }

    //Verify an item exists in saved item list
    public void verifyItemInSaveForLater(String itemText){
        try {
            navigateToHome();
            pageObject.clickCart();
            logger.info("in page: " + driver.getTitle());
            Assert.assertTrue(pageObject.verifyItemExistsInSavedList(itemText), "Item doesn't exist in the cart");
        }catch(Exception e){
            logger.error(e);
        }

    }

    //to navigate to home screen after each test
    public void navigateToHome(){
        try {
            pageObject.clickHome();
        }catch(Exception e){
            logger.error(e);
        }
    }
    //to close the popup appears in webpage
    public void closePopup(){
        logger.info("in close popup method");
        try {
            //pageObject.popupCloseLink().click();
            driver.findElement(By.xpath("//a[@title='Close' and contains(@class, 'overlayCloseX')]")).click();
            logger.info("home page popup closed");
        }catch(Exception e){
            logger.error(e);
        }
    }

}
