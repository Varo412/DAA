package casisudoku.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
    private static List<Sudoku> solucion=new ArrayList<>(); //soluciones    
    private int[][]board;          //board
    private int rs;     //número de soluciones

    public Sudoku(){
        this.board=new int[9][9];
        this.rs=0;
    }
    public void fillSudoku(){
        Scanner scan=new Scanner(System.in);

        for(int i=0;i<9;i++){       //INICIALIZAMOS SUDOKU
            for(int j=0;j<9;j++){
                board[i][j]=scan.nextInt();
            }
        }
    }

    public void printSudoku(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public int getVal(int r, int c){
        return board[r][c];
    }

    public void setVal(int r, int c, int k){
        board[r][c]=k;
    }

    public void clonSudoku(Sudoku s2){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.board[i][j]=s2.getVal(i, j);
            }
        }
    }

    public void increaseRs(){
        rs++;
    }

    public int getRs(){
        return rs;
    }

    

    public static void main(String[] args) {
        Sudoku sudoku=new Sudoku();
        sudoku.fillSudoku();
        
        solveSudoku(sudoku);       //rs=nº soluciones
        if(sudoku.getRs()==0){
            System.out.print("imposible");
        }
        else if(sudoku.getRs()>2){
            System.out.println("casi sudoku");
        }
        else{
            solucion.get(0).printSudoku();
        }
    }
    
    public static boolean solveSudoku(Sudoku sudoku){
       for(int r=0;r<9;r++){
           if(sudoku.getRs()>1){
                break;
            }
           for(int c=0;c<9;c++){
               if(sudoku.getVal(r, c)==0){
                   for(int num=1;num<10;num++){
                       if(isFeasible(sudoku,r,c,num)){
                           sudoku.setVal(r,c,num);
                           if(solveSudoku(sudoku)){
                               sudoku.increaseRs();
                               if(sudoku.getRs()>1){
                                   break;
                               }
                               Sudoku sudAux=new Sudoku();
                               sudAux.clonSudoku(sudoku);
                               solucion.add(sudAux);
                               //return true;
                           }
                           //else{
                               sudoku.setVal(r, c, 0);      //marcha atrás
                           //}
                       }
                   }
                   if(sudoku.getRs()>1){
                        break;
                    }
                   return false;        //no se ha encontrado número que encaje
               }
           }
       }
        return true;
    }

    private static boolean isFeasible(Sudoku sudoku,int r, int c,int k){
        for(int i=0;i<9;i++){
            if((sudoku.getVal(i, c)==k)||(sudoku.getVal(r, i)==k)){
                return false;
            }
        }
        int aux1;
        int aux2;
        if(r<3){
            aux1=0;
        }
        else if(r<6){
            aux1=3;
        }
        else aux1=6;
        
        if(c<3){
            aux2=0;
        }
        else if(c<6){
            aux2=3;
        }
        else aux2=6;
        
        for(int i=aux1;i<aux1+3;i++){       //recorremos bloque
            for(int j=aux2;j<aux2+3;j++){
                if(sudoku.getVal(i,j)==k){
                    return false;
                }
            }
        }    
        return true;
    }
    
}
