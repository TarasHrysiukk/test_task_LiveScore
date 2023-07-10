package pages;
/*
Main page - https://www.livescore.com/en/
*/

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class MainPage {
    private final SelenideElement matchCalendar = $x("//div[(@id='match-calendar__today')]");
    private final SelenideElement cookiesBarCloseButton = $x("//button[(@id='simpleCookieBarCloseButton')]/span/img");

    public void selectDayInMatchCalendar(int dayIndex) {
        matchCalendar.$x(".//a[@data-testid='" + dayIndex + "__match-calendar-link']").click();
    }

    public void selectMatchWithIndex(int index) {
        $x("//div[@id='14460__category-header']/following-sibling::div[starts-with(@id, '" + index + "')]")
                .shouldBe(visible, Duration.ofSeconds(4)).click();
    }

    public void calendarShouldBeVisible() {
        matchCalendar.shouldBe(visible, Duration.ofSeconds(4));
    }

    public void closeCookiesBar() {
        cookiesBarCloseButton.shouldBe(visible, Duration.ofSeconds(4)).click();
    }

}
