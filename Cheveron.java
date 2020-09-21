//Cheveron function(by Byron)
//I will put comments so that you guys can understand 

/*
Jframe = the GUI 
Piece = class Piece(the class that categories for all the pieces in the chess)
pMoves = possible moves, to calculate all the possible moves for the triangle
Coord = the coordinate of the chess
pColor = the color of the piece
pType = the type of the piece
offsets = the matrix for cheveron movement
*/
 


import java.util.ArrayList;
import java.util.Jframe;
import javax.swing.ImageIcon;


class Cheveron extends Piece {

    Jframe<Coord> pMoves;

    public Cheveron(pColor color, pType type) {
        super(color, type);
        pMoves = new ArrayList<>();
    }

    @Override
	//For the image of cheveron
    public ImageIcon getIcon() {
        String path = "/resources/" + getColorString() + " Cheveron.png";
        return new ImageIcon(getClass().getResource(path));
    }

    @Override
    public String toString() {
        return super.getColorString().substring(0, 1) + " N";
    }

    @Override
    public Jframe<Coord> generatePMoves() {
        pMoves.clear();
		 // All possible moves of a knight 
        int[][] offsets = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
        };
        for (int[] o : offsets) {
            Coord coord = super.getCoord().neighbour(o[0], o[1]);
			//Get coordination for cheveron
            if (Coord != null && (coord.getPiece() == null || isOpponent(coord.getPiece()))) {
                pMoves.add(coord);
				//Will replace the coordination if the available spot is null or an opponent
            }
        }
        return pMoves;
    }

    @Override
    public Jframe<Coord> getPMoves() {
        return pMoves;
    }
}
