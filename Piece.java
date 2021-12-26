public class Piece {
    public static final int BLACK = 0;
    public static final int WHITE = 1;

    private final int colour;


    public int getColour(){return this.colour;}

    public Piece(int colour){
        this.colour = colour;
    }
}
