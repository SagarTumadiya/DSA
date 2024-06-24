package Sorting;

public class QuickSort {
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int pivot(int[] arr,int l,int r){
        int pivot = arr[r];
        int i = l-1;
        for(int j=l;j<=r-1;j++){
            if(arr[j]<pivot)
            {   i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    public void sort(int[] arr,int l,int r){
        if(l<r){
         int p = pivot(arr,l,r);
         sort(arr,l,p-1);
         sort(arr,p+1,r);
        }
    }
    public static void main(String[] args) {
       QuickSort q = new QuickSort();
       int[] arr = {5,4,3,2,7,6,8};
       q.sort(arr,0,arr.length-1);
       for(int i:arr)
           System.out.print(i+" ");
    }
}
