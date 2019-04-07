import java.io.File;
import java.io.FileOutputStream;

public class RandomGenerator {

    public static int index;
    public static int[] numbersToBeChosen = new int[15];
    public static String[] names = new String[15];
    public static String[] locations = new String[2];

    public static void main(String args[]) {
        populateNumbersToBeChosen();
        populateNames();
        populateLocations();
        writeToFile(totalItemData());
    }

    //POPULATORS

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

    public static void populateLocations(){
        locations[0] = "Hortonville";
        locations[1] = "Appleton North";
    }

    public static void populateNumbersToBeChosen(){
        for(int ii = 0; ii < numbersToBeChosen.length; ii++){
            numbersToBeChosen[ii] = ii;
        }
    }

    public static int getRandomQuantity(){
        return (int) (Math.random() *5);
    }

    public static String getRandomLocation(){
        int locIndex = ((int) (Math.random() * 1));
        return locations[locIndex];
    }

    //ACCESSORS

    public static String getNameAndPrice() {

        String name = names[getIndex()];
        double price;

        switch (name) {

            case "banana":
                price = 4.99;
                break;
            case "apple":
                price = .69;
                break;
            case "muffin":
                price = 2.99;
                break;
            case "milk":
                price = 5.99;
                break;
            case "eggs":
                price = 3.29;
                break;
            case "gum":
                price = .99;
                break;
            case "sandwich":
                price = 3.29;
                break;
            case "bread":
                price = 3.29;
                break;
            case "pizza":
                price = 1.99;
                break;
            case "nachos":
                price = 1.99;
                break;
            case "donut":
                price = 2.29;
                break;
            case "skittles":
                price = .99;
                break;
            case "M&Ms":
                price = .99;
                break;
            case "energy drink":
                price = 4.99;
                break;
            case "chips":
                price = 1.99;
                break;
            default:
                name = "error";
                price = 3.00;
                break;
        }

        return name+","+price;

    }

    public static String getRandomDate(){
        int month;
        int day;
        int year;
        String total;

        month = 1+((int) (Math.random() * 12));
        day = 1+((int) (Math.random() * 31));
        year = ((int) (Math.random() * 2)+2017);

        return month+"-"+day+"-"+year;

    }

    public static String getRandomTime() {
        int hour;
        int minutes;
        int seconds;

        hour = 1 + ((int) (Math.random() * 24));
        minutes = ((int) (Math.random() * 60));
        seconds = ((int) (Math.random() * 60));

        return hour + ":" + minutes + ":" + seconds;
    }

    public static int getIndex(){
        index = (int) (Math.random() * 16);
        int deltaChange = (int) (Math.random() * 5)-2;

        if(numbersToBeChosen[index] < 2){
            numbersToBeChosen[index] += deltaChange;
        }

        return numbersToBeChosen[index];
    }

    //FINAL OUTPUT THINGS

    public static String getItemDetails(){
        String getDetails;
        String nameAndPrice = getNameAndPrice();
        String location = getRandomLocation();
        String quantity = getRandomQuantity()+"";

        getDetails = "["+nameAndPrice+","+quantity+"],"+location;

        return getDetails;
    }

    public static String createData(){
        String totalData = "";
        String totalDate = getRandomDate();
        String totalTime = getRandomTime();

        totalData += totalDate+","+totalTime+",";

        return totalData;
    }

    public static String totalItemData(){
        String totalItemData = createData()+getItemDetails();
        return totalItemData;
    }

    public static void writeToFile(Object o){
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


