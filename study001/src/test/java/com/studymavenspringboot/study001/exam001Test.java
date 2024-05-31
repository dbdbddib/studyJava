package com.studymavenspringboot.study001;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class exam001Test {
    @Test
    public void subtract001() throws Exception{
        // given    테스트하기 위한 준비 동장
        int num1 = 2;
        int num2 = 3;
        int expected = -1;

        // when     테스트를 실시
        int actual = subTest001(num1, num2);

        // then     실제값과 기댓값을 비교해서 테스트한다.
        assertThat(actual).isEqualTo(expected);
        assertThat(100).isEqualTo(subTest001(300, 200));
        assertThat(100).isEqualTo(subTest001(300, 200));
    }

    int subTest001(int n1, int n2) throws Exception{
        if(n1 < -50000 || n1 > 50000){
            throw new Exception("num1 값은 -50000보다 작거나, num1 값은 50000 보다 큽니다.");
        }
        if(n2 < -50000 || n2 > 50000){
            throw new Exception("num2 값은 -50000보다 작거나, num2 값은 50000 보다 큽니다.");
        }
        return  n1 - n2;
    }
}

