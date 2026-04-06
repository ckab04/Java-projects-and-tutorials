package pb_500;

import java.util.Scanner;

public class JanmanshAssignments {

    static void main() {
        System.out.println("Janmansh and Assignments");
        Scanner sc = new Scanner(System.in);
        int deadlineTime = 10;
        int numAssignment = 3;

        int testCases = sc.nextInt();
        while(testCases -- > 0){
            int startTime = sc.nextInt();
            int temp = startTime + numAssignment;
            System.out.println("Temp time =  " + temp);
            if(deadlineTime - temp >= 0 ){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }



    }


}
