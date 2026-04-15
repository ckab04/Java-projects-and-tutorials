package pb_500;

import java.util.Scanner;

public class SugarcaneJuice {
    static void main() {

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        final int SUGAR_CANE_PRICE = 20; // (percentage)
        final int SALT_MINT_PRICE = 20; // (percentage)
        final int SHOP_RENT_PRICE = 30; // (percentage)
        while (numTest-- > 0) {

            // problems
            int n = sc.nextInt();
            int totalIncome = n * 50;

            int amountSugarCane = (totalIncome * SUGAR_CANE_PRICE) / 100;
            int amountSaltAndMint = (totalIncome * SALT_MINT_PRICE) / 100;
            int amountRent = (totalIncome * SHOP_RENT_PRICE) / 100;

            System.out.println(totalIncome - (amountSugarCane + amountSaltAndMint + amountRent));
        }
    }
}
