
public class Board {

    private final int size;
    private Space[][] boardArr;

    public Board(int size){
        this.size = size;
        this.boardArr = this.generateBoard();
    }
    public int getSize(){return this.size;}
    /*
    generates a new board of alternating coloured squares with *size* rows and *size* cols
     */
    private Space[][] generateBoard(){
        Space[][] newBoard = new Space[this.size][this.size];
        for (int i = 0; i < this.size ; i++) {
            for (int j = 0; j < this.size; j++) {
                if((i+j)%2 == 1){
                    newBoard[i][j] = new Space(i,j,Space.BLACK);
                }else {
                    newBoard[i][j] = new Space(i, j, Space.WHITE);
                }
            }
        }
        return newBoard;
    }

    public void placePiece(int row, int col, Piece newPiece) {
        try{
            this.boardArr[row][col].placePiece(newPiece);

            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if(row == i || col == j){
                        this.boardArr[i][j].isAttacking(true, this.boardArr[row][col].getPieceOnSpace().getColour());
                    }else if (Math.abs(i-row) == Math.abs(j - col)){
                        //DONEST WORK
                        this.boardArr[i][j].isAttacking(true, this.boardArr[row][col].getPieceOnSpace().getColour());
                        System.out.println("space: "+i+','+j + " is being attacked by: "+ this.boardArr[row][col].getPieceOnSpace().getColour());
                    }
                }

            }
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ignored){

        }
    }
    public void removePiece(int row, int col){
        this.boardArr[row][col].removePiece();
    }

    public void drawBoard(){
        System.out.printf("\n ");
        for (int i = 0; i < this.size; i++) {
            //draws top line
            System.out.print("___ ");
        }
        for (int i = 0; i < this.size ; i++) {
            System.out.println("");
            for (int j = 0; j < this.size; j++) {
                char squareMark = '_';
                if(this.boardArr[i][j].getPieceOnSpace() == null){
                    //squareMark = (this.boardArr[i][j].getColour()==Space.BLACK)? 'b' : 'w';
                }else{
                    squareMark = (this.boardArr[i][j].getPieceOnSpace().getColour()==Piece.BLACK)? 'B' : 'W';
                }
                System.out.printf("|_%c_", squareMark);

            }
            System.out.print('|');
        }
    }

}
