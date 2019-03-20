package mergesort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int v[]=new int[n];
        for(int i=0;i<n;i++){
            v[i]=scan.nextInt();
        }
        int sol []=MergeSort(v);
        for(int i=0;i<n;i++){
            System.out.print((sol[i])+" ");
        }
        
    }
    private static int[] MergeSort(int v[]){
        if(v.length==1){
            return v;
        }
        int mid=v.length/2;
        int[] v_low=Arrays.copyOfRange(v,0, mid);
        int[] v_high=Arrays.copyOfRange(v, mid, v.length);
        v_low=MergeSort(v_low);
        v_high=MergeSort(v_high);
        int[] v_sorted=Merge(v_low,v_high);
        return v_sorted;
    }

    private static int[] Merge(int v_low [], int v_high[]){
        int[] mix=new int [v_low.length + v_high.length];
        int i=0;
        int j=0;
        int k=0;
        
        while(i<v_low.length && j<v_high.length){
            if(v_low[i]<=v_high[j]){
                mix[k]=v_low[i];
                i++;
            }
            else{
                mix[k]=v_high[j];
                j++;
            }
            k++;
        }
        while(i<v_low.length){
            mix[k]=v_low[i];
            i++;
            k++;
        }
        while(j<v_high.length){
            mix[k]=v_high[j];
            j++;
            k++;
        }
        return mix;
    }
}
