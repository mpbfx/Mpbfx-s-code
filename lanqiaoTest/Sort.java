import lanqiaoTest.Util;

/**
 * [常用sort]
 *
 * @author : [18358]
 * @version : [v1.0]
 * @createTime : [2022/3/1/001 09:21]
 */
public class Sort {

    public static void main(String[] args) {

        int[] a = new int[]{3,2,1,4,5,6,4,2,3,6};
//        bubbleSort(a);
//        selectionSort(a);
//        insertionSort(a);
//        shellSort(a);
        quickSort(a, 0, 9);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }


    private static void bubbleSort(int[] arr){
        boolean flag = true;
        for (int j = 0; j < arr.length; j++){
            for (int i = 0; i < arr.length - j - 1; i++) {
                if (arr[i] > arr[i + 1]){
                    Util.swap(arr, i, i + 1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    private static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            Util.swap(arr, min, i);
        }
    }

    private static void  insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pre = i - 1;
            while (pre >= 0 && arr[pre] > key){
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = key;
        }

    }

    private static void shellSort(int[] arr){
        for (int interval = arr.length / 2; interval > 0; interval /= 2){

            for (int i = interval; i < arr.length; i++){
                int key = arr[i];
                int pre = i - interval;
                while (pre > -1 && arr[pre] > key){
                    arr[pre + interval] = arr[pre];
                    pre -= interval;
                }
                arr[pre + interval] = key;
            }
        }
    }

    private static void quickSort(int[] arr, int p, int r){
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {

        int pivot = arr[p];
        int left = p + 1;
        int right = r;

        while (left <= right){
            while (left <= right && arr[left] <= pivot)
                left++;
            while (left <= right && arr[right] > pivot)
                right--;
            if (left < right)
                Util.swap(arr, left, right);
        }
        Util.swap(arr, p, right);
        return right;

    }


}
