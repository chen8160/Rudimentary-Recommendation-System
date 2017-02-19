/**
 * @author Yuxiang Chem, YangTian
 */
public class HashFunction {

    private int a, b, p;

    public HashFunction(int range){
        //TODO: Constructor;
    }

    public int hash(int x){
        //TODO: Return the hash value of x
        return 0;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getP(){
        return p;
    }

    public void setA(int x){
        //TODO: update a
    }

    public void setB(int y){
        //TODO: update b
    }

    public void setP(int x){
        //TODO: update p
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
