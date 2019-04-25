package prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Prim {
    public static class Arista{
        int peso;
        int dest;
        int orig;
        
        public Arista(int i,int d,int p){
            this.orig=i;
            this.dest=d;
            this.peso=p;
        }
        public int getPeso(){
            return this.peso;
        }
        public int getDestino(){
            return this.dest;
        }
        public int getOrigen(){
            return this.orig;
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();   //nº de nodos
        int m=scan.nextInt();   //nº de aristas
        
        List<Arista>[]g=new List [n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList(n);
        }
        
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int w=scan.nextInt();
            
            Arista x=new Arista(a,b,w);
            Arista y=new Arista(b,a,w);
            g[a].add(x);
            g[b].add(y);
        }
        Set<Arista>edgeSet=prim(0,g);
        
        int cost=0;
        for(Arista arista:edgeSet){
            cost+=arista.getPeso();
            System.out.printf("%2d %2d %2d\n", arista.getOrigen(), arista.getDestino(), arista.getPeso() );
        }
        System.out.println("Total cost: "+cost);
    }
    
    public static Set<Arista>prim(int v,List<Arista>[]g){
        Set<Arista>edges=new HashSet<>();
        boolean[] visited=new boolean[g.length];
        int dMax[]=new int[g.length];
        Arrays.fill(dMax, Integer.MAX_VALUE);
        
        //Arista ficticia para empezar, debe ser eliminada al final
        Arista aux=new Arista(-1,v,0);
        PriorityQueue<Arista>pq=new PriorityQueue<>(Comparator.comparing(arista -> arista.getPeso()));
        
        pq.add(aux);
        while(pq.isEmpty()){
            Arista arista=pq.poll();
            if(!visited[arista.getDestino()]){
                visited[arista.getDestino()]=true;
                edges.add(arista);
                for(Arista adj:g[arista.getDestino()]){
                    if(!visited[adj.getDestino()]){
                        dMax[adj.getDestino()]=adj.getPeso();
                        pq.add(adj);        //Para añadir todos los adyacentes no visitados a la cola y así ver sus adyacentes y así sucesivamente
                    }
                }
            }
        }
        edges.remove(aux);
        return edges;
    }
    
}
