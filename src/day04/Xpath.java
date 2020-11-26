package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/*
1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
2- Add Element butonuna basin
3- Delete butonu’nun gorunur oldugunu test edin
4- Delete tusuna basin
5- Delete butonunun gorunur olmadigini test edin
 */

public class Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\niluf\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement AddElementButon=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        AddElementButon.click();
        WebElement DeleteButon=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (DeleteButon.isDisplayed()){
            System.out.println("Delete buton gorundu testi-1 PASS");
        }else{
            System.out.println("Delete buton gorundu testi-1 FAILED");
        }
        DeleteButon.click();

    }
}
