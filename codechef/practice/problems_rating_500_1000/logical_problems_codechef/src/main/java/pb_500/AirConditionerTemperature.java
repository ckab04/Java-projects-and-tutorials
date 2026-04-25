package pb_500;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AirConditionerTemperature {

    static void main() {
        System.out.println("Air Conditioner Temperature");

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        int [] temperatures = new int[3];
        while (numTest-- > 0) {
            temperatures[0] = sc.nextInt();
            temperatures[1] = sc.nextInt();
            temperatures[2] = sc.nextInt();

            int lower = Math.max(temperatures[0], temperatures[2]);
            int upper = temperatures[1];
            if(lower <= upper){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
