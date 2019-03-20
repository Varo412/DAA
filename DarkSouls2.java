package darksouls2;

import java.util.Scanner;

public class DarkSouls2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();   //nº enemigos
        int [] niveles=new int[n];  //array de niveles de los enemigos
        for(int i=0;i<n;i++){
            niveles[i]=scan.nextInt();
        }
        
        int m=scan.nextInt();   //nº casos de prueba
        int [] casos=new int[m];    //array del user en cada caso de prueba
        for(int i=0;i<n;i++){
            casos[i]=scan.nextInt();
        }
        
        for(int i=0;i<m;i++){
            if(niveles[0]>casos[i]){
                System.out.println("0 0");
            }
            else{
                int index=recBinarySearch(niveles,casos[i]);    //adaptar para fallo
                int ptos=0;
                for(int j=0;j<index;j++){
                   ptos+=niveles[j];
                } 
                System.out.println(index+" "+ptos);
            }
        }
        
        
    }
    private static int recBinarySearch(int v[], int q){
        return auxBinarySearch(v,0,v.length-1,q);
    }
    
    private static int auxBinarySearch(int v [], int i, int j, int q){
        if(j>1){
            return -1;  //no vence a nadie
        }
        
        
        
        
        
        
        return 2;
    }
    
}
