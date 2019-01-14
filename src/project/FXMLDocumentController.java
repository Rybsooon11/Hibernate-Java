package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
   @FXML
   public void gotoCustomers(ActionEvent event) throws IOException
   {
       Parent tableCustomers = FXMLLoader.load(getClass().getResource("Customers.fxml"));
       Scene tableCustomersScene = new Scene(tableCustomers);
       tableCustomersScene.getStylesheets().add("/project/style.css");
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setResizable(false);
       app_stage.setScene(tableCustomersScene);
       app_stage.show();
   }
   
    @FXML
   public void gotoCars(ActionEvent event) throws IOException
   {
       Parent tableCustomers = FXMLLoader.load(getClass().getResource("Cars.fxml"));
       Scene tableCustomersScene = new Scene(tableCustomers);
       tableCustomersScene.getStylesheets().add("/project/style.css");
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(tableCustomersScene);
       app_stage.setResizable(false);
       app_stage.show();
   }
   
   @FXML
   public void gotoAutoDealers(ActionEvent event) throws IOException
   {
       Parent tableCustomers = FXMLLoader.load(getClass().getResource("AutoDealers.fxml"));
       Scene tableCustomersScene = new Scene(tableCustomers);
       tableCustomersScene.getStylesheets().add("/project/style.css");
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(tableCustomersScene);
       app_stage.setResizable(false);
       app_stage.show();
   }
    
     @FXML
    private AnchorPane TopBar;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    TopBar.getStyleClass().add("AnchorPane-mainPage");
    }    
    
}
