package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @Test
    public void printLongestWordTop100() throws Exception {
        StreamStudy.printLongestWordTop100();
    }

    @Test
    public void map() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @Test
    public void sumAll() throws Exception {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumOverThreeAndDouble() throws Exception {
        numbers = List.of(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }

    @Test
    public void sumOverThreeAndDoubleWithCondition() throws Exception {
        numbers = List.of(3, 1, 6, 2, 4, 8);
        Condition condition = number -> number > 3 ? number * 2 : 0;
        long sum = StreamStudy.sumOverThreeAndDouble(numbers, condition);
        assertThat(sum).isEqualTo(36);
    }

    @Test
    public void sumOverThreeAndDoubleWithStream() throws Exception {
        numbers = List.of(3, 1, 6, 2, 4, 8);
        Predicate<Integer> predicate = number -> number > 3;
        Function<Integer, Integer> function = number -> number * 2;
        long sum = StreamStudy.sumOverThreeAndDouble(numbers, predicate, function);
        assertThat(sum).isEqualTo(36);
    }
}
