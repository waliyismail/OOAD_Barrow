//Triangle function(by Byron)
//I will put comments so that you guys can understand 

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


class Triangle extends Piece {

    <Coord> pMoves;

    public Triangle(pColor color, pType type) {
        super(color, type);
        pMoves = new ArrayList<>();
    }

    @Override
    public JFrame<Coord> generatePMoves() {
        int row = super.getCoord().ROW;
        int column = super.getCoord().COLUMN;
        pMoves.clear();
		
        
		 //all possible moves in the down negative diagonal
        for (int j = column + 1, i = row - 1; j < Board.SIZE && i > -1; j++, i--) {
            Coord coord = super.getCoord().getBoardCoord(i, j);
            if (coord.getPiece() == null) {
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
        
        //all possible moves in the up negative diagonal
        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
            Coord coord = super.getCoord().getBoardCoord(i, j);
            if (coord.getPiece() == null) {
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
       
		//all possible moves in the down positive diagonal
        for (int j = column + 1, i = row + 1; j < Board.SIZE && i < Board.SIZE; j++, i++) {
            Coord coord = super.getCoord().getBoardCoord(i, j);
            if (coord.getPiece() == null) {
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
		
		//all possible moves in the up positive diagonal
        for (int j = column - 1, i = row + 1; j > -1 && i < Board.SIZE; j--, i++) {
            Coord coord = super.getCoord().getBoardCoord(i, j);
            if (coord.getPiece() == null) {
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
