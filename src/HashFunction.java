import java.util.Random;

/**
 * @author Yuxiang Chem, YangTian
 */
public class HashFunction {

    private int a, b, p;

    public HashFunction(int range){

        setP(range);
        Random r = new Random();
        a = r.nextInt(p);
        b = r.nextInt(p);

    }

    public int hash(int x){
        int hash = (a * x + b) % p;

        if (hash < 0){
            hash *= -1;
        }

        return hash;
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
        a = x % p;
    }

    public void setB(int y){
        b = y % p;
    }

    public void setP(int x){
        while(!isPrime(x)){
            x++;
        }
        p = x;

        Random r = new Random();
        a = r.nextInt(p);
        b = r.nextInt(p);
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
