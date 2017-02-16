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


    //Test if n is prime
    private boolean isPrime(int n){

        if (n == 1 || n == 2 || n == 3){
            return true;
        }

        int root = (int) Math.sqrt(n);

        for (int i = 2; i<= root; i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;

    }

}
