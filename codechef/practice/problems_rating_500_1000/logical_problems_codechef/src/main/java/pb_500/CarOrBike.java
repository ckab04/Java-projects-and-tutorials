package pb_500;

import java.util.Scanner;

public class CarOrBike {

    static void main() {
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();


        while (numTest-- > 0) {
            int bike = sc.nextInt();
            int car = sc.nextInt();
            if(bike < car){
                System.out.println("BIKE");
            }else if(car < bike){
                System.out.println("CAR");
            }else{
                System.out.println("SAME");
            }
        }
    }

}
