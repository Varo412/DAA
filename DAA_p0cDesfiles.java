package daa_p0cdesfiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Varo412
 */
public class DAA_p0cDesfiles {

    public static void main(String[] args) {
        Scanner lector= new Scanner(System.in);
        int n =lector.nextInt();    //nodos
        int m=lector.nextInt();     //aristas
        int padre=0;        //valor auxiliar
        
        List<Integer>[]g=new List[n];       //inicializo grafo
        Boolean visited[]=new Boolean[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList(m);
            visited[i]=false;
        }
        
        for(int i=0;i<m;i++){               //relleno grafo
            int nod1=Integer.parseInt(lector.next())-1;
            int nod2=Integer.parseInt(lector.next())-1;
            g[nod1].add(nod2);
            g[nod2].add(nod1);
            if(i==0){
                padre=nod1;
            }
        }
        boolean sol=Cycle(n,visited,padre,g);
        System.out.print(sol);
       
        
       
        
        
        
        

        
        
    }
    
    static boolean Cycle(int n, Boolean visited[],int parent, List<Integer>[]g){
        visited[n-1]=true;
        int i;
        Iterator<Integer> it=g[n-1].iterator();
        while(it.hasNext()){
            i=it.next();
            if(!visited[i]){
                if(Cycle(i,visited,n-1,g)){
                    return true;
                }
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
    
}
