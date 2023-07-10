package tests;

import org.junit.jupiter.api.Test;

public class TimeZoneTests extends BaseTest {

    @Test
    void checkTimeZone() {
        mainPage.calendarShouldBeVisible();
        mainPage.closeCookiesBar();
        mainPage.selectDayInMatchCalendar(3);
        mainPage.selectMatchWithIndex(0);
        //day and hours before changes timezone
        String initTime = matchPage.getValue();
        String initDay = matchPage.getDay();

        burgerMenu.open();
        burgerMenu.shouldBeOpened();
        burgerMenu.electSettingItem();

        settings.shouldBeVisible();
        String defaultShift = settings.getDefaultTimeShift();
        settings.openTimeZoneSelector();
        settings.timeZoneDropdownShouldBeOpened();
        settings.selectTimezone("+06:00"); //hardcoded value
        settings.applyButtonShouldBeVisible();
        settings.applyChanges();

        matchPage.shouldBeOpened();
        matchPage.newValueShouldBe(initDay, initTime, "+06:00", defaultShift);
    }
}
