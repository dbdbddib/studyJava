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
        assertThatThrownBy(() -> math.mathTest002(10, 101)) // 이걸 실행하는데
                .isInstanceOf(Exception.class);             // 실행한 클래스가 매개변수 클래스로 기대가 된다~ Exception 클래스가 아니면 false
    }           // isInstanceOf : 데이터형

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

    @Test
    public void exam120585() throws Exception {
        System.out.println("exam120585");
        MathExam math = new MathExam();

        //이 부분은 Exception 확인 부분
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120585(new int[] {}, 150));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120585(new int[] {150, 201}, 130));
        System.out.println(ex2.toString());
        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120585(new int[] {150, 180}, 201));
        System.out.println(ex3.toString());

        //이 부분은 실제 값과 예상값이 같냐
        assertThat(math.exam120585(new int[] {149, 180, 192, 170}, 167)).isEqualTo(3);
        assertThat(math.exam120585(new int[] {180, 128, 140}, 198)).isEqualTo(0);
    }

    @Test
    public void exam120818() throws Exception{
        System.out.println("exam120818");
        MathExam math = new MathExam();

        //이 부분은 Exception 확인 부분
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120818(9));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120818(1000001));
        System.out.println(ex2.toString());

        //이 부분은 실제 값과 예상값이 같냐
        assertThat(math.exam120818(150000)).isEqualTo(142500);
        assertThat(math.exam120818(580000)).isEqualTo(464000);
    }

    @Test
    public void exam120837() throws Exception{
        System.out.println("exam120837");
        MathExam math = new MathExam();

        //이 부분은 Exception 확인 부분
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120837(-1));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120837(1001));
        System.out.println(ex2.toString());

        //이 부분은 실제 값과 예상값이 같냐
        assertThat(math.exam120837(23)).isEqualTo(5);
        assertThat(math.exam120837(24)).isEqualTo(6);
        assertThat(math.exam120837(999)).isEqualTo(201);
    }

    @Test
    public void exam120839() throws Exception {
        System.out.println("exam120839");
        MathExam math = new MathExam();

        //이 부분은 Exception 확인 부분
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120839(""));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120839("12313230000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000001"));
        System.out.println(ex2.toString());

        //이 부분은 실제 값과 예상값이 같냐
        assertThat(math.exam120839("2")).isEqualTo("0");
        assertThat(math.exam120839("205")).isEqualTo("052");

    }

    @Test
    public void exam120824() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120824(null));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120824(new int[] {}));
        System.out.println(ex2.toString());

        assertThat(math.exam120824(new int[] {1, 2, 3, 4, 5})).isEqualTo(new int[] {2,3});
        assertThat(math.exam120824(new int[] {1, 3, 5, 7})).isEqualTo(new int[] {0,4});
    }

    @Test
    public void exam120899() throws Exception {
        System.out.println("exam120899");
        MathExam math = new MathExam();

        //이 부분은 Exception 확인 부분
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120899(null));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120899(new int[] {}));
        System.out.println(ex2.toString());

        //이 부분은 실제 값과 예상값이 같냐
        assertThat(math.exam120899(new int[] {1, 8, 3})).isEqualTo(new int[] {8, 1});
        assertThat(math.exam120899(new int[] {9, 10, 11, 8})).isEqualTo(new int[] {11, 2});

    }
}

