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

            int higherBound = Arrays.stream(temperatures)
                    .max().getAsInt();

            int lowerBound = Arrays.stream(temperatures)
                    .min().getAsInt();

            List<Integer> overlapping = IntStream.rangeClosed(lowerBound, higherBound)
                    .filter(t -> t >= temperatures[0])
                    .filter(t -> t <= temperatures[1])
                    .filter(t -> t >= temperatures[2])
                    .boxed()
                    .toList();

            if(overlapping.isEmpty()){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
