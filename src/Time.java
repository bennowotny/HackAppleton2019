import java.util.Comparator;

public class Time implements Comparable {

    //Allows for time computation
    //Format: MM-DD-YYYY,HH:MM:SS

    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;


    //Breaks a string apart into the time components
    public Time(String datetime){
        String date = datetime.split(",")[0], time = datetime.split(",")[1];
        year = Integer.parseInt(date.split("-")[2]);
        month = Integer.parseInt(date.split("-")[0]);
        day = Integer.parseInt(date.split("-")[1]);

        hour = Integer.parseInt(time.split(":")[0]);
        minute = Integer.parseInt(time.split(":")[1]);
        second = Integer.parseInt(time.split(":")[2]);

        if(hour < 0 || minute < 0 || second < 0 || hour > 23 || minute > 59 || second > 60 || month > 12 || month < 1 || day < 1 || day > 31)
            throw new IllegalArgumentException("Illegal Time Input");
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Time)) return false;
        Time t = (Time)obj;
        return year == t.year && month == t.month && day == t.day && hour == t.hour && minute == t.minute && second == t.second;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Time)) return 0;
        Time t1 = (Time)o;
        Time t2 = this;

        if(t1.equals(t2))return 0;
        else if(t1.year > t2.year || t1.month > t2.month || t1.day > t2.day || t1.hour > t2.hour || t1.minute > t2.minute || t1.second > t2.second)
            return 1;
        else return -1;
    }
}
