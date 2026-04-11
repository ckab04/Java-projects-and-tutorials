package pb_500;

import java.util.Scanner;

public class CredCoins {

    static void main() {
        System.out.println("CRED COINS");

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        while(testCases -- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int totalBills = x * y;
            int numBags = totalBills / 100;
            System.out.println(numBags);
        }


    }

}
