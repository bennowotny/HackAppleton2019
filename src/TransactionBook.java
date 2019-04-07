import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TransactionBook {
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void saveTransactions(String in){
        String[] ts = in.split("\n");
        for(String s : ts){
            String[] fields = s.split(",");
            String[] item = s.split("\\[")[1].split(",");
            transactions.add(new Transaction(fields[0]+","+fields[1],new Item(item[0], Double.parseDouble(item[1]), Integer.parseInt(item[2].substring(0,item[2].length()-1))), fields[fields.length-1]));
        }
        transactions.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.compareTo(o2);
            }
        });

    }

    public String[] getUniqueItems(){
        if(transactions.size() == 0) return null;
        ArrayList<String> types = new ArrayList<>();
        for(Transaction t : transactions){
            if(!types.contains(t.item.name))types.add(t.item.name);
        }
        return types.toArray(new String[types.size()]);
    }

    public ArrayList<Transaction> getTypedTransactions(String name){
        //if(Arrays.binarySearch(getUniqueItems(), name) == -1) return null;
        ArrayList<Transaction> ts = new ArrayList<>();
        for(Transaction t : transactions){
            if(t.item.name.equals(name)) ts.add(t);
        }
        return ts;
    }
}
