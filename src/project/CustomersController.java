package project;

import Connect.with.DB.Customer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CustomersController implements Initializable {

    @FXML
    private AnchorPane CustomersPane;
    
    
     
    @FXML
    private TableColumn<Customer, String> col_FirstName;
    @FXML
    private TableColumn<Customer, String> col_LastName;
    @FXML
    private TableColumn<Customer, String> col_Localization;
    @FXML
    private TableColumn<Customer, String> col_PhoneNumber;
    @FXML
    private TableColumn<Customer, String> col_Street;
    @FXML
    private TableColumn<Customer, String> col_ZipCode;
    
    @FXML
    private TableView<Customer> tbViewCustomer;
    private ObservableList<Customer> dataCustomer;
    
    @FXML
    public void loadTableCustomer() throws IOException {
        
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        
        TypedQuery<Customer> query;
        query = entityManager.createQuery(
                "select e from Customers e", Customer.class);
        dataCustomer = FXCollections.<Customer> observableArrayList(query
                .getResultList());
        tbViewCustomer.setItems(dataCustomer);
        entityManager.clear();
        EntityManagerFactory.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_FirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        col_LastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        col_Localization.setCellValueFactory(new PropertyValueFactory<>("Localization"));
        col_Street.setCellValueFactory(new PropertyValueFactory<>("Street"));
        col_PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        col_ZipCode.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
        CustomersPane.getStyleClass().add("Anchor-CustomersPane");
    }    
    
    @FXML
    public void goBack(ActionEvent event) throws IOException {
       Parent tableCustomers = FXMLLoader.load(getClass().getResource("Main.fxml"));
       Scene tableCustomersScene = new Scene(tableCustomers);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(tableCustomersScene);
       app_stage.show();
    }
    
    @FXML
    public void NewAddWindow(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCustomer.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        root1.getStylesheets().add("/project/style.css");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();       
    }
   

    @FXML
    public void deleteCustomer(ActionEvent event) throws IOException  {
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        int i =0;
        if(i==0){
        long id = tbViewCustomer.getSelectionModel().getSelectedItem().getId();
        Query query = entityManager.createQuery("delete from  Customers b where b.id = :id");
        query.setParameter("id", id);
        entityManager.getTransaction().begin();
        query.executeUpdate();
       entityManager.getTransaction().commit();
       i++;
        }
       if(i==1)tbViewCustomer.getItems().removeAll(tbViewCustomer.getSelectionModel().getSelectedItem());
    }
  
}
