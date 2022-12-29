/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueen;

/**
 *
 * @author Elza Morgan
 */
public class Nqueen {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         int board[][] = { 
                          {0,0,0,0},
                          {0,0,0,0},
                          {0,0,0,0},
                          {0,0,0,0} 
                        };
    boolean check=backtrack(board,0,4);
    if(check==false)
    {
            System.out.println("No solution");
    }
    else
        {
            printTable(board,4); 
        }
    }
    
    public static Boolean backtrack(int board[][], int row, int q)
    {   //to make sure that we reached max of queens on the board
        if(row==q)
        {
            return true;
        }
        //every row which represents the queens have coloumns from 0 to 3 to keep checking
        //we add rows and check coloumns if the queens are safe
        for(int col=0; col<q; col++)
        {
            boolean checksafe=checkIsSafe(board,row,col,4);
            if(checksafe==true)//when my return funtion is true
            {
                board[row][col]=1;
                
                boolean checkBacktrack=backtrack(board,row+1,4);//recursuion(adding another queen)
                //this if condition is used to make sure that my queens are plotted and that 
                //they are safe and to keep track how many queens are kept safe on the bored
                //after all the queens are plotted true will be returned to original caller in main
                if(checkBacktrack==true)    
                {
                    return true; 
                }
                
            }
            board[row][col]=0;// that's the backtrack it self which makes the perviuos queen zero
                              // and increant it's coloumn 
        
        }
        return false;
    }
    
    public static boolean checkIsSafe(int board[][],int row, int col, int q) 
    { //col constant and row varible0
        //checks the avalibity of the whole row of first col
        for(int rows=0; rows<q; rows++)
        {
            if(board[rows][col]==1)
            {
                return false;
            }
        }
         //r is ++ to go down
        //c is -- to go left
        int r,c; 
        for(r=row,c=col ; r<q && c>=0; r++, c--)
        {
            if(board[r][c]==1)
            {
                return false;
            }
        }
        //r is -- to go up
        //c is -- to go left  
        for(r=row,c=col ; r>=0 && c>=0; r--, c--)
        {
            if(board[r][c]==1)
            {
                return false;
            }
        }
       
 
     return true;
    }
    public static void printTable(int board[][],int q)
    { 
        for(int r=0; r<q ;r++)
        {
            for(int c=0; c<q; c++)
            {
                System.out.print(" "+board[r][c]+" ");  
                
            }
            System.out.println();
            
        }
    }
   
}
