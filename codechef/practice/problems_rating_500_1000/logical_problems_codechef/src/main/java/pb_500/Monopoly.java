package pb_500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Monopoly {

    static void main() {
        System.out.println("Monopoly");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        int [] profits = new int[4];

        while (numTest-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            profits[0] = a;
            profits[1] = b;
            profits[2] = c;
            profits[3] = d;

            int total = Arrays.stream(profits).sum();
            int max = Arrays.stream(profits).max().getAsInt();
            int sum = total - max;

            System.out.println("Sum = " + sum);
            if(max > sum){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
