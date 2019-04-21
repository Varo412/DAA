package labyrinthBackTracking;

import java.util.Scanner;

public class LabyrinthBackTracking {
    private static int sol;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();   //u2 size
        int [][] board=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=scan.nextInt();
            }
        }
        solveLabyrinth(board);
        if(sol==board.length*board.length+1){       //máximo de pasos posibles +1
            System.out.print("SIN SOLUCION");
        }
        else{
            System.out.print(sol);
        }
        
    }
    
    public static void solveLabyrinth(int[][] board){
        int steps=0;
        LabyrinthBackTracking.sol=board.length*board.length+1;       //máximo de pasos posibles +1
        recursiveSolver(board,0,0,1,steps);
    }
    

    private static int recursiveSolver(int[][]board,int r, int c, int k, int steps){
        board[r][c]=k;
        steps++;
        if(r==board.length-1 && c==board.length-1){     //llegamos al final
            if(steps<sol)                     //si la nueva puntuación es mejor que la anterior
                sol=steps;
            board[r][c]=0;
            return steps;
        }
        else{
            if(isFeasible(board,r+1,c)){
                recursiveSolver(board,r+1,c,k,steps);
            }
            if(isFeasible(board,r,c+1)){
                recursiveSolver(board,r,c+1,k,steps);
            }
            if(isFeasible(board,r-1,c)){
                recursiveSolver(board,r-1,c,k,steps);
            }
            if(isFeasible(board,r,c-1)){
                recursiveSolver(board,r,c-1,k,steps);
            }
            board[r][c]=0;
            steps--;
        }
        
        return steps;
    }
    
    private static boolean isFeasible(int [][] board, int r, int c){
        if((r<board.length)&&(r>=0)&&(c<board.length)&&(c>=0)){
            return board[r][c]==0;
        }
        return false;
    }
    
}
