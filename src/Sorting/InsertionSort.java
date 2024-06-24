package Sorting;

public class InsertionSort {
    public void sort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {5,4,3,2,1,8,7,6};
        is.sort(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }
}
