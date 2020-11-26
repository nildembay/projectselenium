package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1. Bir class oluşturun : GoogleSearchTest
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        a.google web sayfasına gidin. https://www.google.com/
        b. Search(ara) “city bike”
        c. Google'da görüntülenen ilgili sonuçların sayısını yazdırın
        d. “Shopping” e tıklayın.
        e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
 */
public class GoogleSearchTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\niluf\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchBox=driver.findElement(By.name("q"));
        String arananKelime = "city bike";
        searchBox.sendKeys(arananKelime+ Keys.ENTER);

        WebElement sonucSayisi=driver.findElement(By.id("result-stats"));
        System.out.println("city bike icin sonuc sayisi \"" +sonucSayisi.getText()+"\"");

        WebElement alisverisLinki=driver.findElement(By.linkText("Alışveriş"));
        alisverisLinki.click();

        driver.findElement(By.id("srpresultimg_15970114592076028408_1_0")).click();

        driver.close();
    }

}
