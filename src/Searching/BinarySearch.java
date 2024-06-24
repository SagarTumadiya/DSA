package Searching;

public class BinarySearch {
    public int bs(int [] arr,int l,int r,int key){
       if(l<=r){
           int m = l + (r-l)/2;
           if(arr[m]==key){
               return m;
           } else if(arr[m]>key){
               return bs(arr,l,m-1,key);
           } else {
               return bs(arr,m+1,r,key);
           }
       }
       return -1;
    }
    public int search(int[] arr,int key){
        int n = arr.length;

        return bs(arr,0,n-1,key);
    }
    public static void main(String[] args) {
        BinarySearch a = new BinarySearch();
        int[] arr = {1,2,3,4,5,6};
        System.out.println(a.search(arr,4)+" ");
    }
}
