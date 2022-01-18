package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.junit.Assert.*;

public class TestNGUI {
    WebDriver driver = null;
    JavascriptExecutor js = null;
    Variables var = new Variables();


    private static class Variables {
        String MyStor_Home = "https://www.gumtree.co.za";
        String chrome_path = "C:\\Users\\malusi.msomi\\Documents\\GitHub\\TestNG-attempt\\src\\main\\resources\\drivers\\chromedriver.exe";
        String gumtree_label = "/html/body/div[1]/div[3]/header/div[3]/nav/div[2]/span/span[contains(@class,\"label\")]";
        String cache_proceed_btn = "/html/body//div[2]/button[contains(.,\"Proceed\")]";
        String username_field = "//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"input-main\", \" \" ))]";
        String password_field = "/html/body/div[1]/section/div[2]/div/div/div[2]/div[4]/form/div[2]/input";
        String login_button = "/html/body//form/div[4]/div[2]/button[contains(.,\"Log In\")]";
        String valid_username = "Malusi2051@gmail.com";
        String invalid_username = "Malusi@test.com";
        String valid_password = "Legend!@12";
        String invalid_password = "1234";
        String Error_test = "/html/body/div[1]/section/div[2]/div/div/div[1]";
        String password_error_dialog = "//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"login-form-error\", \" \" ))]";
        String getPassword_error_text = "Please correct the errors in red below.";

    }

    public void SetChromeBrowserDriver(){
        System.setProperty("webdriver.chrome.driver",var.chrome_path);
        driver = new ChromeDriver();

    }
    @BeforeMethod
    public void Load_Browser_and_navigate_to_registration(){
        SetChromeBrowserDriver();
        js = (JavascriptExecutor) driver;
        driver.get(var.MyStor_Home);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(var.gumtree_label)).isDisplayed();
        verifyHomePageLoad();
    }

    public void verifyHomePageLoad(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = driver.getCurrentUrl();
        UserCurrentPage(url);
    }
    public void UserCurrentPage(String url){
        if(url.equals("https://www.gumtree.co.za")){
            System.out.println("Correct page is being presented to the user");
        } else {
            System.out.println("User is presented with another page");
        }
    }

    @Test (priority = 1)
    public void Valid_Login_Test(){
        User_Login(var.valid_username,var.valid_password);
    }

    @Test (priority = 2)
    public void Invalid_Login_Test(){
        User_Login(var.invalid_username,var.invalid_password);
    }

    public void User_Login(String username, String password){
        click_proceed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        enter_login_details(username,var.username_field);
        enter_login_details(password, var.password_field);
        click_login_button();
        verify_login();
    }
    public void verify_login(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean found = driver.findElement(By.xpath(var.login_button)).isDisplayed();
        System.out.println(found);
        if (found){
            Incorrect_login();
        }
    }
    public void Incorrect_login(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(var.Error_test)).isDisplayed();
        String errorTest = driver.findElement(By.xpath(var.password_error_dialog)).getText();
        assertEquals(errorTest, var.getPassword_error_text);
        assertTrue(driver.findElement(By.xpath(var.login_button)).isDisplayed());
    }
    public void click_login_button(){
        driver.findElement(By.xpath(var.login_button)).isDisplayed();
        driver.findElement(By.xpath(var.login_button)).click();
    }
    public void enter_login_details(String string,String field){
        driver.findElement(By.xpath(field)).isDisplayed();
        driver.findElement(By.xpath(field)).click();
        driver.findElement(By.xpath(field)).sendKeys(string);
    }
    public void click_proceed(){
        driver.findElement(By.xpath(var.cache_proceed_btn)).isDisplayed();
        driver.findElement(By.xpath(var.cache_proceed_btn)).click();
        driver.findElement(By.xpath(var.gumtree_label)).isDisplayed();
        driver.findElement(By.xpath(var.gumtree_label)).click();
    }

    @AfterMethod
    public void close_the_browser(){
        driver.close();
    }
    @AfterClass
    public void quit_driver(){
        driver.quit();
    }
}
