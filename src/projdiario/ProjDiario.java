/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projdiario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author migue
 */
public class ProjDiario extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Image image=new Image("C:\\Users\\migue\\Downloads\\diary.png");
        
        
       
       Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
       
        //stage.getIcons().add(image);
        //stage.getTitle("Diario");

        
        stage.setScene(scene);
        stage.show();
    }
    
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
