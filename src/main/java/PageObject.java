import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class PageObject {
    private WebDriver driver;

    //Constructor
    public PageObject(WebDriver driver) {
        this.driver = driver;
     }

    public WebElement homeLink(){
       return driver.findElement(By.xpath("//*[@id='sub-brand-bar-container']/section/ul/li[1]/a"));
    }
    /*public WebElement cookwareLink(){
        return driver.findElement(By.xpath("//*[@id='topnav-container']/ul/li[1]/a"));
    }*/

    public WebElement topLink(String linkText){
         String topLinkXpath =  "//a[contains(@href,'cm_type=gnav')][contains(text(),'" + linkText + "')]";
         return driver.findElement(By.xpath(topLinkXpath));
    }

    public WebElement menuItemLink(String menuText){
        String menuItemXpath = "//a[contains(@href, 'cm_type=lnav')][contains(text(), '" + menuText + "')]";
        WebElement menuItem = driver.findElement(By.xpath(menuItemXpath));
        return menuItem;
    }

    public WebElement itemLink(String itemText){
        String itemXpath = "//a[contains(., '" + itemText + "')]";
        WebElement item = driver.findElement(By.xpath(itemXpath));
        return item;
    }

    public WebElement addToCartLink(){
        return driver.findElement(By.xpath("//*[@id=\"pip\"]/div[1]/div[6]/div[2]/div[2]/section/div/div/fieldset[1]/button/span"));
    }

    public WebElement popupCloseLink(){
        return driver.findElement(By.xpath("//a[@title='Close' and contains(@class, 'overlayCloseX')]"));
    }

    public WebElement checkoutLink(){
        return driver.findElement(By.xpath("//*[@id=\"anchor-btn-checkout\"]"));
    }

    public WebElement saveForLaterLink(){
       return  driver.findElement(By.xpath("//a[contains(., 'Save For Later')]"));
    }

    public WebElement cartLink(){
        return  driver.findElement(By.xpath("//a[@class='view-cart'][contains(text(),'Cart')]"));
    }

    public void clickHome(){
        homeLink().click();
    }

    public void clickTopLink(String linkText){
        topLink(linkText).click();
    }

   /* public void clickCookware(){
        cookwareLink().click();
    }*/

    public void  clickMenuItem(String menuText){
        menuItemLink(menuText).click();
    }

    public void  clickItem(String itemText){
        itemLink(itemText).click();
    }

    public void clickAddToCart(){
        addToCartLink().click();
    }

    public void clickCheckout(){
        checkoutLink().click();
    }

    public void clickSaveForLater(){
        saveForLaterLink().click();
    }

    public void clickCart(){
        cartLink().click();
    }

    //Verify given item exists in saved items list
    public boolean verifyItemExistsInSavedList(String itemText){
        int count = driver.findElements(By.xpath("a[contains(text(), '" + itemText + "')]")).size();
        if (count >= 0 ){
            return true;
        }
        else{
            return false;
        }
    }


}
