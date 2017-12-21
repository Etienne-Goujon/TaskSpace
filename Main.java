package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {
	
	
	public void start(Stage primaryStage) throws Exception{
		try {
			Parent scene = FXMLLoader.load(getClass().getResource("Vue.fxml"));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(new Scene(scene));
			primaryStage.show();
			primaryStage.setTitle("TaskSpace @");
			primaryStage.setResizable(false);
			System.out.println("test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	


	public static void main(String[] args) {
		launch(args);
	}

}
