package tests;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class TimeZoneTests extends BaseTest {

//    private final static String BASE_URL = "https://www.livescore.com/";
    private static String initialTime;

    @BeforeEach
    void closeCookiesBar() {

    }

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
        matchPage.newValueShouldBe(initDay,initTime,"+06:00", defaultShift);
//        int changedTime = tools.convertTimeToSeconds(matchPage.getValue());
//        int expectedTime = initTime-shiftHours-(8*3600);
//        matchPage.valueShouldBe(tools.convertMinutesToTime(expectedTime));








    }
}
