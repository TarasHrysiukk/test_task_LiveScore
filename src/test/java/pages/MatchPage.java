package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MatchPage {

    public final SelenideElement scoreOrTime = $x("//span[@id= 'score-or-time']");
    public final SelenideElement day = $x("//span[@id= 'score-or-time']/following-sibling::span");

    public String getValue() {
        return scoreOrTime.getOwnText();
    }

    public String getDay() {
        return day.getOwnText();
    }

    public void valueShouldBe(String value) {
        assert getValue().equals(value);
    }

    public void shouldBeOpened() {
        scoreOrTime.shouldBe(visible, Duration.ofSeconds(4));
    }

    public void newValueShouldBe(String startDay, String startTime, String timezone, String defaultShift) {
        valueShouldBe(calculateShiftedDateTime(startDay, startTime, timezone, defaultShift));
    }

    public String calculateShiftedDateTime(String startDay, String startTime, String newTimeZone, String defaultTimeZone) {
        String[] timeParts = startTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        String[] currentOffsetParts = defaultTimeZone.split(":");
        int currentOffsetHours = Integer.parseInt(currentOffsetParts[0]);

        String[] newOffsetParts = newTimeZone.split(":");
        int newOffsetHours = Integer.parseInt(newOffsetParts[0]);

        // Розрахунок зсуву часового поясу
        int offset = newOffsetHours - currentOffsetHours;

        // Додавання зсуву до часу початку ефіру
        hours += offset;

        // Обробка перенесення години на наступний день
        if (hours >= 24) {
            hours -= 24;
        }

        // Форматування зсунутого часу
        String shiftedStartTime = String.format("%02d:%02d", hours, minutes);

        return shiftedStartTime;
    }

}
