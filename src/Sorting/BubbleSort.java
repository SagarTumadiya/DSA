package Sorting;

public class BubbleSort {
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void sort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j])
                    swap(arr,i,j);
            }
        }
    }
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {3,4,5,6,7,4,1,0};
        bs.sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
