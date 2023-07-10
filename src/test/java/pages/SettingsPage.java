package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class SettingsPage {

    private final SelenideElement timeZoneSelector = $x("//div[@id='TZ_SELECT']");
    private final SelenideElement timeZoneDropdown = $x("//div[@class='Si selectItems']");
    private final SelenideElement applyButton = $x("//button[@data-testid='settings-form_apply-button']");

    public void shouldBeVisible() {
        timeZoneSelector.shouldBe(visible, Duration.ofSeconds(4));
    }

    public void openTimeZoneSelector() {
        timeZoneSelector.click();
    }

    public void timeZoneDropdownShouldBeOpened() {
        timeZoneDropdown.shouldBe(visible, Duration.ofSeconds(4));
    }

    public void selectTimezone(String timeZone) {
        $x("//div[(text()= 'UTC " + timeZone + "')]").click();
    }

    public void applyChanges() {
        applyButton.click();
    }

    public void applyButtonShouldBeVisible() {
        applyButton.shouldBe(visible, Duration.ofSeconds(4));
    }

    public String getDefaultTimeShift() {
        return timeZoneSelector.$x("./label").getOwnText().replace("UTC ", "");
    }

}
