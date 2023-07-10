package tools;

public class Tools {

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

}
