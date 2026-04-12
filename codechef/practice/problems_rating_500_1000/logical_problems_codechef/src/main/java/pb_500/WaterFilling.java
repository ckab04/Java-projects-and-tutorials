package pb_500;

import java.util.Scanner;

public class WaterFilling {

    static void main() {
        System.out.println("Water filling");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();

        while(numTest-- > 0){
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            int b3 = sc.nextInt();

            if((b1 == 0 && b2 == 0) || (b1 == 0 && b3 == 0) || (b2 == 0 && b3 == 0)) {
                System.out.println("Water filling time");

            }else{
                System.out.println("Not now");
            }

        }




    }


}
