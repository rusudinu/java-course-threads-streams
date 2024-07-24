package homework;

import com.codingshadows.homework.WordFrequencyCounter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyCounterTest {

    @Test
    public void testCountWords() throws InterruptedException {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        List<String> text = List.of("this", "is", "a", "sample", "text", "this", "text", "is", "a", "sample");
        int numberOfThreads = 5;
        int chunkSize = text.size() / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            final int start = i * chunkSize;
            final int end = (i == numberOfThreads - 1) ? text.size() : start + chunkSize;
            threads[i] = new Thread(() -> counter.countWords(text.subList(start, end)));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        ConcurrentHashMap<String, AtomicInteger> wordCounts = counter.getWordCounts();
        assertEquals(2, wordCounts.get("this").get());
        assertEquals(2, wordCounts.get("is").get());
        assertEquals(2, wordCounts.get("a").get());
        assertEquals(2, wordCounts.get("sample").get());
        assertEquals(2, wordCounts.get("text").get());
    }
}

