package javafx.studentContact.listStudent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.studentContact.Main;
import javafx.studentContact.edit.EditController;
import javafx.studentContact.StudentScore;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public static final ObservableList<StudentScore> students = FXCollections.observableArrayList();
    public TableView<StudentScore> table;
    public TableColumn<StudentScore, String> cName;
    public TableColumn<StudentScore, String> cEmail;
    public TableColumn<StudentScore, Double> cScore;
    public TableColumn<StudentScore, Button> cAction;
    private boolean sortName = false;
    private boolean sortScore = false;

    public void sortByName(ActionEvent actionEvent) {
        sortName = !sortName;
        sortScore = false;
        students.sort((o1, o2) -> {
            return sortName ? o1.getName().compareTo(o2.getName()) : o2.getName().compareTo(o1.getName());
        });
        table.refresh();
    }

    public void sortByScore(ActionEvent actionEvent) {
        sortScore = !sortScore;
        sortName = false;
        students.sort((o1, o2) -> {
            return sortScore ? Double.compare(o1.getScore(), o2.getScore()) : Double.compare(o2.getScore(), o1.getScore());
        });
        table.refresh();

    }

    public void goEdit() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../edit/edit.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Main.mainStage.setTitle("Edit");
        Main.mainStage.setScene(new Scene(root, 820, 600));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (students.isEmpty()) {
            students.add(new StudentScore("Babruh", "3brul@gmail.com", 9.9));
            students.add(new StudentScore("Aqua", "konosu3@gmail.com", 0.9));
            students.add(new StudentScore("Darkness", "Lightning@gmail.com", 7.9));
            students.add(new StudentScore("Sasike", "uchiha@gmail.com", 10));
            students.add(new StudentScore("Ayanokouji ", "Smurf@gmail.com", 5));
            students.add(new StudentScore("Simp", "3brul@gmail.com", 9.9));
        }
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cScore.setCellValueFactory(new PropertyValueFactory<>("score"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        table.setItems(students);
        table.setOnMouseClicked(event -> {
            EditController.editing = table.getSelectionModel().getSelectedItems().get(0);
//            goEdit();
        });
    }

    public void goAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../addStudent/add.fxml")));
        Main.mainStage.setTitle("Add ");
        Main.mainStage.setScene(new Scene(root, 820, 600));
    }


}
