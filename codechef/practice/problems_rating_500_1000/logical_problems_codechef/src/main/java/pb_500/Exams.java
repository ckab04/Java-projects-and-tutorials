package pb_500;

import java.util.Scanner;

public class Exams {
    static void main() {
        System.out.println("Exams");
        studentsWhoPass();
    }

    public static void studentsWhoPass(){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases -- > 0){
            int schoolNumber = sc.nextInt();
            int studentNumber = sc.nextInt();
            int studentsWhoPassed = sc.nextInt();
            //System.out.println("Temp time =  " + temp);

            int totalStudents = schoolNumber * studentNumber;
            double totalPassedPerc = (double)studentsWhoPassed  /  totalStudents ;
            double perc = totalPassedPerc * 100;
            System.out.println((double) studentsWhoPassed / totalStudents);
            System.out.println("Percentage = " + totalPassedPerc);

            if(perc > 50 ){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }


}
