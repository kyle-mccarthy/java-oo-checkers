package kjmd54checkers;

import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kylemccarthy
 */
public class CheckerBoard {
    private int numRows;
    private int numCols;
    private int boardWidth;
    private int boardHeight;
    private Color lightColor;
    private Color darkColor;
    private int squareWidth;
    private int squareHeight;
    private GridPane grid;
    private Rectangle[][] blocks;
    
    CheckerBoard(int numRows, int numCols, int boardWidth, int boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.blocks = new Rectangle[numRows][numCols];
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
    }
    
    CheckerBoard(int numRows, int numCols, int boardWidth, int boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    /**
     * Get the GridPane object representing the board.
     * @return 
     */
    public GridPane getBoard() {
        return this.grid;
    }
    
    /**
     * Get the number of rows on the GridPane
     * @return 
     */
    public int getNumRows() {
        return this.numRows;
    }
    
    /**
     * Get the number of columns on the GridPane
     * @return 
     */
    public int getNumCols() {
        return this.numCols;
    }
    
    /**
     * Get the width of the scene
     * @return 
     */
    public int getWidth() {
        return this.boardWidth;
    }
    
    /**
     * Get the height of the scene
     * @return 
     */
    public int getHeight() {
        return this.boardHeight;
    }
    
    /**
     * Get the value of the dark color square used on the board
     * @return 
     */
    public Color getDarkColor() {
        return this.darkColor;
    }
    
    /**
     * Get the value of the light color square used on the board
     * @return 
     */
    public Color getLightColor() {
        return this.lightColor;
    }
    
    /**
     * Get the calculated value of the width of a square on the board
     * @return 
     */
    public int getSquareWidth() {
        return this.squareWidth;
    }
    
    /**
     * Get the calculated value of the height of a square on the board
     * @return 
     */
    public int getSquareHeight() {
        return this.squareHeight;
    }
    
    /**
     * Set the width of the board
     * @param width 
     */
    public void setWidth(int width) {
        this.boardWidth = width;
    }
    
    /**
     * Set the height of the board
     * @param height 
     */
    public void setHeight(int height) {
        this.boardHeight = height;
    }
    
    /**
     * Construct a checker board to be placed on the scene
     * @return 
     */
    public GridPane build() {
        if (this.grid == null) {
            this.grid = new GridPane();
            this.calculateBlockDimensions();
            this.generateBlocks();
            this.addBlocksToGrid();
        }
        return this.grid;
    }
    
    /**
     * Calculate the width and height of a square on the board based on the
     * desired number of rows and columns in relation to the height and width
     * of the board.
     */
    private void calculateBlockDimensions() {
        this.squareHeight = this.boardHeight/this.numRows;
        this.squareWidth = this.boardWidth/this.numCols;
    }
    
    /**
     * Generate the spaces for the board.
     */
    private void generateBlocks() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                this.blocks[i][j] = new Rectangle(this.squareWidth, this.squareHeight, this.pickBlockColor(i, j));
            }
        }
    }
    
    /**
     * The algorithm that determines whether to use the dark or light color
     * blocks.  It adds the row and col index, if it is odd it is a dark color,
     * even result in light.  The indices start at 0.
     * @param row
     * @param col
     * @return 
     */
    private Color pickBlockColor(int row, int col) {
        if ((row + col) % 2 == 1) {
            return this.darkColor;
        }
        return this.lightColor;
    }
    
    /**
     * Append the blocks to the grid.
     */
    private void addBlocksToGrid() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                this.grid.add(this.blocks[i][j], j, i);
            }
        }
    }
    
    public void refreshBlockDimensions() {
        this.calculateBlockDimensions();
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                this.blocks[i][j].setHeight(this.squareHeight);
                this.blocks[i][j].setWidth(this.squareWidth);
            }
        }
    }
    
}
