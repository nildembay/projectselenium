package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitleAndURL {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\niluf\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String actualResult=driver.getTitle();
        String expectedResult="google";
        if (actualResult.equals(expectedResult)){
            System.out.println("Page Title Testi PASS");
        }else{
            System.out.println("Page Title Testi FAILED");
            System.out.println("Actual result : "+actualResult);
        }
        {
            driver.navigate().to("https://www.youtube.com/");
            String actualResultUrl = driver.getCurrentUrl();
            String expectedResultUrl="www.youtube.com";
            if (actualResultUrl.equals(expectedResultUrl)) {
                System.out.println("actual URL Testi PASS");
            } else {
                System.out.println("actual URL Testi FAILED");
                System.out.println("Actual URL : "+actualResultUrl);
            }
                driver.close();
        }
    }
}
