package desfilestemp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesfilesTemp {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();   //n
        int m=scan.nextInt();   //m
        int pn;
        
        List<Integer>[]g=new List[n];        //creamos estructura grafo
        for(int i=0;i<n;i++){
            g[i]=new ArrayList(m);
        }
        
        for(int i=0;i<m;i++){
            int a=scan.nextInt()-1;
            if(i==0){
                pn=a;
            }
            int b=scan.nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        int borrar=-1;
        
        
    }
    
    /*public static List<Integer>[] DFS(List<Integer>[]g){
        int n=g.length;
        List<Integer> traversales[]=new List[n];
        for(int v=0;v<n;v++){
            traversales[n]=DFS(g,v);
        }
        return traversales;
    }*/
    
    public static List<Integer>DFS(List<Integer>[] g, int v){
        int n=g.length;
        List<Integer>traversal=new ArrayList<>(n);  //lista del recorrido
        boolean [] visited=new boolean[n];          //array de visitados
        recursiveDFS(g,v,visited,traversal);
        return traversal;
    }
    
    private static void recursiveDFS(List<Integer>[]g,int v, boolean[] visited,
            List<Integer>traversal){
        visited[v]=true;
        traversal.add(v);
        for(int adj:g[v]){
            if(!visited[adj]){
                recursiveDFS(g,adj,visited,traversal);
            }
        }
    }
}
