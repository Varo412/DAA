package DAA_p0b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author aj.rivas.2017
 */
public class daa_p0b {

    public static void main(String[] args) {
        Scanner lectura= new Scanner(System.in);
        int nNodos=Integer.parseInt(lectura.next());
        int nAristas=Integer.parseInt(lectura.next());
        int PrimerNodo=Integer.parseInt(lectura.next()); 
        
        List <Integer>[] g = new List[nNodos];
        
        for(int i=0;i<nNodos;i++){
            g[i]=new ArrayList(nAristas);
        }

        for(int i=0;i<nAristas;i++){
            int nod1=Integer.parseInt(lectura.next())-1;
            int nod2=Integer.parseInt(lectura.next())-1;
            g[nod1].add(nod2);
            g[nod2].add(nod1);
        }
        List<Integer>solucion=breadthFirstSearch(g,PrimerNodo-1);
        Iterator<Integer> it=solucion.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+1+" "); //+1 para evitar el problema del n-1
        }
    }
    
 
    /* ESTO CREA UN ARRAYLIST CON TODOS EL RECORRIDO EMPEZANDO POR CADA NODO,
    MAS SOLO NOS INTERESA EL RECORRIDO QUE EMPIEZA POR PRIMERNODO-1
    
    public static List<Integer>[] breadthFirstSearch(List<Integer>[] g){
        int n=g.length;
        List <Integer> [] traversales = new List[n];
        for (int v=0;v<n;v++){
            traversales[v]=breadthFirstSearch(g,v);
        }
        return traversales;
    }
    */
    
    public static List<Integer>breadthFirstSearch(List<Integer>[] g, int v){
        int n=g.length;
        List<Integer> traversal=new ArrayList<>(n);
        boolean[] visited=new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[v]=true;
        traversal.add(v);   //+1
        q.add(v);
        while(!q.isEmpty()){
            int aux=q.remove();
            for(int adj:g[aux]){
                if(!visited[adj]){
                    visited[adj]=true;
                    traversal.add(adj); //+1
                    q.add(adj);
                }
            }
        }
        return traversal;
    }
    
}
