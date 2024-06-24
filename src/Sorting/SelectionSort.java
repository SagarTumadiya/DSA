package Sorting;

public class SelectionSort {
    public void sort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = {5,4,3,8,7,6};
        ss.sort(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }
}
