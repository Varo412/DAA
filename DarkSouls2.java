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
        
        long [] exp=new long[n];        //Array de niveles de experiencia segun enemigo
        long ptosAux=0;                 //acumulador de experiencia
        for(int i=0;i<n;i++){
            ptosAux+=niveles[i];
            exp[i]=ptosAux;
        }
        
        int m=scan.nextInt();   //nº casos de prueba
        int [] casos=new int[m];    //array del user en cada caso de prueba
        for(int i=0;i<m;i++){
            casos[i]=scan.nextInt();
        }
        
        for(int i=0;i<m;i++){
            if(niveles[0]>casos[i]){
                System.out.println("0 0");          //si no vence a nadie
            }
            else if(niveles[n-1]<casos[i]){         //vence a todos
                System.out.println(n+" "+exp[n-1]);
            }
            else{
                int index=recBinarySearch(niveles,casos[i]);    //entre medias 
                System.out.println((index+1)+" "+exp[index]);
            }
        }
        
        
    }
    private static int recBinarySearch(int v[], int q){
        return auxBinarySearch(v,0,v.length-1,q);
    }
    
    private static int auxBinarySearch(int v [], int i, int j, int q){
        if(j<i){
            return j ;  //No ha encontrado resultado, devuelve el inmediátamente anterior
        }
        int k=(j+i)/2;
        if (v[k]==q){       //justo la mediana es el elemento buscado
            return k;
        }
        else if(v[k]<q){    //El valor está a la derecha de la mediana
            return auxBinarySearch(v,k+1,j,q);
        }
        else{       //El valor está a la izquierda de la mediana
            return auxBinarySearch(v,i,k-1,q);
        }
    }   
}
