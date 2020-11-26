package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1. Yeni bir class olusturun (TekrarTesti)
2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını  doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa  doğru URL'yi yazdırın.
4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
5. Youtube sayfasina geri donun
6. RefrSayfayi yenileyin
7. Amazon sayfasina donun
8. Sayfayi tamsayfa yapin
9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa     doğru başlığı(Actual Title) yazdırın.
10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru  URL'yi yazdırın
11.Sayfayi kapatin
 */
public class TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\niluf\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to( "https://www.youtube.com/");
        String actualYoutubeTitle=driver.getTitle();
        String expectedYoutubeTitle="youtube";
        if (actualYoutubeTitle.equals(expectedYoutubeTitle)){
            System.out.println("Youtube Title Testi PASS");
        }else{
            System.out.println("Youtube Title Testi FAILED");
            System.out.println("Actual Youtube Title: "+ actualYoutubeTitle);
        }

        String actualYoutubeURL= driver.getCurrentUrl();
        String arananKelime="youtube";
        if (actualYoutubeURL.contains(arananKelime)){
            System.out.println("Youtube içerik testi : PASS ");

        }else
        {
            System.out.println("Yotube içerik testi : FAILED ");
            System.out.println("youtube URL "+arananKelime+" içermiyor");
        }
        driver.navigate().to("http://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().maximize();
        String actualAmazonTitle=driver.getTitle();
        String arananTitle="Amazon";

        if (actualAmazonTitle.contains(arananTitle)){
            System.out.println("Amazon title içerik testi PASS");

        }else
        {
            System.out.println("Amazon title içerik testi FAILED");
            System.out.println("mazon title "+ arananTitle +" içermiyor");
        }
        String actualAmazonUrl= driver.getCurrentUrl();
        String expectedAmazonUrl="https://www.amazon.com/";
        if (actualAmazonUrl.equals(expectedAmazonUrl)){
            System.out.println( "Amazon Url Testi PASS");

        }else
        {
            System.out.println("Amazon URL testi FAILED");
            System.out.println("Amazon URL= " +actualAmazonUrl);
        }
        driver.close();

    }
}
