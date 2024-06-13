package com.studymavenspringboot.study001.mathexam;

import lombok.Getter;       //loombok은
import lombok.Setter;

@Getter
@Setter

public class Student {
    private String name;    // 멤버변수(필드)는 모조건 private    밖에서 사용 못하니 Getter, Setter를 사용해라
    private int score;


    @Override
    public  String toString(){
        return String.format("이름: %s, 점수: %d", name, score);
    }
}
