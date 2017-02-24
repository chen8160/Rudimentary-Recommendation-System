import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yuxiang Chem, YangTian
 */
public class NearestPoints {

    ArrayList<Float> pointSet;

    public NearestPoints(String dataFile) {
        File f = new File(dataFile);
        pointSet = new ArrayList<>();

        try{
            Scanner scan = new Scanner(f);
            while (scan.hasNextFloat()){
                pointSet.add(scan.nextFloat());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public NearestPoints(ArrayList<Float> pointSet) {
        this.pointSet = pointSet;
    }

    public ArrayList<Float> naiveNearestPoints(float p){

        ArrayList<Float> ret = new ArrayList<>();

        for (float point : pointSet) {
            if (Math.abs(point - p) <= 1) {
                ret.add(point);
            }
        }
        return ret;
    }

    public void buildDataStructure(){

    }

    public ArrayList<Float> npHashNearestPoints(float p){
        return null;
    }

    public void allNearestPointsNaive(){

    }

    public void allNearestPointsHash(){

    }
}
