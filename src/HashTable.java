/*
  @author Yuxiang Chem, YangTian
 */
import java.util.ArrayList;

public class HashTable {

    private ArrayList<Tuple>[] tupleLists;
    private int numElements;

    public HashTable(int numElements){
        while(!isPrime(numElements)){
            numElements++;
        }
        tupleLists = new ArrayList[numElements];
        for (int i = 0; i < numElements; i++){
            tupleLists[i] = new ArrayList<Tuple>();
        }
    }

    public int maxLoad(){
        int ret = 0;
        for (int i = 0; i < tupleLists.length; i++){
            ret = Math.max(ret, tupleLists[i].size());
        }
        return ret;
    }

    public int averageLoad(){
        int base = 0;
        for (int i = 0; i < tupleLists.length; i++){
            if (tupleLists[i].size() != 0)
                base++;
        }
        return numElements / base;         //What Happens when base is 0???
    }

    public int size(){
        return tupleLists.length;
    }

    public int numElements(){
        return numElements;
    }

    public int loadFactor(){
        return numElements / tupleLists.length;
    }

    public void add(Tuple t){
        //TODO: add the tuple t to the hash table. Resize if necessary
    }

    public ArrayList<Tuple> search(int k){
        //TODO: return an arraylist of tuples, which key==k
        return null;
    }

    public void remove(Tuple t){
        //TODO: remove tuple t from the hash table
    }

    private boolean isPrime(int n){

        if (n % 2 == 0 || n % 3 == 0){
            return false;
        }

        int root = (int) Math.sqrt(n);

        for (int i = 5; i<= root; i += 6){
            if (n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }

        return true;
    }

}
