import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * initiate all the state of the game
 * not finished
 * @author waliyismail
 *
 */
public class Game {
	
	private Board gameBoard;
	private Sun redSun;
	private Chevron redChevron1;
	private Chevron redChevron2;
	private Triangle redTriangle1;
	private Triangle redTriangle2;
	private Plus redPlus1;
	private Plus redPlus2;
	private Arrow redArrow1;
	private Arrow redArrow2;
	private Arrow redArrow3;
	private Arrow redArrow4;
	private Sun blueSun;
	private Chevron blueChevron1;
	private Chevron blueChevron2;
	private Triangle blueTriangle1;
	private Triangle blueTriangle2;
	private Plus bluePlus1;
	private Plus bluePlus2;
	private Arrow blueArrow1;
	private Arrow blueArrow2;
	private Arrow blueArrow3;
	private Arrow blueArrow4;
	private ArrayList<ChessPiece> chessPieces;
	int moveflag = 1; // each player needs to click 2 times, one choose pieces to move, another one is the location to move

	public Game() {
		
		chessPieces = new ArrayList<>();
		gameBoard = new Board();
	
		//red pieces
		redSun = new Sun("sun", "red", 0, 3);
		redChevron1 = new Chevron("chevron", "red", 0, 2, "down");
		redChevron2 = new Chevron("chevron", "red", 0, 4, "down");
		redTriangle1 = new Triangle("triangle", "red", 0, 1, "down");
		redTriangle2 = new Triangle("triangle", "red", 0, 5, "down");
		redPlus1 = new Plus("plus", "red", 0, 0);
		redPlus2 = new Plus("plus", "red", 0, 6);
		redArrow1 = new Arrow("Arrow","red", 1, 0, "down");
		redArrow2 = new Arrow("Arrow","red", 1, 2,"down");
		redArrow3 = new Arrow("Arrow","red", 1, 4,"down");
		redArrow4 = new Arrow("Arrow","red", 1, 6, "down");
		
		chessPieces.add(redSun);
		chessPieces.add(redChevron1);
		chessPieces.add(redChevron2);
		chessPieces.add(redTriangle1);
		chessPieces.add(redTriangle2);
		chessPieces.add(redPlus1);
		chessPieces.add(redPlus2);
		chessPieces.add(redArrow1);
		chessPieces.add(redArrow2);
		chessPieces.add(redArrow3);
		chessPieces.add(redArrow3);

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
		blueSun = new Sun("sun", "blue", 7, 3);
		blueChevron1 = new Chevron("chevron", "blue", 7, 2 ,"up");
		blueChevron2 = new Chevron("chevron", "blue", 7, 4, "up");
		blueTriangle1 = new Triangle("triangle", "blue", 7, 1, "up");
		blueTriangle2 = new Triangle("triangle", "blue", 7, 5, "up");
		bluePlus1 = new Plus("plus", "blue", 7, 0);
		bluePlus2 = new Plus("plus", "blue", 7, 6);
		blueArrow1 = new Arrow("Arrow","blue", 6, 0, "up");
		blueArrow2 = new Arrow("Arrow","blue", 6, 2, "up");
		blueArrow3 = new Arrow("Arrow","blue", 6, 4, "up");
		blueArrow4 = new Arrow("Arrow","blue", 6, 6, "up");
		
		chessPieces.add(blueSun);
		chessPieces.add(blueChevron1);
		chessPieces.add(blueChevron2);
		chessPieces.add(blueTriangle1);
		chessPieces.add(blueTriangle2);
		chessPieces.add(bluePlus1);
		chessPieces.add(bluePlus2);
		chessPieces.add(blueArrow1);
		chessPieces.add(blueArrow2);
		chessPieces.add(blueArrow3);
		chessPieces.add(blueArrow3);
		
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
		pieceMovement();

	}
	
	public void checkWinner() {};
	/**
	 * waliy
	 * forall chesspiece, get the index of tile .
	 * get the available move for each chesspieces
	 * add each a listener for to highlight the board (cyan)
	 * tightly coupled i know
	 */
	public void pieceMovement() {
		
		for(ChessPiece p : chessPieces) 
		{
			JButton pieceTile = gameBoard.getTile(gameBoard.pieceIndex(p.getLocation().x, p.getLocation().y));
			System.out.println(pieceTile.getName());
			pieceTile.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					gameBoard.resetTileBackground();
					Iterator<Point> iter = p.getAvailableMoves().iterator();
					
					while(iter.hasNext()){
						Point tile = iter.next();
						JButton t = gameBoard.getTile(gameBoard.pieceIndex(tile.x, tile.y));
						t.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								pieceMove(p,new Point(tile.x,tile.y));
								
							}
							
						});
						t.setBackground(Color.cyan);
					}
				}
			});
		}
		
		
	}
	public void movetoemptyTile() {};
	
	public void pieceMove(ChessPiece p, Point nextLocation) 
	{
		gameBoard.resetTileIcon(p.getLocation().x, p.getLocation().y);
		p.setLocation(nextLocation.x, nextLocation.y);
		gameBoard.pieceSetup(p);
	}
	

	public static void main(String[] args)
	{
		new Game();
	}  
	
}
