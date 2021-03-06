/**
 * Board to hold the chess pieces
 * not finished
 * @author WaliyIsmail
 * 
 */

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Board extends JFrame implements ActionListener
{
    
    private static final int WIDTH = 7;
    private static final int HEIGHT = 8;
    private int totalTiles = WIDTH*HEIGHT;
    private JButton[] tiles = new JButton[totalTiles];
    private JPanel optionBar = new JPanel(new FlowLayout());
    private JPanel gameBoard = new JPanel(new GridLayout(HEIGHT,WIDTH));
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");
    

    /**
     * Constructor for objects of class Board
     * Create a tiles with JButton 
     */
    public Board()
    {
        super("Webale Chess");
        setSize(500,600);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        gameBoard.setBackground(Color.blue);
        saveButton.setName("save");
        optionBar.add(saveButton);
        optionBar.add(loadButton);
        initBoard();        
        add(optionBar,BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
/* TODO
    1) create tiles using Jbuttons //
    2) add bar for save and load/ resizable window
    3) flip board
    4) which player move
*/
    /**
     * move the chess pieces to opposite tiles
     * reverses the icon if flipped
     * @param cp array of chess piece
     * @author waliy
     */
    public void flipBoard(ArrayList<ChessPiece> cp)
    {
    	resetBoard();
    	for(ChessPiece c : cp) 
    	{
    		int x = c.getLocation().x;
    		int y = c.getLocation().y;
    		int newX = HEIGHT-1-x;
    		int newY = WIDTH-1-y;
    		c.setLocation(newX, newY);
    		if(c.currentTurn()) {
    			c.reverseIcon(false);
    			c.setCurrentTurn(false);
    		}else {
    			c.setCurrentTurn(true);
    			c.reverseIcon(true);
    		}
    		//c.reverseIcon(true);
    		pieceSetup(c);
    	}
        // the grid stays the same
        // change the location(coordinate) using algorithm
        // record the coordinate
        // tilenumber = x + y*WIDTH <-- get the specific JButton(tiles) index 
        // newx = width-1-x , newy = height -1-y
        // newtilenumber = newx + newy*WIDTH
    	
    }
    
    
    public JButton getTile(int index) {
		return tiles[index];
	}
    public JButton[] getTiles() {
		return tiles;
	}
	public void setTiles(JButton tiles , int index) {
		this.tiles[index] = tiles;
	}
	public void initBoard() {
    	// add JButton to each grid in gameBoard
        for(int i=0; i<totalTiles; i++){
            //TODO JButton can be changed to ChessPiece class or tiles class
            //TODO each pieces must associated with coordinate 
            //TODO addActionListener needs be change to chesspiecelistener or something similar
            tiles[i] = new JButton(); //e.g tiles[i] = new tiles
            tiles[i].setBackground(Color.WHITE);
            tiles[i].setName(Integer.toString(i));
            gameBoard.add(tiles[i]);
            //tiles[i].addActionListener(this);
        }
        
    }
    /**
     * get the index of the piece in the boardlist(tiles)
     * @param x X coordinate
     * @param y Y coordinate
     * @return index of particular piece
     */
    public int pieceIndex(int x, int y) 
    {
    	return x*WIDTH+ y;
    }
    
    /**
     * Set ups the board with piece placement
     * @param p
     */
    public void pieceSetup(ChessPiece p) 
    {
    	p.generateMoves();
    	char color = p.getColor().toString().charAt(0);
    	String type = p.getName();
    	String orientation=p.getOrientation();
    	
    	// reverse blue when not current turn
    	if(!p.currentTurn() && p.getColor().contentEquals("blue")) 
    	{
    		//System.out.println("reverse");
    		if(orientation.contentEquals("up")) {
    			orientation = "down";
    		}else if(orientation.contentEquals("down")) 
    		{
    			orientation = "up";
    		}else 
    		{
    			//System.out.println("default ");
    		}
    		
    	}
    	// reverse blue when current turn
    	if(p.currentTurn() && p.getColor().contentEquals("red")) 
    	{
    		//System.out.println("reverse");
    		if(orientation.contentEquals("up")) {
    			orientation = "down";
    		}else if(orientation.contentEquals("down")) 
    		{
    			orientation = "up";
    		}else 
    		{
    			//System.out.println("default ");
    		}
    		
    	}
    	p.reverseIcon(false);
    	//System.out.println(orientation);
    	ImageIcon iconName = new ImageIcon(color+type+orientation+".png");
    	int index = pieceIndex(p.getLocation().x,p.getLocation().y);
    	
    	//TODO set tile disable if not current player
    	if(!p.currentTurn()) {
    		
    		tiles[index].setEnabled(false);;
    	}
		tiles[index].setIcon(iconName);
		tiles[index].setDisabledIcon(iconName);
    	
    	//System.out.println(iconName.toString());
    	
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton temp = (JButton)e.getSource();
        System.out.println("button " + temp.getName() + " clicked!");
    }
    
	public void setPieces(ArrayList<ChessPiece> pieces) 
	{
	}
	
	/**
	 * set all tile background to be white
	 */
	public void resetTileBackground()
	{
		for(JButton t : tiles) 
		{
			t.setBackground(Color.WHITE);
		}
	}
	
	public void resetTileIcon(int x, int y)
	{
		this.tiles[pieceIndex(x, y)].setIcon(null);
	}
	
	/**
	 * set all tiles to fresh new
	 */
	public void resetBoard()
	{
		for(JButton t : tiles) 
		{
			t.setIcon(null);
			t.setDisabledIcon(null);
			t.setEnabled(true);
			t.setBackground(Color.WHITE);
		}
	}
	public boolean hasFriendlytile(ChessPiece p, int x, int y) 
	{
		int i = pieceIndex(x,y);
		if(tiles[i].getIcon() == null) return false;
		if(!tiles[i].getIcon().toString().contains(p.getColor())) return false;
		return true;
	}
	
	/**
	 * get the x and y location of the tile with index
	 * @param index
	 * @return
	 */
	public Point tileCoordinate(int index) 
	{
		//JButton b = tiles[index];
		int x = 0;
		int y = 0;
		for(int i = 0 ; i < WIDTH; i++) 
		{
			for(int j = 0 ; j < HEIGHT; j++) 
			{
				if(j*WIDTH+ i == index) 
				{
					x = j;
					y = i;
				}
			}
		}
		return new Point(x,y);
	}
	
                   
}
