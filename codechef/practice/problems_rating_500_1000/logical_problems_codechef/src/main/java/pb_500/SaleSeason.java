package pb_500;

import java.util.Scanner;

public class SaleSeason {

    static void main() {
        System.out.println("Sale Season");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();

        while(numTest-- > 0){
            int x = sc.nextInt();

            int discount = 0;
            if (x > 100 && x <= 1000) {
                discount = 25;
            } else if (x > 1000 && x <= 5000) {
                discount = 100;
            } else if (x > 5000) {
                discount = 500;
            }
            int totalPrice = x - discount;
            System.out.println(totalPrice);
        }

    }

}
