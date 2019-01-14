package project;

import Connect.with.DB.Car;
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


public class AddCarController implements Initializable {
    
    @FXML
    private AnchorPane AddCarPane;

    @FXML
    private TextField col_Colour;
    @FXML
    private TextField col_Engine;
    @FXML
    private TextField col_Mark;
    @FXML
    private TextField col_Model;
    @FXML
    private TextField col_Price;
    @FXML
    private Button Add;
    
    @FXML
    private TextField col_Year;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddCarPane.getStyleClass().add("Anchor-AddPane");
    }    

    @FXML
    public void addCar(ActionEvent event)throws IOException{
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
        EntityManager entityManager = EntityManagerFactory.createEntityManager();
       String Colour =  col_Colour.getText();
       String Engine = col_Engine.getText();
       String Mark = col_Mark.getText();
       String Model = col_Model.getText();
       String Price = col_Price.getText();
       String Year = col_Year.getText();
       
       Car car = new Car();
       car.setColour(Colour);
       car.setEngine(Engine);
       car.setMark(Mark);
       car.setModel(Model);
       car.setPrice(Price);
       car.setYear(Year);
       entityManager.getTransaction().begin();
       entityManager.persist(car);
       entityManager.getTransaction().commit();
       Add.setText("Done");
   }

    
}
