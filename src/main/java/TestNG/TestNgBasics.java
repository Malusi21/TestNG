package TestNG;

import org.testng.annotations.*;

public class TestNgBasics {
    @BeforeClass //3
    public void Launch_browser(){
        System.out.println("Launch browser - BeforeClass");
    }

    @BeforeMethod //4 //7
    public void Enter_url(){
        System.out.println("Enter the url - BeforeMethod");
    }

    @BeforeTest //2
    public void login(){
        System.out.println("Login - BeforeTest");
    }

    @BeforeSuite //1
    public void SetUp(){
        System.out.println("setup test - BeforeSuite");
    }

    @Test //5
    public void GetGoogleTitle(){
        System.out.println("google test for the page title - Test");
    }

    @Test //8
    public void GetGoogleUrl(){
        System.out.println("google test for the url - Test");
    }
    @AfterMethod //6 //9
    public void Logout(){
        System.out.println("logout - AfterMethod");
    }

    @AfterTest //11
    public void ClearCookies(){
        System.out.println("clear browser cookies - AfterTest");
    }
    @AfterClass //10
    public void closeBrowser(){
        System.out.println("close browser - AfterClass");
    }
    @AfterSuite //12
    public void GenerateReport(){
        System.out.println("get report - AfterSuite");
    }
}
