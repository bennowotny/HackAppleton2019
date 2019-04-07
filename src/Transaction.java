import java.util.ArrayList;
import java.util.Comparator;

public class Transaction implements Comparable {

    Time time;
    Item item;
    double totalPrice;
    String location;

    //CONSTRUCTORS

    public Transaction(String datetime, Item item, String location){
        this.time = new Time(datetime);
        this.item = item;
        this.location = location;
//        for(Item i : this.items){
//            totalPrice+=i.getTotalPrice();
//        }

    }

    //This methood compares the time of two transactions
    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Transaction)) return 0;

        return this.time.compareTo(((Transaction) o).time);
    }

}
