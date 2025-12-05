public class SelectionSortStrategy implements SortStrategy {
    @Override
    public String getAlgorithmName() {
        return "Selection Sort";
    }

    @Override
    public void sort(int[] array){
        int n = array.length;

        for(int i=0;i<n; i++){
            int minIndex = i;

            for(int j=i+1; j<n; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
