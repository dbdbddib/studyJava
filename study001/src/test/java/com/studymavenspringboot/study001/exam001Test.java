package com.studymavenspringboot.study001;

import com.studymavenspringboot.study001.mathexam.MathExam;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class exam001Test {
    @Test
    public void subtract001() throws Exception{
        // given    테스트하기 위한 준비 동장
        MathExam math = new MathExam();
        int num1 = 2;
        int num2 = 3;
        int expected = -1;

        // when     테스트를 실시
        int actual = math.subTest001(num1, num2);

        // then     실제값과 기댓값을 비교해서 테스트한다.
        assertThat(actual).isEqualTo(expected);
        assertThat(100).isEqualTo(math.subTest001(300, 200));
        assertThat(100).isEqualTo(math.subTest001(300, 200));

        //Exception 예외가 발생해야지만 정상 동작으로 인식한다.
        assertThatThrownBy(() -> math.subTest001(70000, 7)).isInstanceOf(Exception.class);
        // RuntimeException 예외가 발생해야지만 정상 동작으로 인식한다.
        Throwable exception = assertThrows(RuntimeException.class, ()-> {
            math.subTest001(2330, 50002);
        });
    }

    @Test
    public void multiply001() throws Exception {
        // given
        MathExam math = new MathExam();

        // when


        // then
        assertThat(12).isEqualTo(math.mathTest002(3, 4));
        assertThatThrownBy(() -> math.mathTest002(-1, 10))
                .isInstanceOf(Exception.class);  // 이 객체가 Exception.class냐 (t/f) class면 true return
        assertThatThrownBy(() -> math.mathTest002(10, 101))
                .isInstanceOf(Exception.class);
    }

    @Test
    public void test01() throws Exception {
        // given
        MathExam math = new MathExam();

        // when


        // then
                    //이 값과                          이 값이 똑같냐? 물어보는 함수                              
        assertThat(1).isEqualTo(math.mathTest003(4, 4));
        assertThat(-1).isEqualTo(math.mathTest003(3, 4));
    }
}

