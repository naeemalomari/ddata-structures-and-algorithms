package Challenge26;

public class MergeSort {

    public int[] sort(int[] arr) {
        int n=arr.length;

        if (n < 2) {
            return arr;
        }
        int mid = n / 2;
        int[] leftSegment = new int[mid];
        int[] rightSegment = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            leftSegment[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightSegment[i - mid] = arr[i];
        }

        sort(leftSegment);
        sort(rightSegment);

        merge(arr, leftSegment, rightSegment);

        return arr;
    }

    public static void merge(int[] arr, int[] leftSegment, int[] rightSegment) {

        int i = 0, j = 0, k = 0;

        while (i < leftSegment.length && j < rightSegment.length) {

            if (leftSegment[i] <= rightSegment[j]) {
                arr[k++] = leftSegment[i++];
            }
            else {
                arr[k++] = rightSegment[j++];
            }

        }
        while (i < leftSegment.length) {
            arr[k++] = leftSegment[i++];
        }
        while (j < rightSegment.length) {
            arr[k++] = rightSegment[j++];
        }

    }

}
