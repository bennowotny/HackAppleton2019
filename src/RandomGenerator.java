import java.io.File;
import java.io.FileOutputStream;

public class RandomGenerator {

    public static int index;
    public static double price;
    public static int[] numbersToBeChosen = new int[15];
    public static String[] names = new String[15];

    public static void main(String args[]) {
        populateNumbersToBeChosen();
        populateNames();
    }

    public static void populateNames() {

        names[0] = "banana";
        names[1] = "apple";
        names[2] = "muffin";
        names[3] = "milk";
        names[4] = "eggs";
        names[5] = "gum";
        names[6] = "sandwich";
        names[7] = "bread";
        names[8] = "pizza";
        names[9] = "nachos";
        names[10] = "donut";
        names[11] = "skittles";
        names[12] = "M&Ms";
        names[13] = "energy drink";
        names[14] = "chips";
    }

    public static String chooseItem(){
        return names[getIndex()];
    }

    public double getPrice() {

        switch (index) {

            case 0:
                price = 4.99;
                break;
            case 1:
                price = .69;
                break;
            case 2:
                price = 2.99;
                break;
            case 3:
                price = 5.99;
                break;
            case 4:
                price = 3.29;
                break;
            case 5:
                price = .99;
                break;
            case 6:
                price = 3.29;
                break;
            case 7:
                price = 3.29;
                break;
            case 8:
                price = 1.99;
                break;
            case 9:
                price = 1.99;
                break;
            case 10:
                price = 2.29;
                break;
            case 11:
                price = .99;
                break;
            case 12:
                price = .99;
                break;
            case 13:
                price = 4.99;
                break;
            case 14:
                price = 1.99;
                break;
        }

        return price;

    }

    public String getRandomDate(){
        int month;
        int day;
        int year;
        String total;

        month = 1+((int) (Math.random() * 12));
        day = 1+((int) (Math.random() * 31));
        year = ((int) (Math.random() * 2)+2017);

        return month+"-"+day+"-"+year;

    }

    public String getRandomTime(){
        int hour;
        int minutes;
        int seconds;

        hour = 1+((int) (Math.random() * 24));
        minutes = ((int) (Math.random() * 60));
        seconds = ((int) (Math.random() * 60));

        return hour+":"+minutes+":"+seconds;
    }

    public static void populateNumbersToBeChosen(){
        for(int ii = 0; ii < numbersToBeChosen.length; ii++){
            numbersToBeChosen[ii] = ii;
        }
    }

    public static int getIndex(){
        index = (int) (Math.random() * 16);
        int deltaChange = (int) (Math.random() * 5)-2;

        numbersToBeChosen[index] = index + deltaChange;
        return numbersToBeChosen[index];
    }

    public static void getItemDetails(){
        String getDetails;
    }

    public String createData(){
        String totalData = "";
        String totalDate = getRandomDate();
        String totalTime = getRandomTime();

        totalData += totalDate+", "+totalTime+", ";

        return totalData;
    }

    public void writeToFile(Object o){
        try {
            File outputFile = new File(".\\file.txt");
            if(!outputFile.exists())outputFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(outputFile, true);
            String out = o.toString();
            fOut.write((out+"\n").getBytes());
            fOut.flush();
            fOut.close();
        }catch(Exception e){e.printStackTrace();}
    }
}


