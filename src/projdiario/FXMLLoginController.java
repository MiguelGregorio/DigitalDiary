/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projdiario;

import com.itextpdf.text.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class FXMLLoginController implements Initializable {
    
    @FXML private Button Bentrar;
    @FXML TextField TLemail;
    @FXML PasswordField TLpass;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       if(TLemail.getText().equals("ihc") && TLpass.getText().equals("ihc")){
        
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Escolher.fxml"));
        Stage stage = (Stage) Bentrar.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    } 
       else{
           JOptionPane.showMessageDialog(null, "Login ou password erradas!");
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

    }    
    
}
