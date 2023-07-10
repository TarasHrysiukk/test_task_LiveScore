package tests;

import static com.codeborne.selenide.Selenide.*;

import tools.Tools;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.BurgerMenuPage;
import pages.MainPage;
import pages.MatchPage;
import pages.SettingsPage;

abstract public class BaseTest {
    MainPage mainPage = new MainPage();
    MatchPage matchPage = new MatchPage();
    BurgerMenuPage burgerMenu = new BurgerMenuPage();
    SettingsPage settings = new SettingsPage();
    Tools tools = new Tools();

    private final static String BASE_URL = "https://www.livescore.com/";

    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void init() {
        setup();
        open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
