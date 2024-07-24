package homework;

import com.codingshadows.homework.AtomicCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtomicCounterTest {

    @Test
    public void testIncrementCounter() throws InterruptedException {
        AtomicCounter atomicCounter = new AtomicCounter();
        int numberOfThreads = 10;
        int incrementsPerThread = 100_000;

        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> atomicCounter.incrementCounter(incrementsPerThread));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        assertEquals(1_000_000, atomicCounter.getCounter());
    }
}

