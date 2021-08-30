package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Building the GUI elements up from the bottom to the top

        //FXML loader loads the lowest layer, which the fxml - fyi, path to the FXML can be fussy
        Parent root = FXMLLoader.load(getClass().getResource("/gui/JavaFX_Calculator.fxml"));

        //Create a scene, that will contain the root (FXML)
        Scene scene = new Scene(root);

        //Create and set attributes on the stage (which is the top level) that will hold the scene
        primaryStage.setTitle("Java - Calculator App - TiborM-Hungary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

