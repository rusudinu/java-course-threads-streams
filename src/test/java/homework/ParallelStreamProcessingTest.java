package homework;

import com.codingshadows.homework.ParallelStreamProcessing;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParallelStreamProcessingTest {

    @Test
    public void testFilterOddNumbers() {
        ParallelStreamProcessing processor = new ParallelStreamProcessing();
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> oddNumbers = processor.filterOddNumbers(numbers);

        List<Integer> expected = List.of(1, 3, 5, 7, 9);
        assertEquals(expected, oddNumbers);
    }

    @Test
    public void testSumOddNumbers() {
        ParallelStreamProcessing processor = new ParallelStreamProcessing();
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        int sum = processor.sumOddNumbers(numbers);

        assertEquals(25, sum);
    }
}
