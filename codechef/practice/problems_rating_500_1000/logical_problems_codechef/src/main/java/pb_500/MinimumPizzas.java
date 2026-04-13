package pb_500;

import java.util.Scanner;

public class MinimumPizzas {
    static void main() {
        System.out.println("Minimum Pizzas");
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();

        int sliceInPizza = 4;
        while(numTest-- > 0){
            // Number of friends
            int n = sc.nextInt();

            // Number of slices
            int x = sc.nextInt();
            int totalSlices = n * x;
            //double numPizzas = (double) totalSlices / sliceInPizza;
            System.out.println(Math.ceilDiv(totalSlices, sliceInPizza));

        }




    }
}
