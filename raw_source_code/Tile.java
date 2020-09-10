
/**
 * Abstract class Tile
 * Abstract class for each tiles in the board
 * Contains method to get the pieces that located in the current tiles
 *
 * @author WaliyIsmail
 * @version (version number or date here)
 */
public abstract class Tile
{
    //postion of tile
    int tileX;
    int tileY;

    /**
     * Tile Constructor
     *
     * @param tileX A parameter
     * @param tileY A parameter
     */
    Tile(int tileX, int tileY)
    {
        this.tileX = tileX;
        this.tileY = tileY;
    }
    
    /**
     * Method isOccupied
     *
     * @return Return true if the current tile is occupied otherwise false.
     */
    public abstract boolean isOccupied();
    
    /**
     * Method getPiece
     * @return Return the piece on the current tile
     */
    public abstract Piece getPiece();
    
}
