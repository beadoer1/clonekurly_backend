package com.sparta.clonekurly;

// 셀레니움 동작을 위해서는 셀레니움 라이브러리와 웹 드라이버 설치가 필요해용
// https://www.selenium.dev/documentation/ko/selenium_installation/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();
    }

    //WebDriver
    private WebDriver driver;
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "drivers/chromedriver";
    //크롤링 할 URL
    private String base_url;

    // 생성자
    public SeleniumTest() {
        super();
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.kurly.com/shop/goods/goods_view.php?&goodsno=65548";
    }
    // 메서
    public void crawl() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            System.out.println(driver.getPageSource());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}
