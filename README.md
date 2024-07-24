### Homework: Practical Use of Java Threads and Streams

#### Objective

The goal of this homework is to get hands-on experience with parallel data processing using Java's threading and streaming capabilities. You'll also work with atomic collections and integers to ensure
thread safety during concurrent operations.

#### Tasks

1. **Parallel Data Processing with Streams**
    - Create a list of integers from 1 to 1,000,000.
    - Use Java's parallel streams to filter out all even numbers and collect the remaining odd numbers into a new list.
    - Calculate the sum of the odd numbers using the parallel stream.

2. **Thread-safe Operations with Atomic Variables**
    - Implement a counter using `AtomicInteger`.
    - Create multiple threads (e.g., 10 threads) where each thread increments the counter 100,000 times.
    - Ensure the final count is 1,000,000 and print the result.

3. **Concurrent Modification with Atomic Collections**
    - Use `ConcurrentHashMap` to store and update word frequencies.
    - Create multiple threads (e.g., 5 threads) where each thread processes a chunk of text (simulate by splitting a long string into parts).
    - Each thread should count the frequency of words in its chunk and update the `ConcurrentHashMap`.
    - Print the final word frequencies after all threads complete their execution.

#### Deliverables

1. **List Filtering and Summation**
    - A brief explanation of how you used parallel streams to filter and sum the list.
    - The resulting sum of odd numbers.

2. **AtomicInteger Counter**
    - A brief explanation of how `AtomicInteger` ensures thread safety.
    - The final value of the counter after all threads have executed.

3. **ConcurrentHashMap Word Frequency**
    - A brief explanation of how `ConcurrentHashMap` handles concurrent updates.
    - The final word frequency count.
