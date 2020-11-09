/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ivana
 */
public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/ui.fxml"));

        Scene scene = new Scene(root);
        scene.setRoot(root);
        scene.getStylesheets().add("css/styles.css");

        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.setTitle("SLUZBA PRODAJE INTERNET PAKETA");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
