import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            
            char[][] board = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};

            
            
            printBoard(board);


            for (int i =0; i<9 ; i++){
              System.out.print("Turn: ");
              if (i % 2 ==0){
                System.out.println('X');
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';
                printBoard(board);
              } else {
                System.out.println('O');
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
                printBoard(board);
              }
              
              if (checkWin(board) == 3) {              
                System.out.println("X wins!");              
                //System.exit(0);
                break;   
              } else if (checkWin(board) == -3) {
                System.out.println("O wins!");              
                //System.exit(0);
                break; 
              } else if (i == 8) {
                System.out.println("It's a tie!");
                break;
              }
              
              

            }
             


            scan.close();
        }

    public static void printBoard(char[][] board){
      System.out.print("\n");
      for (int i =0;i <board.length; i++){
        System.out.print("\t");
        for (int j =0; j<board[i].length; j++){
          System.out.print(board[i][j]+" ");
        }
        System.out.println("\n");
      }
    }
    



    public static int[] askUser(char[][] board){

      System.out.print("* pick a row and a column number: ");
      
      int row = scan.nextInt();
      int col = scan.nextInt();
      
      //check if taken
      while (board[row][col] != ('_')){
        System.out.println("Spot taken, try again: ");        
        row = scan.nextInt();
        col = scan.nextInt();
      }

      int[] spot = {row,col};
      return spot;      
    }

    public static int checkWin(char[][] board) {
      int count = 0;
      //check every row for a straight X/0
      //Your outer loop must run through each row 
      //while the inner loop runs through every character in that row.
      for (int i =0; i< board.length; i++){
        for (int j =0; j < board[i].length ; j++){          
          if (board[i][j] == 'X') {
            count++;            
          } else if (board[i][j] == 'O'){
            count--;            
          }
        }
        if (count == 3 || count == -3){
          return count;
        }
        else {
          count = 0;
        }
    }
      //check every column for a straight X/0
      //The outer loop picks a column.
      //The inner loop will index each row for that column.
      for (int k = 0; k < board[1].length;k++){
        for (int l = 0; l < board.length;l++){
          if (board[l][k] == 'X') {
            count++;            
          } else if (board[l][k] == 'O'){
            count--;            
          }          
        }
      if (count == 3 || count == -3){
        return count;
      }
      else {
        count = 0;
      }
      }


      //check left diagonal
      for (int ld = 0 ; ld < 3 ; ld++){
        if (board[ld][ld] == 'X') {
          count++;
        } else if (board[ld][ld] == 'O') {
          count--;
        }              
      }

      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }

      //check right diagonal
      for (int rd = 0 ; rd < 3 ; rd++){
        //int len = board[0].length;
        int pos = 2 - rd;
        if (board[rd][pos] == 'X') {
          count++;
        } else if (board[rd][pos] == 'O') {
          count--;
        }     
   
      }
      return count;
  }    
}
