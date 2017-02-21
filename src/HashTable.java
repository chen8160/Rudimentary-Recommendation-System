/**
  @author Yuxiang Chem, YangTian
 */
import java.util.ArrayList;

public class HashTable {

    private ArrayList<Tuple>[] tupleLists;
    private int numElements;
    private HashFunction h;

    public HashTable(int numElements){
        while(!isPrime(numElements)){
            numElements++;
        }
        tupleLists = new ArrayList[numElements];
        for (int i = 0; i < numElements; i++){
            tupleLists[i] = new ArrayList<Tuple>();
        }
        h = new HashFunction(numElements);
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

    public double loadFactor(){
        return (double) numElements / tupleLists.length;
    }

    public void add(Tuple t){
        if (loadFactor() > 0.7){
            int newSize = size() * 2;
            while(!isPrime(newSize)){
                newSize++;
            }

            ArrayList<Tuple>[] newTupleLists = new ArrayList[newSize];
            h = new HashFunction(newSize);

            for (int i = 0; i < tupleLists.length; i++){
                for (int j = 0; j < tupleLists[i].size(); j++){
                    newTupleLists[h.hash(tupleLists[i].get(j).getKey())].add(tupleLists[i].get(j));
                }
            }

            tupleLists = newTupleLists;
        }

        tupleLists[h.hash(t.getKey())].add(t);
    }

    public ArrayList<Tuple> search(int k){

        ArrayList<Tuple> ret = new ArrayList<>();
        ArrayList<Tuple> keyList = tupleLists[h.hash(k)];

        for (Tuple t : keyList){
            if (t.getKey() == k){
                ret.add(t);
            }
        }

        return ret;
    }

    public void remove(Tuple t){
        ArrayList<Tuple> list = tupleLists[h.hash(t.getKey())];
        list.remove(t);
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
