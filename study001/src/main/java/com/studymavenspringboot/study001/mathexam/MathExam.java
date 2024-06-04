package com.studymavenspringboot.study001.mathexam;

public class MathExam {
    public int subTest001(int n1, int n2) throws Exception{
        if(n1 < -50000 || n1 > 50000){
            throw new Exception("num1 값은 -50000보다 작거나, num1 값은 50000 보다 큽니다.");
        }
        if(n2 < -50000 || n2 > 50000){
            throw new RuntimeException("num2 값은 -50000보다 작거나, num2 값은 50000 보다 큽니다.");
        }
        return  n1 - n2;
    }

    public int mathTest002(int n1, int n2) throws Exception {
        if(n1 < 0 || n1 > 100){
            throw new Exception("num1 값은 0 ~ 100 사이의 값 이어야 합니다.");
        }
        if(n2 < 0 || n2 > 100){
            throw new RuntimeException("num2 값은 0 ~ 100 사이의 값 이어야 합니다.");
        }
        return n1 * n2;
    }

    public int mathTest003(int n1, int n2) throws Exception {
        int res = -1;
        if(n1 < 0 || n1 > 10000){
            throw new Exception("num1 값은 0 ~ 10000 사이의 값 이어야 합니다.");
        }
        if(n2 < 0 || n2 > 10000){
            throw new RuntimeException("num2 값은 0 ~ 10000 사이의 값 이어야 합니다.");
        }
        if( n1 == n2 ){
            res = 1;
        }
        return res;
    }

    public int exam120585(int[] array, int height) throws Exception {
        if( array == null || array.length <= 0 || array.length > 100 ) {
            throw new Exception(String.format("array는 null이 아니고, 길이가 1~100 이어야 합니다."));
        }
        if( height <= 0 || height > 200 ) {
            throw new Exception(String.format("height는 1 ~ 200 이어야 합니다."));
        }
        int result = 0;
        for( int i = 0; i < array.length; i++) {
            if (array[i] <= 0 || array[i] > 200) {
                throw new Exception(String.format("array[%d] = [%d]는 1 ~ 200 이어야 합니다.", i, array[i]));
            }
            if ( array[i] > height ){
                result++;
            }
        }
        return result;
    }

    public int exam120818(int price) throws Exception {
        int result = 0;

        if (price >= 10 && price <= 1000000) {
            if(price%10 == 0) {
                if (price >= 100000 && price <= 299999) {
                    result = (int) (price * 0.95);
                }
                if (price >= 300000 && price <= 499999) {
                    result = (int) (price * 0.90);
                }
                if (price >= 500000) {
                    result = (int) (price * 0.8);
                }
            } else{
                throw new Exception(String.format("10원 단위여야 합니다!"));
            }
        } else {
            throw new Exception(String.format("가격은 10원 ~ 1000000원 사이여야 합니다."));
        }
        System.out.println("최종가격:" + result);
        return result;
    }

    public int exam120837(int hp) throws Exception{
        if(hp < 0 || hp > 1000){
            throw new Exception(String.format("hp는 0~1000이어야 합니다."));
        }

        int strongant = 5;
        int jungant = 3;
        int nomalant = 1;
        int result = 0;

        while (hp > 0) {
            if (hp >= 5) {
                hp -= strongant;
                result++;
            } else if (hp <= 4 && hp > 2) {
                hp -= jungant;
                result++;
            } else if (hp <= 2 && hp > 0) {
                hp -= nomalant;
                result++;
            }
        }
        System.out.println("개미 군단 필요 수: " + result);
        return result;
    }

    public String exam120839(String rsp) throws Exception {
        String answer = "";

        if(rsp.length() > 0 && rsp.length() <= 100) {

            for (int i = 0; i < rsp.length(); i++) {
                char c = rsp.charAt(i);
                if (c == '2') {
                    answer += "0";
                } else if (c == '0') {
                    answer += "5";
                } else if (c == '5') {
                    answer += "2";
                }
            }
        } else{
            throw new Exception(String.format("0 < rsp의 길이 ≤ 100 이어야 합니다."));
        }
        System.out.println(answer);
        return answer;
    }

    public int[] exam120824(int[] num_list) throws Exception{
        if( num_list == null){
            throw new Exception(String.format("num_list는 null이 아니어야 합니다."));
        }
        if(num_list.length <= 0 || num_list.length > 100){
            throw new Exception(String.format("num_list배열의 길이는 1~100개 이어야 합니다."));
        }

        int[] result = new int[] {0,0};
        for(int i=0; i<num_list.length; i++){
            if(num_list[i] < 0 || num_list[i] > 1000){
                throw new Exception(String.format("num_list[%d], 값 : %d 의 범위는 0~1000 이어야 합니다.", i, num_list[i]));
            }
            if(num_list[i]%2 == 0){
                result[0] ++;
            }
            else {
                result[1]++;
            }
        }
        return result;
    }

    public int[] exam120899(int[] num_list) throws Exception{
        if( num_list == null){
            throw new Exception(String.format("num_list는 null이 아니어야 합니다."));
        }
        if(num_list.length <= 0 || num_list.length > 100){
            throw new Exception(String.format("num_list배열의 길이는 1~100개 이어야 합니다."));
        }

        int val = num_list[0];
        int ind = 0;

        for (int i = 1; i < num_list.length; i++) {
            if(num_list[i - 1] < num_list[i]){
                val = num_list[i];
                ind = i;
            }
        }

        return new int[]{val, ind};
    }
}