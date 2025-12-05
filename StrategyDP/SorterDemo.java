import java.util.Arrays;
import java.util.Random;

public class SorterDemo {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern: Sorting Algorithms Performance Test ===\n");
        
        testWithRandomArray();
        testWithSortedArray();
        testWithReverseSortedArray();
        testWithDuplicateElements();
        testWithSmallArray();
        testWithLargeArray();
        
        comprehensiveComparison();
    }

    private static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }

    private static int[] generateRandomArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i=0; i<size; i++){
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    private static int[] generateArrayWithDuplicates(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    private static boolean isSorted(int[] array){
        for(int i=0; i<array.length-1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    private static void testAllStrategies(int[] array, String testName){
        SortStrategy[] strategies = {
            new BubbleSortStrategy(),
            new SelectionSortStrategy(),
            new QuickSortStrategy(),
            new MergeSortStrategy()
        };
        
        System.out.println("Algorithm\t\tTime (μs)\t\tStatus");
        System.out.println("────────────────────────────────────────────────────────────");
        
        for (SortStrategy strategy : strategies) {
            int[] testArray = copyArray(array);
            Sorter sorter = new Sorter(strategy);
            
            long startTime = System.nanoTime();
            sorter.sort(testArray);
            long endTime = System.nanoTime();
            
            long duration = (endTime - startTime) / 1_000;
            boolean sorted = isSorted(testArray);
            
            String status = sorted ? "✓ Sorted" : "✗ Failed";
            System.out.printf("%-20s\t%-15d\t%s%n", 
                strategy.getAlgorithmName(), duration, status);
        }
    }

    private static void testWithRandomArray() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 1: Random Array");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        int[] array = generateRandomArray(1000);
        System.out.println("Input: Random array of size " + array.length);
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOf(array, Math.min(10, array.length))));
        System.out.println();
        
        testAllStrategies(array, "Random Array");
    }

    private static void testWithSortedArray() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 2: Already Sorted Array");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        int[] array = generateSortedArray(1000);
        System.out.println("Input: Already sorted array of size " + array.length);
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOf(array, Math.min(10, array.length))));
        System.out.println();
        
        testAllStrategies(array, "Sorted Array");
    }

    private static void testWithReverseSortedArray() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 3: Reverse Sorted Array");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        int[] array = generateReverseSortedArray(1000);
        System.out.println("Input: Reverse sorted array of size " + array.length);
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOf(array, Math.min(10, array.length))));
        System.out.println();
        
        testAllStrategies(array, "Reverse Sorted Array");
    }

    private static void testWithDuplicateElements() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 4: Array with Many Duplicates");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        int[] array = generateArrayWithDuplicates(1000);
        System.out.println("Input: Array with duplicates of size " + array.length);
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOf(array, Math.min(10, array.length))));
        System.out.println();
        
        testAllStrategies(array, "Array with Duplicates");
    }

    private static void testWithSmallArray() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 5: Small Array (10 elements)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        int[] array = generateRandomArray(10);
        System.out.println("Input: " + Arrays.toString(array));
        System.out.println();
        
        testAllStrategies(array, "Small Array");
    }

    private static void testWithLargeArray() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 6: Large Array (10,000 elements)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        int[] array = generateRandomArray(10000);
        System.out.println("Input: Large random array of size " + array.length);
        System.out.println();
        
        testAllStrategies(array, "Large Array");
    }

    private static void comprehensiveComparison() {
        System.out.println("\n\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("COMPREHENSIVE PERFORMANCE COMPARISON");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Testing with random arrays (averaging over 5 runs)");
        System.out.println("Array size: 5000 elements\n");
        
        SortStrategy[] strategies = {
            new BubbleSortStrategy(),
            new SelectionSortStrategy(),
            new QuickSortStrategy(),
            new MergeSortStrategy()
        };
        
        System.out.println("Algorithm\t\tAvg Time (µs)\tMin Time\tMax Time");
        System.out.println("────────────────────────────────────────────────────────────────────");
        
        for (SortStrategy strategy : strategies) {
            long totalTime = 0;
            long minTime = Long.MAX_VALUE;
            long maxTime = Long.MIN_VALUE;
            int runs = 5;
            
            for (int i = 0; i < runs; i++) {
                int[] array = generateRandomArray(5000);
                Sorter sorter = new Sorter(strategy);
                
                long startTime = System.nanoTime();
                sorter.sort(array);
                long endTime = System.nanoTime();
                
                long duration = (endTime - startTime) / 1_000;
                totalTime += duration;
                minTime = Math.min(minTime, duration);
                maxTime = Math.max(maxTime, duration);
            }
            
            long avgTime = totalTime / runs;
            System.out.printf("%-20s\t%-15d\t%-10d\t%d%n", 
                strategy.getAlgorithmName(), avgTime, minTime, maxTime);
        }
        
        System.out.println("\n✓ Performance test completed!");
    }
}