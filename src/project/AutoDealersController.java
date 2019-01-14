package project;

import Connect.with.DB.AutoDealer;
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

public class AutoDealersController implements Initializable {

    @FXML
    private AnchorPane AutoDPane;
    
    @FXML
    private TableColumn<AutoDealer, String> col_Localization;
    @FXML
    private TableColumn<AutoDealer, String> col_Name;
    @FXML
    private TableColumn<AutoDealer, Integer> col_PhoneNumber;
    @FXML
    private TableColumn<AutoDealer, String> col_Street;
    @FXML
    private TableColumn<AutoDealer, String> col_ZipCode;
    
    @FXML
    private TableView<AutoDealer> tbViewAutoD;
    @FXML
    private ObservableList<AutoDealer> dataAutoD;
    
   @FXML
    public void loadTableAutoD() throws IOException {
        
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        
        TypedQuery<AutoDealer> query;
        query = entityManager.createQuery(
                "select e from AutoDealers e", AutoDealer.class);
        dataAutoD = FXCollections.<AutoDealer> observableArrayList(query
                .getResultList());
        tbViewAutoD.setItems(dataAutoD);
        entityManager.clear();
        EntityManagerFactory.close(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_Localization.setCellValueFactory(new PropertyValueFactory<>("Localization"));
        col_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col_PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        col_Street.setCellValueFactory(new PropertyValueFactory<>("Street"));
        col_ZipCode.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
        AutoDPane.getStyleClass().add("Anchor-CustomersPane");
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAutoDealer.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        root1.getStylesheets().add("/project/style.css");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();       
    }
    
    @FXML
    public void deleteAutoDealer(ActionEvent event) throws IOException  {
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        int i =0;
        if(i==0){
        long id = tbViewAutoD.getSelectionModel().getSelectedItem().getId();
        Query query = entityManager.createQuery("delete from  AutoDealers b where b.id = :id");
        query.setParameter("id", id);
        entityManager.getTransaction().begin();
        query.executeUpdate();
       entityManager.getTransaction().commit();
       i++;
        }
       if(i==1)tbViewAutoD.getItems().removeAll(tbViewAutoD.getSelectionModel().getSelectedItem());
    }
}
