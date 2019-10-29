import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseProcess;

public class TestClass extends BaseProcess {
	// Aşağıdaki fonksiyon ile ekran görüntüleri alınmakta ve belirtilen isimlerle
	// bu ekran görüntüleri Amazon projesi içerisinde oluşturulan ScreenShot
	// klasörüne kaydedilmektedir.
	protected void getScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/" + fileName + ".png"));
	}

	@Test(priority = 1)
	public void AnaSayfa() throws Exception {
		// 1. Adım
		sistemKurulum("https://www.amazon.com");
		beklemeSuresi(5000);
		getScreenShot("AnasayfaDogrulama");
	}

	@Test(priority = 2)
	public void LoginSayfasi() throws Exception {
		// 2. Adım
		beklemeSuresi(5000);
		clickXPath(getMenuLogin());
		beklemeSuresi(5000);
		clickXPath(getLogin());
		// Burada iki opsiyon var istenmesi durumunda tıklanıp mail adresi enter tuşuna
		// basılabilir veya devam butonuna tıklanılır
//Ben Actions üzerinden değer ve enterı tercih ettim bunun nedenide normal sendkeyden daha iyi sonuç alıyor olmam oldu
		Actions a = new Actions(driver);
		a.sendKeys("zeynepdinc.23@gmail.com").perform();
		a.sendKeys(Keys.ENTER).perform();
		a.sendKeys("123456").perform();
		a.sendKeys(Keys.ENTER).perform();
//		sendKeyXPath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[1]/input[1]", "zeynepdinc.23@gmail.com");
		// sendKeyId("ap_email", "zeynepdinc.23@gmail.com");
		// sendKeyXPath(getEmailInput(), "zeynepdinc.23@gmail.com"+Keys.ENTER);
		// clickXPath("//*[@id=\"continue\"]");
		beklemeSuresi(5000);

		// sendKeyXPath(getPasswordInput(), "123456");
		// clickXPath("//*[@id=\"signInSubmit\"]");
		getScreenShot("LoginEkranı");
	}

	@Test(priority = 3)
	public void AramaCubugu() throws Exception {
		// Adım 3
		beklemeSuresi(2000);
		sendKeyXPath(getSearchBox(), "samsung");
		beklemeSuresi(1000);
		clickXPath(getSearchButton());
	}

	@Test(priority = 4)
	public void SamsungSonuclari() throws Exception {
		// Adım 4
		Actions action = new Actions(driver);
		for (int i = 0; i < 8; i++) {
			action.sendKeys(Keys.PAGE_DOWN);
			beklemeSuresi(2000);
		}
		getScreenShot("SamsungBirinciEkran");
		// Adım 5
		clickXPath(getIkinciSayfaButonu());
		getScreenShot("SamsungIkinciEkran");
		beklemeSuresi(2000);
		action.sendKeys(Keys.PAGE_DOWN);
	}

	@Test(priority = 5)
	public void SamsungSonuclari2() throws Exception {
		// Adım 6
		clickXPath(getUcuncuUrun());
		beklemeSuresi(4000);
		clickXPath(getListeyeEkleButonu());
		beklemeSuresi(2000);
		clickXPath("/html/body/div[5]/div/div/header/button");
		beklemeSuresi(2000);
		// Adım 7
		clickXPath(getMenuLogin());
		beklemeSuresi(5000);
		clickXPath("/html/body/div[2]/header/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[2]/div/a");
		// Adım 8
		getScreenShot("wishListElements");
		beklemeSuresi(2000);
		// Adım 9
		clickXPath(getDeleteButonu());
		beklemeSuresi(5000);
		// Adım 10
		getScreenShot("urunSilindi");
	}

	@Test(priority = 6)
	private void son() throws Exception {
		// TODO Auto-generated method stub
		driver.quit();
	}
}
