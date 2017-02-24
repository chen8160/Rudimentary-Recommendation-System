import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yuxiang Chem, YangTian
 */
public class NearestPoints {

    ArrayList<Float> pointSet;
    HashTable hashTable;

    public NearestPoints(String dataFile) {
        File f = new File(dataFile);
        pointSet = new ArrayList<>();

        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextFloat()) {
                pointSet.add(scan.nextFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public NearestPoints(ArrayList<Float> pointSet) {
        this.pointSet = pointSet;
    }

    public ArrayList<Float> naiveNearestPoints(float p) {

        ArrayList<Float> ret = new ArrayList<>();

        for (float point : pointSet) {
            if (Math.abs(point - p) <= 1) {
                ret.add(point);
            }
        }
        return ret;
    }

    public void buildDataStructure() {

        hashTable = new HashTable(2 * pointSet.size());

        for (float f : pointSet) {
            Tuple t = new Tuple((int) Math.floor(f), f);
            hashTable.add(t);
        }

    }

    public ArrayList<Float> npHashNearestPoints(float p) {

        ArrayList<Float> ret = new ArrayList<>();

        int index = (int) Math.floor(p) + 1;

        for (int i = index - 1; i <= index + 1; i++) {
            if (i < 0) {
                continue;
            }

            ArrayList<Tuple> nearPts = hashTable.search(i);

            for (Tuple point : nearPts) {
                if (Math.abs(point.getValue() - p) <= 1) {
                    ret.add(point.getValue());
                }
            }
        }

        return ret;
    }

    public void allNearestPointsNaive() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        for (float point : pointSet) {
            sb.append(point + ": ");
            ArrayList<Float> closePoints = naiveNearestPoints(point);
            sb.append(closePoints + "\n");
        }

        PrintWriter printWriter = new PrintWriter("NaiveSolution.txt");
        printWriter.write(sb.toString());
        printWriter.close();
    }

    public void allNearestPointsHash() throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        for (float point : pointSet){
            sb.append(point + ": ");
            ArrayList<Float> closePoints = npHashNearestPoints(point);
            sb.append(closePoints + "\n");
        }

        PrintWriter printWriter = new PrintWriter("HashSolution.txt");
        printWriter.write(sb.toString());
        printWriter.close();
    }
}
