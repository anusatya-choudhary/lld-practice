public class BubbleSortStrategy implements SortStrategy {
    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            int lastUnsortedIndex = n - 1 - i;

            for (int j = 1; j <= lastUnsortedIndex; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }
}
