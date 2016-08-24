import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class TestSonoma {
    WebDriver driver;
    HomepageFunctions homePage;
    CommonFunctions commonFunctions;
    private static Logger logger;

    @BeforeTest
    public void initialSetup()  {

        commonFunctions = new CommonFunctions();
        logger = Logger.getLogger("TestSonoma");
        PropertyConfigurator.configure("log4j.properties");
        driver = commonFunctions.getBrowser(driver, ".//src//main//resources");
        driver.get("http://www.williams-sonoma.com");
        homePage = new HomepageFunctions(driver);
        homePage.closePopup();
    }

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        logger.info("in @Beforemethod");
        homePage.navigateToHome();
    }

   @Test(dataProvider="getData")
   //Add an item to Saved Items List
   //Get test data from excel sheet to test different links
    public void test1(String topMenu, String leftMenu, String item){
       logger.info("in test1");
       //We can write as many tests as possible, just pass topmenu, leftmenu, item
      // homePage.addItemToSaveForLater("Cookware", "Tea Kettles", "Breville IQ Kettle Pure");
       homePage.addItemToSaveForLater(topMenu, leftMenu, item);
       homePage.verifyItemInSaveForLater(item);
    }

    @AfterMethod
    public void closeBrowser(){
       logger.info("in @AfterMethod");
        //driver.close();
    }

    @AfterTest
    public void closeTest(){
        logger.info("in @AfterTest");
        //driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        Object[][] data = commonFunctions.readFromInputSheet(".//src//main//resources//TestData.xlsx", "SavedItems");
        return data;
    }

}
