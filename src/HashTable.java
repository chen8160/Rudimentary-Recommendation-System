/*
  @author Yuxiang Chem, YangTian
 */
import java.util.ArrayList;

public class HashTable {

    private ArrayList<Tuple>[] tupleLists;

    public HashTable(int size){
        //TODO: Constructor
        while(!isPrime(size)){
            size++;
        }
        tupleLists = new ArrayList[size];
        for (int i = 0; i < size; i++){
            tupleLists[i] = new ArrayList<Tuple>();
        }
    }

    public int maxLoad(){
        //TODO: return the max load of the hash table
        return 0;
    }

    public int averageLoad(){
        //TODO: return the avg load of the hash table
        return 0;
    }

    public int size(){
        //TODO: return the current size of the hash table
        return 0;
    }

    public int numElements(){
        //TODO: return the number of elements stored in the hash table
        return 0;
    }

    public int loadFactor(){
        //TODO: return the load factor
        return 0;
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
