public class Time{

    //Allows for time computation
    //Format: MM-DD-YYYY,HH:MM:SS

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;


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
}
