package tools;

public class Tools {

//    public int convertTimeToMinutes(String timeString) {
//        String[] parts = timeString.split(":");
//        int hours = Integer.parseInt(parts[0]);
//        int minutes = Integer.parseInt(parts[1]);
//
//        int totalSeconds = (hours * 60 ) + (minutes);
//        return totalSeconds;
//    }

    public String convertMinutesToTime(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        String timeString = String.format("%02d:%02d", hours, minutes);
        return timeString;
    }

    public int convertTimeToMinutes(String timeString) {
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        return (hours * 60) + minutes;
    }

//    public int getDay(String dayMonth) {
//        String[] parts = dayMonth.split(" ");
//        int day = Integer.parseInt(parts[0]);
//        String month = parts[1];
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM");
//        int year = LocalDate.now().getYear();
//        LocalDate date = LocalDate.parse(day + " " + month, formatter).withYear(year);
//        int dayOfYear = date.getDayOfYear();
//
//        return dayOfYear;
//    }
//
//    public String getShiftedDate(String startTime, String dayNumber, int shiftDays) {
//        // Розбиваємо час початку на години та хвилини
//        String[] timeParts = startTime.split(":");
//        int hours = Integer.parseInt(timeParts[0]);
//        int minutes = Integer.parseInt(timeParts[1]);
//
//        // Отримуємо загальну кількість днів від 1 січня до заданого дня
//        int dayOfYear = getDay(dayNumber);
//
//        // Отримуємо поточний рік
//        int year = LocalDate.now().getYear();
//
//        // Створюємо дату з заданими роком та порядковим номером дня
//        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);
//
//        // Зсуваємо дату на задану кількість днів
//        LocalDate shiftedDate = date.plusDays(shiftDays);
//
//        // Отримуємо зсунутий порядковий номер дня
//        int shiftedDayOfYear = shiftedDate.getDayOfYear();
//
//        // Форматуємо зсунуту дату у вигляді "dd MMM"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM");
//        String shiftedDateStr = shiftedDate.format(formatter);
//
//        // Повертаємо зсунуту дату та час у форматі "dd MMM hh:mm"
//        return shiftedDateStr + " " + String.format("%02d", hours) + ":" + String.format("%02d", minutes);
//    }
}
