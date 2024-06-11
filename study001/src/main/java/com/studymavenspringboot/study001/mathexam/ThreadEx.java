package com.studymavenspringboot.study001.mathexam;

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

public class ThreadEx {
    public static void main(String[] args) {
        T1 t = new T1();
        t.start();
    }
}
