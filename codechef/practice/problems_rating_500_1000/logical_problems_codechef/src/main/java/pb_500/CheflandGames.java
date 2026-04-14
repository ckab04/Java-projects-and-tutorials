package pb_500;

import java.util.Scanner;

public class CheflandGames {

    static void main() {
        System.out.println("Chefland games");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        while(numTest-- > 0){
            // Referees decisions
            int r1 = sc.nextInt();
            int r2 = sc.nextInt();
            int r3 = sc.nextInt();
            int r4 = sc.nextInt();

            if(r1 == 0 && r2 == 0 && r3 == 0 && r4 == 0){
                System.out.println("IN");
            }else{
                System.out.println("OUT");
            }

        }


    }


}
