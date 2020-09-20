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
//	//Image imports
//	ImageIcon bChevron =new ImageIcon("bchevron.png");
//    ImageIcon rChevron =new ImageIcon("rchevron.png");
//    ImageIcon rSun =new ImageIcon("rsun.png");
//    ImageIcon bSun =new ImageIcon("bsun.png");
//    ImageIcon bArrow =new ImageIcon("bArrow.png");
//    ImageIcon rArrow =new ImageIcon("rArrow.png");
//    ImageIcon bPlus =new ImageIcon("rplus.png");
//    ImageIcon rPlus =new ImageIcon("bplus.png");
//    ImageIcon bTriangle =new ImageIcon("btriangle.png");
//    ImageIcon rTriangle =new ImageIcon("rtriangle.png");
    
    private static final int WIDTH = 7;
    private static final int HEIGHT = 8;
    private int totalTiles = WIDTH*HEIGHT;
    JButton[] tiles = new JButton[totalTiles];
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
        optionBar.add(saveButton);
        optionBar.add(loadButton);
        initBoard();        
        add(optionBar,BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        //set tile number
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
    public void flipBoard()
    {

        // the grid stays the same
        // change the location(coordinate) using algorithm
        // record the coordinate
        // tilenumber = x + y*WIDTH <-- get the specific JButton(tiles) index 
        // newx = width-1-x , newy = height -1-y
        // newtilenumber = newx + newy*WIDTH
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
            tiles[i].addActionListener(this);
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
     * Set ups the board with initial piece placement
     * @param p
     */
    public void pieceSetup(ChessPiece p) 
    {
    	char color = p.getColor().toString().charAt(0);
    	String type = p.getName();
    	ImageIcon iconName = new ImageIcon(color+type+ ".png");
    	tiles[pieceIndex(p.getLocation().x,p.getLocation().y)].setIcon(iconName);
    	//System.out.println(iconName.toString());
    	
    }
     public void pieceSetupArrows(ChessPiece p) 
    {
        char color = p.getColor().toString().charAt(0);
        String type = p.getName();
        String orientation=p.getOrientation();
        ImageIcon iconName = new ImageIcon(color+type+orientation+ ".png");
        tiles[pieceIndex(p.getLocation().x,p.getLocation().y)].setIcon(iconName);
        //System.out.println(iconName.toString());
        
    }
    public ImageIcon setImage(ChessPiece p) 
    {
    	setVisible(false);
    	char color = p.getColor().toString().charAt(0);
    	String type = p.getName();
    	ImageIcon iconName = new ImageIcon(color+type+ ".png");
    	return iconName;
    	
    }
    public void actionPerformed(ActionEvent e)
    {
        JButton temp = (JButton)e.getSource();
        System.out.println("button " + temp.getName() + " clicked!");
    }
	public void setPieces(ArrayList<ChessPiece> pieces) {
		
	}

                   
}