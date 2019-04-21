package sudokusolverbacktracking;

import java.util.Scanner;

public class SudokuSolverBackTracking {

    public static void main(String[] args) {
        int[][]sudoku=new int[9][9];
        Scanner scan=new Scanner(System.in);
        
        for(int i=0;i<9;i++){       //INICIALIZAMOS SUDOKU
            for(int j=0;j<9;j++){
                sudoku[i][j]=scan.nextInt();
            }
        }
        
        solveSudoku(sudoku);  //
        for(int i=0;i<9;i++){       //INICIALIZAMOS SUDOKU
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.print("\n");
        }
        
    }
    
    public static boolean solveSudoku(int[][]sudoku){
       for(int r=0;r<9;r++){
           for(int c=0;c<9;c++){
               if(sudoku[r][c]==0){
                   for(int num=1;num<10;num++){
                       if(isFeasible(sudoku,r,c,num)){
                           sudoku[r][c]=num;
                           if(solveSudoku(sudoku)){
                               return true;
                           }
                           else{
                               sudoku[r][c]=0;      //marcha atrás
                           }
                       }
                   }
                   return false;        //no se ha encontrado número que encaje
               }
           }
       }
        return true;
    }

    private static boolean isFeasible(int[][]sudoku,int r, int c,int k){
        for(int i=0;i<9;i++){
            if((sudoku[i][c]==k)||(sudoku[r][i]==k)){
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
                if(sudoku[i][j]==k){
                    return false;
                }
            }
        }    
        return true;
    }
    
}
