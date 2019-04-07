import java.util.ArrayList;
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
        System.out.println(transactions);
    }
}
