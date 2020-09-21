import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * initiate all the state of the game
 * not finished
 * singleton
 * @author waliyismail
 *
 */
public class Game {
	
	private static final int DEFAULT = 0;
	private static final int SELECT = 1;
	private static final int MOVE = 2;
	private static Game single_instance = null; // ensure game is only instantiate one
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
	//int moveflag = 1; // each player needs to click 2 times, one choose pieces to move, another one is the location to move
	static volatile int numofclicks = SELECT; 
	static volatile ChessPiece curr;
	private Game() {
		
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
		redArrow1 = new Arrow("Arrow","red", 1, 0, "down", 1);
		redArrow2 = new Arrow("Arrow","red", 1, 2,"down", 1);
		redArrow3 = new Arrow("Arrow","red", 1, 4,"down", 1);
		redArrow4 = new Arrow("Arrow","red", 1, 6, "down", 1);
		
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
		chessPieces.add(redArrow4);
		
		//blue pieces
		blueSun = new Sun("sun", "blue", 7, 3);
		blueChevron1 = new Chevron("chevron", "blue", 7, 2 ,"up");
		blueChevron2 = new Chevron("chevron", "blue", 7, 4, "up");
		blueTriangle1 = new Triangle("triangle", "blue", 7, 1, "up");
		blueTriangle2 = new Triangle("triangle", "blue", 7, 5, "up");
		bluePlus1 = new Plus("plus", "blue", 7, 0);
		bluePlus2 = new Plus("plus", "blue", 7, 6);
		blueArrow1 = new Arrow("Arrow","blue", 6, 0, "up", 2);
		blueArrow2 = new Arrow("Arrow","blue", 6, 2, "up", 2);
		blueArrow3 = new Arrow("Arrow","blue", 6, 4, "up", 2);
		blueArrow4 = new Arrow("Arrow","blue", 6, 6, "up", 2);
		
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
		chessPieces.add(blueArrow4);
		
		gameSetup();
		pieceMovement();

	}
	
	public static Game getInstance() 
	{
		if (single_instance == null) 
            single_instance = new Game(); 
  
        return single_instance;
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
		
		// number of clicks determine the state of the listener
		// 1 -> select pieces
		// 2 -> move pieces
		// 0 -> default, select empty tile or opponent pieces

		// add listener for every tiles
		JButton[] tiles = gameBoard.getTiles();
		for(JButton t : tiles) 
		{
			t.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO listener varies with condition

					if(t.getIcon() == null) 
					{
						// not assigned with any chesspieces
						// check flag - move to new location/ do nothing
						switch(numofclicks) 
						{
						
							case SELECT:
								// do nothing
								System.out.println("no icon, select");
								numofclicks = SELECT;
								break;
								
							case MOVE:
								// change to this location
								System.out.println("no icon, move");
								if(curr != null) 
								{
									//curr.nextTile()
									//pieceMove(curr, Arrays.asList(tiles).indexOf(t) ));
									gameBoard.flipBoard(chessPieces);
								}
								numofclicks = SELECT;
								break;
								
							default:
								System.out.println("no icon, default");
								numofclicks = SELECT;
							
						}

					}else 
					{
						// tile contains a piece
						// highlight available
						// kill opponent piece
						switch(numofclicks) 
						{
						
							case SELECT:
								// show available move
								System.out.println("got icon, select");
								curr = getPiece(Arrays.asList(tiles).indexOf(t));
								System.out.print("clicked " + curr.getName());
								highlightMove(curr);
								numofclicks = MOVE;
								break;
								
							case MOVE:
								// check if it is opponent or not
								// kill the opponent
								// remove chesspiece from array
								//pieceMove(p, new Point(t.getX(), t.getY()));
								if(curr == null)
								{
									// clicked friendly tiles
									
								}else 
								{
									//if()
									gameBoard.flipBoard(chessPieces);
								}
								System.out.println("got icon, move");
								numofclicks = SELECT;
								break;
								
							default:
								System.out.println("got icon, default");
								numofclicks = SELECT;
							
						}
					}
					
				}});
		}
//		for(ChessPiece p : chessPieces) 
//		{
//			JButton pieceTile = gameBoard.getTile(gameBoard.pieceIndex(p.getLocation().x, p.getLocation().y));
//			System.out.println(pieceTile.getName());
//			
//			pieceTile.addActionListener(new ActionListener(){
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					
//					gameBoard.resetTileBackground();
//					gameBoard.flipBoard(chessPieces);
//					Iterator<Point> iter = p.getAvailableMoves().iterator();
//					System.out.print(p.getAvailableMoves());
//					while(iter.hasNext()){
//						Point tile = iter.next();
//						JButton t = gameBoard.getTile(gameBoard.pieceIndex(tile.x, tile.y));
//						toggleHighlight(t);
////						t.addActionListener(new ActionListener() {
////
////							@Override
////							public void actionPerformed(ActionEvent e) {
////								gameBoard.resetTileBackground();
////								pieceMove(p,new Point(tile.x,tile.y));
////								t.removeActionListener(this);
////							}
////							
////						});
//						//t.setBackground(Color.cyan);
//					}
//					pieceTile.removeActionListener(this);
//				}
//				
//			});
			
//		}
		
		
	}
	public void highlightMove(ChessPiece p) {
		
		Iterator<Point> iter = p.getAvailableMoves().iterator();
		System.out.print(p.getAvailableMoves());
		while(iter.hasNext()){
			Point tile = iter.next();
			JButton t = gameBoard.getTile(gameBoard.pieceIndex(tile.x, tile.y));
			toggleHighlight(t);
			//t.setBackground(Color.cyan);
		}
	}

	public ChessPiece getPiece(int index) 
	{
		System.out.println(index);
		
		for(ChessPiece p : chessPieces) 
		{
			int i = gameBoard.pieceIndex(p.getLocation().x, p.getLocation().y);
			if( index == i)
			{
				// got same
				return p; 
			}
		}
		return null;
	}

	/**
	 * move current pieces to new location
	 * @param p Piece
	 * @param nextLocation Coordinate to be moved
	 */
	public void pieceMove(ChessPiece p, int index) 
	{
		gameBoard.resetTileIcon(p.getLocation().x, p.getLocation().y);
		int x = index/8;
		int y = index;
		p.setLocation(x, y);
		p.generateMoves();
		gameBoard.pieceSetup(p);
	}
	
	/**
	 * update board if any piece movement
	 */
	public void updateBoard() {};
	
	public void gameSetup() {
		for(ChessPiece c : chessPieces) 
		{
			if(c.getColor().contains("red")) 
			{
				c.setCurrentTurn(false);
			}
			else 
			{
				c.setCurrentTurn(true);
			}
			gameBoard.pieceSetup(c);
		}
	}
	public void toggleHighlight(JButton b) 
	{
		if(b.getBackground().equals(Color.white)) 
		{
			b.setBackground(Color.cyan);
			
		}
		b.getBackground().equals(Color.white);
	}
	
	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public static void main(String[] args)
	{
		Game.getInstance();
	}  
	
}
