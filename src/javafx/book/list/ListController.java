package javafx.book.list;

import javafx.book.Book;
import javafx.book.Main;
import javafx.book.edit.EditController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UUID;

public class ListController implements Initializable {
    public ListView<Book> lv;
    public static final ObservableList<Book> books = FXCollections.observableArrayList();
    private boolean sortName = false;
    private boolean sortPrice = false;
    private boolean sortQty = false;

    public void sortByName(ActionEvent actionEvent) {
        sortName = !sortName;
        sortPrice =false;
        sortQty =false;
        books.sort((o1, o2) -> {
            return sortName ? o1.getName().compareTo(o2.getName()) : o2.getName().compareTo(o1.getName());
        });
        lv.refresh();
    }

    public void sortByQty(ActionEvent actionEvent) {
        sortQty =!sortQty;
        sortName=false;
        sortPrice=false;
        books.sort((o1, o2) -> {
            return sortName ?Integer.compare(o1.getQty(),o2.getQty()):Integer.compare(o2.getQty(), o1.getQty());
        });
        lv.refresh();

    }public void sortByPrice(ActionEvent actionEvent) {
        sortPrice =!sortPrice;
        sortName=false;
        sortQty=false;
        books.sort((o1, o2) -> {
            return sortPrice ?o1.getPrice().compareTo(o2.getPrice()):o2.getPrice().compareTo(o1.getPrice());
        });
        lv.refresh();

    }
    public void goEdit(){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../edit/edit.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Main.mainStage.setTitle("Edit");
        Main.mainStage.setScene(new Scene(root, 820,600));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
      if(books.isEmpty()){
          books.add(new Book(UUID.randomUUID().toString(),"Book 1","Author 1","nxb kim dong","thiếu nhi",new BigDecimal(40000),14));
          books.add(new Book(UUID.randomUUID().toString(),"Book 2","Author 2","nxb kim dong","thiếu nhi",new BigDecimal(15000),23));
          books.add(new Book(UUID.randomUUID().toString(),"Book 3","Author 3","nxb kim dong","thiếu nhi",new BigDecimal(43000),4));
          books.add(new Book(UUID.randomUUID().toString(),"Book 4","Author 4","nxb kim dong","thiếu nhi",new BigDecimal(70000),12));
      }
        lv.setItems(books);
      lv.setOnMouseClicked(event -> {
          EditController.editing=lv.getSelectionModel().getSelectedItems().get(0);
          goEdit();
      });
    }

    public void goAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../add/add.fxml")));
        Main.mainStage.setTitle("Add ");
        Main.mainStage.setScene(new Scene(root, 820,600));
    }


}
