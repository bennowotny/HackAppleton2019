import java.util.ArrayList;
import java.util.Comparator;

public class Transaction implements Comparable {

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

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Transaction)) return 0;

        return this.time.compareTo(((Transaction) o).time);
    }

}
