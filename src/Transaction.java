import java.util.ArrayList;

public class Transaction {

    Time time;
    ArrayList<Item> items;
    double totalPrice;
    String location;

    public Transaction(String datetime, ArrayList<Item> items, String location){
        this.time = new Time(datetime);
        this.items = items;
        this.location = location;
        for(Item i : this.items){
            totalPrice+=i.getTotalPrice();
        }
    }

}
