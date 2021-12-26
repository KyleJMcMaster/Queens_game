public class Space {

    public static final int BLACK = 0;
    public static final int WHITE = 1;

    private Piece pieceOnSpace = null;
    private boolean isWhiteAttacking;
    private boolean isBlackAttacking;
    private final int col;
    private final int row;
    private final int colour;

    /*
    Getter methods
     */
    public Piece getPieceOnSpace(){return this.pieceOnSpace;}
    public int getCol(){return this.col;}
    public int getRow(){return this.row;}
    public int getColour(){return this.colour;}
    public boolean isWhiteAttacking(){return this.isWhiteAttacking;}
    public boolean isBlackAttacking(){return this.isBlackAttacking;}


    //constructor
    public Space(int row, int col, int colour){

        this.row = row;
        this.col = col;
        this.colour = colour;
        this.isWhiteAttacking = false;
        this.isBlackAttacking = false;
    }

    public void isAttacking(boolean attack, int colour)
    {if(colour == Space.BLACK){
        this.isBlackAttacking = attack;
    }else{
        this.isWhiteAttacking = attack;
        }
    }

    /*
    checks if new piece can be placed
    if not throws error
    if it can, assigns the piece to the square
     */
    public void placePiece(Piece newPiece) throws IllegalArgumentException{
        if(!this.canPlace(newPiece)){
            throw new IllegalArgumentException("Piece cannot be placed");
        }
        this.pieceOnSpace = newPiece;

    }
    /*
    checks if the new piece can be placed on the current square without being attacked
     */
    private boolean canPlace(Piece newPiece) {
        if(this.pieceOnSpace != null){
            return false;
        }
        if(newPiece.getColour() == Piece.BLACK){
            if (!this.isWhiteAttacking){
                return true;
            }else{
                return false;
            }
        }else{
            if (!this.isBlackAttacking){
                return true;
            }else{
                return false;
            }
        }
    }
    /*
    if there is a piece to remove, removes it.
     */
    public void removePiece(){
        if(this.pieceOnSpace != null){
            this.pieceOnSpace = null;

        }
    }


}
