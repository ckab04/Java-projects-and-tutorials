package pb_500;

import java.util.Scanner;

public class ChefAndCandies {

    static void main() {
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();

        final int  NUM_CANDIES_PER_PACKET= 4;

        while (numTest-- > 0)    {

            // the number of children
            int n = sc.nextInt();
            // the number of candies the Chef already has
            int x = sc.nextInt();

            int num_candies_per_child = n - x ;
            int minimumNumCandiesPacket;
            if(num_candies_per_child < 0){
                System.out.println(0);
            }else{
                System.out.println(Math.ceilDiv(num_candies_per_child, NUM_CANDIES_PER_PACKET));
            }

        }
    }



}
