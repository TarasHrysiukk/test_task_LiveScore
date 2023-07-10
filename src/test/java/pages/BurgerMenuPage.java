package pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class BurgerMenuPage {
    private final SelenideElement burgerMenuIcon = $x("//span[@id='burger-menu-open']");
    private final SelenideElement burgerMenuBody = $x("//div[@id='burger-menu-body']");
    private final SelenideElement settingsItem = $x("//a[@id='burger-menu__settings']");

    public void open() {
        burgerMenuIcon.click();
    }

    public void shouldBeOpened() {
        burgerMenuBody.getAttribute("class").matches(".*isActive");
    }

    public void electSettingItem() {
        settingsItem.click();
    }

}
