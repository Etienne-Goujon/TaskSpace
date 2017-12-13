/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.connect;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mehdi
 */
public class Task extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
       //StackPane root = new StackPane();
        Parent scene = FXMLLoader.load(getClass().getResource("Vue.fxml"));
        
       
        
        //Scene scene = new Scene(root, 1200, 700);
        
        primaryStage.setTitle("@TaskSpace!");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
