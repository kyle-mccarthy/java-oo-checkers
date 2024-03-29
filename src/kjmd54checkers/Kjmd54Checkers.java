/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjmd54checkers;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

/**
 *
 * @author kylemccarthy
 */
public class Kjmd54Checkers extends Application {
    
    private final int numRows = 8;
    private final int numCols = 8;
    private final int boardWidth = 600;
    private final int boardHeight = 600;
    private final Color lightColor = Color.SKYBLUE;
    private final Color darkColor = Color.DARKBLUE;
    private CheckerBoard checkerBoard;
    
    @Override
    public void start(Stage primaryStage) {
        checkerBoard = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        //checkerBoard = new CheckerBoard(numRows, numCols, boardWidth, boardHeight);
        GridPane board = checkerBoard.build();
        Scene scene = new Scene(board, boardWidth, boardHeight);
        
        // listen for the resizing of the width
        scene.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldWidth, Number newWidth) -> {
            checkerBoard.setWidth(newWidth.intValue());
            checkerBoard.refreshBlockDimensions();
        });
        
        // listen for the resizing of the height
        scene.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldHeight, Number newHeight) -> {
            checkerBoard.setHeight(newHeight.intValue());
            checkerBoard.refreshBlockDimensions();
        });
        
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
