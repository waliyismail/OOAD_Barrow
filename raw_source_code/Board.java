import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Board extends JFrame implements ActionListener
{
    private static final int WIDTH = 7;
    private static final int HEIGHT = 8;
    private int totalTiles = WIDTH*HEIGHT;
    private JButton[][] tiles = new JButton[HEIGHT][WIDTH];
    private JPanel optionBar = new JPanel(new FlowLayout());
    private JPanel gameBoard = new JPanel(new GridLayout(HEIGHT,WIDTH));
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");
    int r0=0,r1=1,r2=2,r3=3,r4=4,r5=5,r=6,r7=7;
    int c0=0,c1=1,c2=2,c3=3,c4=4,c5=5,c6=6;
    ImageIcon bChevron =new ImageIcon("Pieces/bchevron.png");
    ImageIcon rChevron =new ImageIcon("Pieces/rchevron.png");
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
        
        /**
         * cr
         */
        // add JButton to each grid in gameBoard
        for(int i=0; i<HEIGHT; i++){
            for(int j=0; j<WIDTH; j++){
            //TODO JButton can be changed to ChessPiece class or tiles class
            //TODO each pieces must associated with coordinate 
            //TODO addActionListener needs be change to chesspiecelistener or something similar
            tiles[i][j] = new JButton(""+i+j); //e.g tiles[i] = new tiles
            tiles[i][j].setBackground(Color.WHITE);
            tiles[i][j].setName(Integer.toString(j));
            gameBoard.add(tiles[i][j]);
            tiles[i][j].addActionListener(this);
            
        }
        
    }
        tiles[7][2].setIcon(bChevron);
        tiles[7][4].setIcon(bChevron);
        tiles[0][2].setIcon(rChevron);
        tiles[0][4].setIcon(rChevron);
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
    public void flipBoard()
    {

        // the grid stays the same
        // change the location(coordinate) using algorithm
        // record the coordinate
        // tilenumber = x + y*WIDTH <-- get the specific JButton(tiles) index 
        // newx = width-1-x , newy = height -1-y
        // newtilenumber = newx + newy*WIDTH
    }
    public void actionPerformed(ActionEvent e)
    {
       JButton temp = (JButton)e.getSource();
        System.out.println("button " + temp.getName() + " clicked!");
   Object source= e.getSource();
      for(int i=0; i<HEIGHT; i++)
        {
          for(int j=0;j<WIDTH;j++)
         {
            if(source==tiles[i][j])
            {
               
               bChevron1Click(i,j);
               bChevron2lick(i,j);
               rChevron1Click(i,j);
               rChevron2Click(i,j);
               return;
           }
          }
        }
    }
     public void bChevron1Click(int i,int j)
    {
    if(bc1ValidMove(i,j)== false)
    {return;}
    tiles[r7][c2].setIcon(null);
    tiles[i][j].setIcon(bChevron);
    r7 =i;
    c2 =j;
    }
    public boolean bc1ValidMove(int i,int j)
    {
     int rowDe=Math.abs(i-r7);
     int colDe=Math.abs(j-c2);
     
     if((rowDe==1)&&(colDe==2))
     {
     return true;   
     }
     if((colDe==1)&&(rowDe==2))
     {
     return true;   
     }
     
     return false;
    }   
    public void bChevron2lick(int i,int j)
    {
    if(bc2ValidMove(i,j)== false)
    {return;}
    tiles[r7][c4].setIcon(null);
    tiles[i][j].setIcon(bChevron);
    r7 =i;
    c4 =j;
    }
    public boolean bc2ValidMove(int i,int j)
    {
     int rowDe=Math.abs(i-r7);
     int colDe=Math.abs(j-c4);
     
     if((rowDe==1)&&(colDe==2))
     {
     return true;   
     }
     if((colDe==1)&&(rowDe==2))
     {
     return true;   
     }
     
     return false;
    }
    public void rChevron1Click(int i,int j)
    {
    if(rc1ValidMove(i,j)== false)
    {return;}
    tiles[r0][c2].setIcon(null);
    tiles[i][j].setIcon(rChevron);
    r0 =i;
    c2 =j;
    }
    public boolean rc1ValidMove(int i,int j)
    {
     int rowDe=Math.abs(i-r0);
     int colDe=Math.abs(j-c2);
     
     if((rowDe==1)&&(colDe==2))
     {
     return true;   
     }
     if((colDe==1)&&(rowDe==2))
     {
     return true;   
     }
     
     return false;
    } 
    public void rChevron2Click(int i,int j)
    {
    if(rc2ValidMove(i,j)== false)
    {return;}
    tiles[r0][c4].setIcon(null);
    tiles[i][j].setIcon(rChevron);
    r0 =i;
    c4 =j;
    }
    public boolean rc2ValidMove(int i,int j)
    {
     int rowDe=Math.abs(i-r0);
     int colDe=Math.abs(j-c4);
     
     if((rowDe==1)&&(colDe==2))
     {
     return true;   
     }
     if((colDe==1)&&(rowDe==2))
     {
     return true;   
     }
     
     return false;
    }   
    public static void main(String[] args)
    {
        new Board();
    }       
   }
   
