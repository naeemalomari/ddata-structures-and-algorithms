package Challenge26;


public class QuickSort {

    public void quickSort(int[] arr, int left, int right){

        if(arr.length < 2)
            return;

        if(left < right){

            // Partition the array by setting the position of the pivot value
            int position = partition(arr, left, right);
            // Sort the left
            quickSort(arr, left, position - 1);
            // Sort the right
            quickSort(arr, position + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right){

        int pivot = arr[right];

        int low = left - 1;
        for(int i = left; i < right; i++){
            if ( arr[i] <= pivot){
                low ++;
                swap(arr, i, low);
            }

        }
        swap(arr, right, low + 1);
        return low + 1;
    }

    public void swap(int[] arr, int i, int low){
        int temp;
        temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }
}