public class Main {

    public static void main(String[] args){

        Board board = new Board(8);
        Piece blackQ = new Piece(Piece.BLACK);
        Piece whiteQ = new Piece(Piece.WHITE);
        board.placePiece(5,7, blackQ);
        board.placePiece(2,2, blackQ);

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.placePiece(i,j,whiteQ);
            }

        }

        board.drawBoard();
    }


}
