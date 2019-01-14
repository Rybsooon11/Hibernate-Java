package project;

import Connect.with.DB.AutoDealer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AddAutoDealerController implements Initializable {
    
    @FXML
    private AnchorPane AutoDPane;
    
    @FXML
    private TextField col_Localization;
    @FXML
    private TextField col_Name;
    @FXML
    private TextField col_PhoneNumber;
    @FXML
    private TextField col_Street;
    @FXML
    private TextField col_ZipCode;
    @FXML
    private Button Add;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AutoDPane.getStyleClass().add("Anchor-AddPane");
    }    

    @FXML
    public void addAutoDealer(ActionEvent event)throws IOException{
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
       String Street =  col_Street.getText();
       String Name = col_Name.getText();
       String Localization = col_Localization.getText();
       String PhoneNumber = col_PhoneNumber.getText();
       String ZipCode = col_ZipCode.getText();
      
       AutoDealer o = new AutoDealer();
       o.setName(Name);
       o.setLocalization(Localization);
       o.setStreet(Street);
       o.setZipCode(ZipCode);
       o.setPhoneNumber(PhoneNumber);
       entityManager.getTransaction().begin();
       entityManager.persist(o);
       entityManager.getTransaction().commit();
       Add.setText("Done");
    }
    
}
