package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*
1. Bir class oluşturun: LocatorsIntro
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
 a. http://a.testaddressbook.com adresine gidiniz.
  b. Sign in butonuna basin
 c. email textbox,password textbox, and signin button elementlerini locate ediniz..
 d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
 i. Username : testtechproed@gmail.com
 ii. Password : Test1234!
 e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
 f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
 doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun.
4.Linkleri yazdıralım...

 */

public class LocatorsIntro {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\niluf\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/");
// <a id="sign-in" class="nav-item nav-link" data-test="sign-in" href="/sign_in">Sign in</a>

        WebElement signInLinki=driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox=driver.findElement(By.id("session_password"));
        WebElement signInButonu=driver.findElement(By.name("commit"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();
        WebElement kullaniciAdi=driver.findElement(By.className("navbar-text"));
        if (kullaniciAdi.isDisplayed()){
            System.out.println("Kullanici adi testtechproed@gmail.com PASS");
        }else{
            System.out.println("Kullanici adi testtechproed@gmail.com FAILED");
        }
        WebElement adresLinki=driver.findElement(By.linkText("Addresses"));
        if (adresLinki.isDisplayed()){
            System.out.println("adres linki göründü testi PASS");
        }else{
            System.out.println("adres linki göründü testi FAILED");
        }
        WebElement signOutLinki=driver.findElement(By.linkText("Sign out"));
        if (signOutLinki.isDisplayed()){
            System.out.println("Sign out linki göründü testi PASS");
        }else{
            System.out.println("Sign out linki göründü testi FAILED");
        }
        List<WebElement> linklistesi=driver.findElements(By.tagName("a"));
        System.out.println("Sayfada "+linklistesi.size()+ " tane link var");
        for (WebElement w:linklistesi){
            System.out.println(w.getText());

        }

        driver.close();



    }
}
