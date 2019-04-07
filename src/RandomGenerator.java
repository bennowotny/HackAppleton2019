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
        for(int i = 0; i < 500; i++)
            writeToFile(totalItemData());
    }

    //POPULATORS

    //This method populates the array of names of items
    public static void populateNames() {

        names[0] = "Banana";
        names[1] = "Apple";
        names[2] = "Muffin";
        names[3] = "Milk";
        names[4] = "Eggs";
        names[5] = "Gum";
        names[6] = "Sandwich";
        names[7] = "Bread";
        names[8] = "Pizza";
        names[9] = "Nachos";
        names[10] = "Donut";
        names[11] = "Skittles";
        names[12] = "M&Ms";
        names[13] = "Energy drink";
        names[14] = "Chips";

    }

    //This method populates the array of names of locations
    public static void populateLocations(){
        locations[0] = "Hortonville";
        locations[1] = "Appleton North";
    }

    //This method populates the numbers which are chosen to make the data follow a trend versus
    //random points which may have no correlation
    public static void populateNumbersToBeChosen(){
        for(int ii = 0; ii < numbersToBeChosen.length; ii++){
            numbersToBeChosen[ii] = ii;
        }
    }

    //This method calculates a random quantity which can be used anywhere
    public static int getRandomQuantity(){
        return (int) (Math.random() *5)+1;
    }

    //This method chooses a random location from the location array
    public static String getRandomLocation(){
        int locIndex = ((int) (Math.random() * locations.length));
        return locations[locIndex];
    }

    //ACCESSORS

    //This method returns the name and the price of an item
    public static String getNameAndPrice() {

        String name = names[getIndex()];
        double price = 0.0;

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
        }

        return name+","+price;

    }

    //This method returns a random date of purchase for an item
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

    //This method returns a random time of purchase for an item
    public static String getRandomTime() {
        int hour;
        int minutes;
        int seconds;

        hour = ((int) (Math.random() * 24));
        minutes = ((int) (Math.random() * 60));
        seconds = ((int) (Math.random() * 60));

        return hour + ":" + minutes + ":" + seconds;
    }

    //This method is used when the index is needed. It can add and subtract without IndexOutOfBoundsExceptions
    public static int getIndex(){
        index = (int) (Math.random() * 15);
        int deltaChange = (int) (Math.random() * 5)-2;

        if(numbersToBeChosen[index] < 2){
            numbersToBeChosen[index] += deltaChange;
        }

        return index;
    }

    //FINAL OUTPUT THINGS

    //This method gets the information for one item's transaction
    public static String getItemDetails(){
        String getDetails;
        String nameAndPrice = getNameAndPrice();
        String location = getRandomLocation();
        String quantity = getRandomQuantity()+"";

        getDetails = "["+nameAndPrice+","+quantity+"],"+location;

        return getDetails;
    }

    //This method gets the information for the date and time of an item's transaction
    public static String createData(){
        String totalData = "";
        String totalDate = getRandomDate();
        String totalTime = getRandomTime();

        totalData += totalDate+","+totalTime+",";

        return totalData;
    }

    //This method combines the information into the desired output
    public static String totalItemData(){
        String totalItemData = createData()+getItemDetails();
        return totalItemData;
    }

    //This method writes the output to a file for use
    public static void writeToFile(Object o){
        try {
            File outputFile = new File(".\\file1.txt");
            if(!outputFile.exists())outputFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(outputFile, true);
            String out = o.toString();
            fOut.write((out+"\n").getBytes());
            fOut.flush();
            fOut.close();
        }catch(Exception e){e.printStackTrace();}
    }
}


