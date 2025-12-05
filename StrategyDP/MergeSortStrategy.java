public class MergeSortStrategy implements SortStrategy {
    @Override
    public String getAlgorithmName() {
        return "Merge Sort";
    }

    @Override
    public void sort(int[] array){
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);

        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for(int i=0; i<leftSize; i++){
            leftArray[i] = array[left + i];
        }

        for(int i=0; i<rightSize; i++){
            rightArray[i] = array[mid+1+i];
        }

        int i=0, j=0;
        int k = left;

        while(i<leftSize && j<rightSize){
            if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i];
                i++;
            }
            else{
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i<leftSize){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j<rightSize){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}