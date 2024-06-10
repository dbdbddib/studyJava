package com.studymavenspringboot.study001.mathexam;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            codeup1218();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void codeup1173() throws Exception {
        Scanner input = new Scanner(System.in);
        int hour = input.nextInt();
        int mins = input.nextInt();

        if(hour<0 || hour >= 24){
            throw new Exception(String.format("시간(%d)은 0~24 이어야 합니다.", hour));
        } else if(mins<0 || mins >= 60){
            throw new Exception(String.format("시간(%d)은 0~59 이어야 합니다.", mins));
        }
        int nextMins = mins - 30;
        if(nextMins < 0){
            hour = (hour <= 0) ? 23 : hour--;
            nextMins += 60;
        }
        System.out.println(String.format("%d %d", hour, nextMins));
    }

    public static void codeup1180() throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0 || n >= 100){
            throw new Exception(String.format("n(%d)은 0~100 이어야 합니다.", n));
        }

        int one = n/10;
        int ten = (n % 10) * 10;
        int result = (one + ten) *2;
        if( result > 100 ){
            result %= 100;
        }
        System.out.println(String.format("%d", result));
        if(result <= 50) {
            System.out.println("GOOD");
        } else {
            System.out.println("OH MY GOD");
        }
    }

    public static void codeup1218(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        if(a == b && a == c){
            System.out.println("정삼각형");
        } else if (a == b && c!= b || b == c && b != a){
            System.out.println("이등변삼각형");
        } else {
            if ((a*a + b*b) == c*c){
                System.out.println("직각삼각형");
            } else {
                System.out.println("삼각형");
            }
        }
    }

    public static void codeup1226(){
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();

        int[] successArr = getIntArraySorted(first, 7);

        int[] tryArr = getIntArraySorted(second, 6);
    }

    private static int[] getIntArraySorted(String first, int x) {
        String[] inputStr = first.split(" ");
        int[] outputArray = new int[x];

        for (int i = 0; i < inputStr.length; i++) {
            outputArray[i] = Integer.parseInt((inputStr[i]));
        }
        Arrays.sort(outputArray);
        return outputArray;
    }

    public static void codeup1231(){

    }




//    public static void codeup1180() throws Exception{
//        T1 t = new T1();
//        t.start();
//    }
}   //Main

class T1 extends Thread {
    @Override
    public void run(){
        try{
            int n = 0;
            while(true){
                System.out.println(n);
                n++;
                sleep(1000);
                if ( n == 10 ){
                    String str = Integer.toString(n);
                    String reversedStr = new StringBuilder(str).reverse().toString();
                    n = Integer.parseInt(reversedStr);
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}