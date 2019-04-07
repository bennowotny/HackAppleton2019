import java.util.ArrayList;

public class Item {

    double unitPrice;
    int quantity;
    String name;
    static ArrayList<Item> allItems = new ArrayList<>();

    //CONSTRUCTORS

    private Item(Item i, int quantity){
        this.unitPrice = Math.round(i.unitPrice*100)/100.;
        this.name = i.name;
        this.quantity = quantity;
    }

    public Item(String name, double unitPrice, int quantity){
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    //Returns an the data for each item of a specific name when the name is selected in the GUI
    public Item getItem(String name, int quantity){
        for(Item i : allItems){
            if(i.name.equals(name)) {
                return new Item(i, quantity);
            }
        }
        return null;
    }

    //Return the total price of any item group per purchase (2 Decimal Places)
    public double getTotalPrice(){
        return Math.round(quantity*unitPrice*100)/100.;
    }
}
