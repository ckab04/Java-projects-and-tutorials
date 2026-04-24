package pb_500;

import java.util.Scanner;

public class IsTheScoreConsistent {

    static void main() {
        System.out.println("Is the score consistent");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();


        while (numTest-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int c = sc.nextInt();
            int d = sc.nextInt();

            if(c >= a && d >= b){
                System.out.println("POSSIBLE");
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
