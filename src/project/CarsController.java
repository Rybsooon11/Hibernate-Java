package project;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
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
import javafx.stage.Stage;
import Connect.with.DB.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CarsController implements Initializable {
    
    @FXML
    private AnchorPane CarsPane;
    
    @FXML
    private TableColumn<Car, String> col_Colour;
    @FXML
    private TableColumn<Car, String> col_Engine;
    @FXML
    private TableColumn<Car, String> col_Mark;
    @FXML
    private TableColumn<Car, String> col_Model;
    @FXML
    private TableColumn<Car, String> col_Price;
    @FXML
    private TableColumn<Car, String> col_Year;
    @FXML
    private TableColumn<Car, Long> col_AutoDealerId;
    
    @FXML
    private TableView<Car> tbViewCar;
    @FXML
    private ObservableList<Car> dataCar;
    
    
    @FXML
    public void loadTableCar() throws IOException {
        
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        
        TypedQuery<Car> query;
        query = entityManager.createQuery(
                "select e from Cars e", Car.class);
        dataCar = FXCollections.<Car> observableArrayList(query
                .getResultList());
        tbViewCar.setItems(dataCar);
        entityManager.clear();
        EntityManagerFactory.close();       
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        col_Colour.setCellValueFactory(new PropertyValueFactory<>("Colour"));
        col_Engine.setCellValueFactory(new PropertyValueFactory<>("Engine"));
        col_Mark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
        col_Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        col_Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        col_Year.setCellValueFactory(new PropertyValueFactory<>("Year"));
        col_AutoDealerId.setCellValueFactory(new PropertyValueFactory<>("AutoDealerId"));
        CarsPane.getStyleClass().add("Anchor-CustomersPane");
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCar.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        root1.getStylesheets().add("/project/style.css");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();       
    }
    
    @FXML
    public void deleteCar(ActionEvent event) throws IOException  {
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
        int i =0;
        if(i==0){
        long id = tbViewCar.getSelectionModel().getSelectedItem().getId();
        Query query = entityManager.createQuery("delete from  Cars b where b.id = :id");
        query.setParameter("id", id);
        entityManager.getTransaction().begin();
        query.executeUpdate();
       entityManager.getTransaction().commit();
       i++;
        }
       if(i==1)tbViewCar.getItems().removeAll(tbViewCar.getSelectionModel().getSelectedItem());
    }
}
