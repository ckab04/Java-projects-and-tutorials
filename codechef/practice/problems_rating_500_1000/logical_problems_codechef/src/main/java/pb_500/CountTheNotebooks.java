package pb_500;

import java.util.Scanner;

public class CountTheNotebooks {


    static void main() {
        System.out.println("Count the notebooks");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        final int NUM_PAGES_1_KG_PULP = 1000;
        final int NUM_PAGES_1_NOTEBOOK = 100;
        while (numTest-- > 0) {

            // the weight of the pulp the factory has (in kgs).
            int n = sc.nextInt();
            int totalKg = n *  NUM_PAGES_1_KG_PULP;
            int numNotebooks = totalKg / NUM_PAGES_1_NOTEBOOK;
            System.out.println(numNotebooks);
        }

    }

}
