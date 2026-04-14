package pb_500;

import java.util.Scanner;

public class ExpertSetter {

    static void main() {
        System.out.println("Expert setter");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        while(numTest-- > 0) {

            // problems
            int x  = sc.nextInt();
            int y = sc.nextInt();

            double  perc = (double)(y * 100) /  x;
            System.out.println(perc);
            if(perc >= 50){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
