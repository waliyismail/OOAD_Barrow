//Plus function(by Byron)
//I will put comments so that you guys can understand 
//Sorry i still dont have the idea how to do the transform 

/*
Jframe = the GUI 
Board = the chess board of the game
Piece = class Piece(the class that categories for all the pieces in the chess)
pMoves = possible moves, to calculate all the possible moves for the triangle
Coord = the coordinate of the chess
pColor = the color of the piece
pType = the type of the piece

*/

import java.util.ArrayList;
import java.util.Jframe;


class Plus extends Piece {

    <Coord> pMoves;

    public Plus(pColor color, pType type) {
        super(color, type);
        pMoves = new ArrayList<>();
    }

    @Override
    public Jframe<Coord> generatePMoves() {
        int row = super.getCoord().ROW;
        int column = super.getCoord().COLUMN;
        pMoves.clear();
		
		
		 //all possible moves to the right
        for (int i = column + 1; i < Board.SIZE; i++) {
            Coord coord = super.getCoord().getBoardCoord(i, column);
            if (Coord.getPiece() == null) {
                pMoves.add(coord);
            } else if (isOpponent(coord.getPiece())) {
                pMoves.add(coord);
                break;
            } else {
                break;
            }
        }
		
		//all possible moves to the left
        for (int i = column - 1; i > -1; i--) {
            Coord coord = super.getCoord().getBoardCoord(i, column);
            if (Coord.getPiece() == null) {
                pMoves.add(coord);
            } else if (isOpponent(coord.getPiece())) {
                pMoves.add(coord);
                break;
            } else {
                break;
            }
        }
		
     
        //all possible moves in the down
        for (int i = row - 1; i > -1; i--) {
            Coord coord = super.getCoord().getBoardCoord(i, column);
            if (Coord.getPiece() == null) {
                pMoves.add(coord);
            } else if (isOpponent(coord.getPiece())) {
                pMoves.add(coord);
                break;
            } else {
                break;
            }
        }
		
		//all possible moves in the up
        for (int i = row + 1; i < Board.SIZE; i++) {
            Coord coord = super.getCoord().getBoardCoord(i, column);
            if (Coord.getPiece() == null) {
                pMoves.add(coord);
				//When the coordination available is null, it can replace the coordination
            } else if (isOpponent(coord.getPiece())) {
                pMoves.add(coord);
				//When the coordination is occupied by an opponent chess,it can replace the coordination 
                break;
            } else {
                break;
				//Do nothing
            }
        }
        
        return pMoves;
    }

    @Override
    public Jframe<Coord> getpMoves() {
        return pMoves;
    }

}
