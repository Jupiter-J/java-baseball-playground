package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SetTest {

    private Set<Integer> numbers;
    // Set은 객체를 중복해서 저장할 수 없고 하나의 null 값만 저장할 수 있다. 또한 저장 순서가 유지되지 않는다.
    // Set의 가장 큰 장점은 중복을 자동으로 제거해준다는 점이다.

    @BeforeEach //어노테이션을 붙인 메서드는 테스트 메서드 실행 이전에 수행된다.
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //요구사항 1
    @Test
    @DisplayName("Set의 크기를 확인")
    void size(){
        //given
        int result = numbers.size();
        //when, then
        assertThat(result).isEqualTo(3);

    }


    //요구사항 2
    @ParameterizedTest //중복을 제거
    @DisplayName("중복 코드를 제거")
    @ValueSource(ints = {1,2,3})
    void contains(int result ){
        //when, then
        assertTrue(numbers.contains(result));
    }


    //요구사항 3
    @ParameterizedTest
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")                //delimiter은 사용자 지정가능!
    @CsvSource(value = {"1:true", "2:true","3:true", "4:false","5:false"}, delimiter = ':')
    void different_contains(int result, boolean expected){
        assertThat(numbers.contains(result)).isEqualTo(expected);

    }







}
