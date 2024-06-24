package Sorting;

public class MergeSort {
    public void merge(int[] arr,int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] a = new int[n1];
        int[] b = new int[n2];
        for(int i=0;i<n1;i++){
            a[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
            b[i] = arr[m+i+1];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = a[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = b[j];
            j++;
            k++;
        }
    }
    public void sort(int[] arr,int l,int r){
        if(l<r){
            int m = l + (r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {5,4,3,2,8,7,6};
        ms.sort(arr,0,arr.length-1);
        for(int i:arr)
            System.out.print(i+" ");
        

    }
}
