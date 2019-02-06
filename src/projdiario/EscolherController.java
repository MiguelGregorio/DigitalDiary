/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projdiario;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.swing.JFrame;
/**
 * FXML Controller class
 *
 * @author migue
 */
public class EscolherController implements Initializable {

   @FXML DatePicker DataEscrever;
   @FXML DatePicker DataQuando;
   @FXML TextArea TextEscrever;
   @FXML ImageView ImgGuardar;
   @FXML ImageView apagar;
   @FXML ImageView imprimir;
   @FXML ImageView procurar;
   @FXML DatePicker DataAte;
   @FXML HBox Hbox;
   @FXML CheckBox check;
   @FXML Label LabelAte;
   @FXML Button BConfirmar;
   @FXML TextArea TextConsultar;
   @FXML Button sair;
   
   
   @FXML
   private void ConfirmarButton() throws ClassNotFoundException, SQLException{
       
        
       
       if(DataEscrever.getValue()==null){
           JOptionPane.showMessageDialog(null, "Tem de inserir uma data");
           return;
       }
       
       try{
           
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
       Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DiarioBD;user=admin;password=sqlserver");
       String query = "select * from tblDiario where Data = '"+java.sql.Date.valueOf(DataEscrever.getValue())+"'";
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Deve introduzir uma data onde ainda não escreveu!");
            }else{JOptionPane.showMessageDialog(null, "Pode escrever nesta data!");}
       
       
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro!");
        }  
           
       
   }
   
   
   
   @FXML 
   private void imagePicker(){
     
       Date data;
       
       
       
       
       
       if(DataEscrever.getValue()==null){
           JOptionPane.showMessageDialog(null, "Tem de inserir uma data");
       
           
       
           
       }else{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DiarioBD;user=sa;password=sqlserver");
            String query = "INSERT INTO tblDiario (Data, Texto)" +  "values (?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            
            data = java.sql.Date.valueOf(DataEscrever.getValue());
            
            pst.setDate(1, data);
            pst.setString(2, TextEscrever.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            TextEscrever.clear();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro!");
        } 
       }
   }
   
   @FXML
   private void checkB(){
       if(check.isSelected()){
          Hbox.setVisible(true);
      }else
          Hbox.setVisible(false);
          
   }
   
   
   
  @FXML
   private void BConsultar(){
       
        
        Date data;
        String texto;
        Diario diario = null;
        String resultado = "";
       
       if(!check.isSelected()){
           if(DataQuando.getValue()==null)
               JOptionPane.showMessageDialog(null, "Deve introduzir uma data");
           
           else{
               
               try{
           
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DiarioBD;user=admin;password=sqlserver");
                String query = "select * from tblDiario where Data = '"+java.sql.Date.valueOf(DataQuando.getValue())+"'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    data = rs.getDate(1);
                    texto = rs.getString(2);
                   
                       System.out.println(data);
                       System.out.println(texto);
                       
                       TextConsultar.setText(data.toString() + " : \n" + texto);
                       
                }
                
       
       
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro!");
        }  
               
               
           }
       }
       
       if(check.isSelected()){
           Date dataQuando, dataAte;
           
           if(DataQuando.getValue()==null || DataAte.getValue()==null){
               JOptionPane.showMessageDialog(null, "As datas não são válidas!");
           }
           
                dataQuando = java.sql.Date.valueOf(DataQuando.getValue());
                dataAte = java.sql.Date.valueOf(DataAte.getValue());
           
                if(dataAte.before(dataQuando)   ){
                JOptionPane.showMessageDialog(null, "As datas não são válidas!");
                }
                else{
                    
                    try{
           
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DiarioBD;user=admin;password=sqlserver");
                        String query = "select * from tblDiario where Data >= '"+java.sql.Date.valueOf(DataQuando.getValue())+"' and data <= ' "+ java.sql.Date.valueOf(DataAte.getValue()) + "' " ;
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        while(rs.next()){
                            data = rs.getDate(1);
                            texto = rs.getString(2);
                   
                            //System.out.println(data);
                            //System.out.println(texto);
                            
                         
                            
                            resultado = ( resultado + data.toString() + " : \n" + texto + "\n\n\n");
                       
                            System.out.println(resultado);
                        
                        
                      
                        }
                
                        TextConsultar.setText(resultado);
       
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Erro!");
                      } 
                }
            
           
          
       }
       
   }
   
   
  @FXML
   private void ApagarConsultar(){
       TextConsultar.clear();
       
   }
   
@FXML 
private void GuardarPDF() throws FileNotFoundException, DocumentException{
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("Diario.pdf"));
 
    String conteudo= TextConsultar.getText();
    
    document.open();
    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
    Chunk chunk = new Chunk(conteudo, font);
    
    document.add(new Paragraph(chunk));
    document.close();
    JOptionPane.showMessageDialog(null, "Exportado com sucesso!");
}


@FXML 
private void imprimir(){
    Text extractedText = new Text(TextConsultar.getText());
    extractedText.setWrappingWidth(450);

    // use pane to place the text
    StackPane container = new StackPane(extractedText);
    container.setAlignment(Pos.TOP_LEFT);

    PrinterJob printerJob = PrinterJob.createPrinterJob();

    if (printerJob != null ) {

        if (printerJob.printPage(container)) {
            printerJob.endJob();
        } else {
            System.out.println("Failed to print");
        }
    } else {
        System.out.println("Canceled");
    }

}

@FXML 
private void procurar(){
    JFrame f;
     Date data;
     String texto;
     String resultado="";
     TextConsultar.clear();
    
     f=new JFrame();   
    String name=JOptionPane.showInputDialog(f,"Insira palavra a procurar");
    
    if(name.isEmpty()){
        JOptionPane.showMessageDialog(null, "Deve inserir pelo menos uma palavra!");
    }
    else{
        try{
           
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DiarioBD;user=admin;password=sqlserver");
                        String query = "select * from tblDiario where Texto like '%"+name+"%'";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        while(rs.next()){
                            data = rs.getDate(1);
                            texto = rs.getString(2);
                   
                            //System.out.println(data);
                            //System.out.println(texto);
                            
                         
                            
                            resultado = ( resultado + data.toString() + " : \n" + texto + "\n\n\n");
                       
                            System.out.println(resultado);
                        
                        
                      
                        }
                
                        TextConsultar.setText(resultado);
       
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Erro!");
                      } 
    }
}


@FXML 
public void sair(){
    try{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Stage stage = (Stage) sair.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
}
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Hbox.setVisible(false);
          TextConsultar.setEditable(false);
          TextEscrever.setWrapText(true);
          TextConsultar.setWrapText(true);
          
           
          
        
    }    
    
}
