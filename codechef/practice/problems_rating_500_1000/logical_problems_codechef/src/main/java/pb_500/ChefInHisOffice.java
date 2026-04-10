package pb_500;

import java.util.Scanner;

public class ChefInHisOffice {
    static void main() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t -- > 0){
            String[] line = sc.nextLine().trim().split(" ");
            int firstSetDays = Integer.parseInt(line[0]);
            int lastDay = Integer.parseInt(line[1]);

            int numberWorkingHours = (firstSetDays  * 4) + lastDay;
            System.out.println(numberWorkingHours);
        }
    }
}
