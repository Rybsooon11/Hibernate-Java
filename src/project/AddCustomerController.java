
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import Connect.with.DB.Customer;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddCustomerController implements Initializable {

    @FXML
    private AnchorPane AddCustomerPane;
     
    @FXML
    private TextField col_Street;
    @FXML
    private TextField col_LastName;
    @FXML
    private TextField col_Localization;
    @FXML
    private TextField col_PhoneNumber;
    @FXML
    private TextField col_FirstName;
    @FXML
    private TextField col_ZipCode;

    @FXML
    private Button Add;

    @FXML
    public void addCustomer(ActionEvent event)throws IOException{
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
       String Street =  col_Street.getText();
       String LastName = col_LastName.getText();
       String FirstName = col_FirstName.getText();
       String Localization = col_Localization.getText();
       String PhoneNumber = col_PhoneNumber.getText();
       String ZipCode = col_ZipCode.getText();
      
       Customer o = new Customer();
       o.setFirstName(FirstName);
       o.setLastName(LastName);
       o.setLocalization(Localization);
       o.setStreet(Street);
       o.setZipCode(ZipCode);
       o.setPhoneNumber(PhoneNumber);
       entityManager.getTransaction().begin();
       entityManager.persist(o);
       entityManager.getTransaction().commit();
       Add.setText("Done");
   }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddCustomerPane.getStyleClass().add("Anchor-AddPane");
    }  
    
    
}