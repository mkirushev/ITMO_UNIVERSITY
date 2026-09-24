import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static double GetElement(float x, long e, Set<Integer> check){
        if (e == 18) {
            return Math.cbrt(0.25/(Math.cos(x) - 1));
        } else if (check.contains(e)) {
            return Math.pow(0.5/((1/3) + Math.asin(1/Math.exp(Math.abs(x)))), 3);
        } else {
            return Math.pow(Math.sin(Math.log(Math.pow(Math.abs(x) * (Math.abs(x) + 1), 2))), Math.asin(Math.sin(Math.pow(Math.exp(x), 0.75/(Math.log(Math.abs(x)))))) * (Math.sin(Math.pow((Math.exp(x)-0.25)/(Math.asin((x-1)/12)), 2)) - Math.PI));
        }
    }


    public static void print(double[][] n) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.printf("%.2f\t", n[i][j]);
            }
            System.out.println();
        }      
    }


    public static void main(String[] args) {
        long[] e = new long[10];
        int p = 0;

        for (int i = 6; i <= 24; i += 2) {
            e[p] = i;
            p++;
        }

        float[] x = new float[19];
        Random random = new Random();
        float min = -7.0f;
        float max = 5.0f;

        for (int i = 0; i < 19; i++) {
            x[i] = min + random.nextFloat() + (max - min);
        }

        double[][] n = new double[10][19];
        
        Set<Integer> check = new HashSet<>();
        for (int i = 8; i < 22; i+=2) {
            if (i == 12 || i == 18 || i == 20) {
                continue;
            } else {
                check.add(i);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                n[i][j] = GetElement(x[j], e[i], check);
            }
        }

        print(n);
    }
}
