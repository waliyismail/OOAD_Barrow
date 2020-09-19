import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * initiate all the state of the game
 * not finished
 * @author waliyismail
 *
 */
public class Game {

	public Game() {
		
		ArrayList<ChessPiece> pieces = new ArrayList<>();
		Board gameBoard = new Board();
	
		//red pieces
		ChessPiece redSun = new Sun("sun", "red", 7, 3);
		Chevron redChevron1 = new Chevron("chevron", "red", 7, 2);
		Chevron redChevron2 = new Chevron("chevron", "red", 7, 4);
		Triangle redTriangle1 = new Triangle("triangle", "red", 7, 1);
		Triangle redTriangle2 = new Triangle("triangle", "red", 7, 5);
		Plus redPlus1 = new Plus("plus", "red", 7, 0);
		Plus redPlus2 = new Plus("plus", "red", 7, 6);
		Arrow redArrow1 = new Arrow("Arrow","red", 6, 0, "up");
		Arrow redArrow2 = new Arrow("Arrow","red", 6, 2,"up");
		Arrow redArrow3 = new Arrow("Arrow","red", 6, 4,"up");
		Arrow redArrow4 = new Arrow("Arrow","red", 6, 6, "up");
		gameBoard.pieceSetup(redSun);
		gameBoard.pieceSetup(redChevron1);
		gameBoard.pieceSetup(redChevron2);
		gameBoard.pieceSetup(redTriangle1);
		gameBoard.pieceSetup(redTriangle2);
		gameBoard.pieceSetup(redPlus1);
		gameBoard.pieceSetup(redPlus2);
		gameBoard.pieceSetup(redArrow1);
		gameBoard.pieceSetup(redArrow2);
		gameBoard.pieceSetup(redArrow3);
		gameBoard.pieceSetup(redArrow4);
		
		//blue pieces
		Sun blueSun = new Sun("sun", "blue", 7, 3);
		Chevron blueChevron1 = new Chevron("chevron", "blue", 7, 2);
		Chevron blueChevron2 = new Chevron("chevron", "blue", 7, 4);
		Triangle blueTriangle1 = new Triangle("triangle", "blue", 7, 1);
		Triangle blueTriangle2 = new Triangle("triangle", "blue", 7, 5);
		Plus bluePlus1 = new Plus("plus", "blue", 7, 0);
		Plus bluePlus2 = new Plus("plus", "blue", 7, 6);
		Arrow blueArrow1 = new Arrow("Arrow","blue", 6, 0, "down");
		Arrow blueArrow2 = new Arrow("Arrow","blue", 6, 2, "down");
		Arrow blueArrow3 = new Arrow("Arrow","blue", 6, 4, "down");
		Arrow blueArrow4 = new Arrow("Arrow","blue", 6, 6, "down");
		gameBoard.pieceSetup(blueSun);
		gameBoard.pieceSetup(blueChevron1);
		gameBoard.pieceSetup(blueChevron2);
		gameBoard.pieceSetup(blueTriangle1);
		gameBoard.pieceSetup(blueTriangle2);
		gameBoard.pieceSetup(bluePlus1);
		gameBoard.pieceSetup(bluePlus2);
		gameBoard.pieceSetup(blueArrow1);
		gameBoard.pieceSetup(blueArrow2);
		gameBoard.pieceSetup(blueArrow3);
		gameBoard.pieceSetup(blueArrow4);
		pieces.add(redSun);
		gameBoard.setPieces(pieces);

	}
	public static void main(String[] args)
	{
		new Game();
	}  
	
}
