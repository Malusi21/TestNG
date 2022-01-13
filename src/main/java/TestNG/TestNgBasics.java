package TestNG;

import org.testng.annotations.*;

public class TestNgBasics {
    @BeforeClass //3
    public void Launch_browser(){
        System.out.println("Launch browser");
    }

    @BeforeMethod //4 //7
    public void Enter_url(){
        System.out.println("Enter the url");
    }

    @BeforeTest //2
    public void login(){
        System.out.println("Login");
    }

    @BeforeSuite //1
    public void SetUp(){
        System.out.println("setup test");
    }

    @Test //5
    public void GetGoogleTitle(){
        System.out.println("google test for the page title");
    }

    @Test //8
    public void GetGoogleUrl(){
        System.out.println("google test for the url");
    }
    @AfterMethod //6 //9
    public void Logout(){
        System.out.println("logout");
    }

    @AfterTest //11
    public void ClearCookies(){
        System.out.println("clear browser cookies");
    }
    @AfterClass //10
    public void closeBrowser(){
        System.out.println("close browser");
    }
    @AfterSuite //12
    public void GenerateReport(){
        System.out.println("get report");
    }
}
