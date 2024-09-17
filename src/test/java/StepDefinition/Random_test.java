package StepDefinition;

import java.util.Scanner;

public class Random_test {

    public static int alternativePrimeNumber(int num){
        int count = 0;
        for(int i=1; i<=num;i++){
            if(num%i==0){
                count =1;
            }
        }
        if(count==1){
            return 1;
        }
        return 0;
    }

    public static void method(int number){
        for(int i=1;i<=number;i++){
            if(alternativePrimeNumber(i)==0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
     System.out.println("Please enter number to check whether it is prime number or not");
        Scanner si = new Scanner(System.in);
        int number = si.nextInt();
        method(number);
    }
}
