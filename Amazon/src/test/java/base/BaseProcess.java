package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseProcess{
	protected WebDriver driver;
	protected String menuLogin;
	protected String login;
	protected String emailInput;
	protected String passwordInput;
	protected String searchBox;
	protected String searchButton;
	protected String ikinciSayfaButonu;
	protected String ucuncuUrun;
	protected String listeyeEkleButonu;
	protected String wishListRadioButon;
	protected String createListButon;
	protected String listMenu;
	protected String wishListMenu;
	protected String deleteButonu;
	
	protected String getDeleteButonu() {
		//return deleteButonu="//*[@id=\"a-autoid-7\"]/span/input";
		return deleteButonu="/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[7]/div[3]/div/ul/li/span/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/span/a";
	}

	protected void setDeleteButonu(String deleteButonu) {
		this.deleteButonu = deleteButonu;
	}

	protected String getWishListMenu() {
		return wishListMenu="/html/body/div[2]/header/div/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[2]/div/a/span";
				//*[@id=\"nav-flyout-wl-items\"]/div/a[1]/span"
	}

	protected void setWishListMenu(String wishListMenu) {
		this.wishListMenu = wishListMenu;
	}

	protected String getListMenu() {
		return listMenu="//*[@id=\"nav-link-accountList\"]";
	}

	protected void setListMenu(String listMenu) {
		this.listMenu = listMenu;
	}

	protected String getCreateListButon() {
		return createListButon="//*[@id=\"WLNEW_create\"]/span/span/input";
	}

	protected void setCreateListButon(String createListButon) {
		this.createListButon = createListButon;
	}

	protected String getWishListRadioButon() {
		//return wishListRadioButon="//*[@id=\"WLNEW_section_wlType\"]/div[2]/div[2]/div/div/span/div/label/i";
		return wishListRadioButon="//*[@id=\"a-popover-8\"]/div/header/button";
	}

	protected void setWishListRadioButon(String wishListRadioButon) {
		this.wishListRadioButon = wishListRadioButon;
	}

	protected String getUcuncuUrun() {
		return ucuncuUrun="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[3]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2";
	}

	protected void setUcuncuUrun(String ucuncuUrun) {
		this.ucuncuUrun = ucuncuUrun;
	}

	protected String getListeyeEkleButonu() {
		return listeyeEkleButonu="//*[@id=\"add-to-wishlist-button-submit\"]";
	}

	protected void setListeyeEkleButonu(String listeyeEkleButonu) {
		this.listeyeEkleButonu = listeyeEkleButonu;
	}

	protected String getIkinciSayfaButonu() {
		return ikinciSayfaButonu="//*[@id=\"search\"]/div[1]/div[2]/div/span[7]/div/span/div/div/ul/li[3]/a";
	}

	protected void setIkinciSayfaButonu(String ikinciSayfaButonu) {
		this.ikinciSayfaButonu = ikinciSayfaButonu;
	}

	protected String getSearchButton() {
		return searchButton="//*[@id=\"nav-search\"]/form/div[2]/div/input";
	}

	protected void setSearchButton(String searchButton) {
		this.searchButton = searchButton;
	}

	protected String getSearchBox() {
		return searchBox="//*[@id=\"twotabsearchtextbox\"]";
	}

	protected void setSearchBox(String searchBox) {
		this.searchBox = searchBox;
	}

	protected String getMenuLogin() {
		return menuLogin="//*[@id=\"nav-link-accountList\"]";
	}

	protected void setMenuLogin(String menuLogin) {
		this.menuLogin = menuLogin;
	}

	protected String getLogin() {
		return login="//*[@id=\"nav-flyout-ya-signin\"]/a/span";
	}

	protected void setLogin(String login) {
		this.login = login;
	}

	protected String getEmailInput() {
		return emailInput="//*[@id=\"ap_email\"]";
//		return emailInput="/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[1]/input[1]";
	}

	protected void setEmailInput(String emailInput) {
		this.emailInput = emailInput;
	}

	protected String getPasswordInput() {
		return passwordInput="//*[@id=\"ap_password\"]";
	}

	protected void setPasswordInput(String passwordInput) {
		this.passwordInput = passwordInput;
	}

	// websayfası yolu
	protected void sistemKurulum(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\base\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	// xpath
	protected WebElement xPath(String xPathText) throws Exception {
		return driver.findElement(By.xpath(xPathText));
	}

	// id
	protected WebElement id(String idText) throws Exception {
		return driver.findElement(By.id(idText));
	}

	// classname
	protected WebElement className(String classNameText) throws Exception {
		return driver.findElement(By.className(classNameText));
	}

	// xpath ile click işlemi
	protected void clickXPath(String xPathText) throws Exception {
		xPath(xPathText).click();
	}
	
	// id ile click işlemi
		protected void clickId(String idText) throws Exception {
			id(idText).click();
		}

	// Bekleme Suresi
	protected void beklemeSuresi(long time) throws InterruptedException {
		Thread.sleep(time);
	}

	// sendkey xpath
	protected void sendKeyXPath(String xPathText, String message) throws Exception {
		xPath(xPathText).sendKeys(message);
	}
	
	//sendkey id
	protected void sendKeyId(String idText, String message) throws Exception {
		id(idText).sendKeys(message);
	}
	
}
