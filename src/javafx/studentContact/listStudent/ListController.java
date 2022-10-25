package javafx.studentContact.listStudent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.studentContact.Main;
import javafx.studentScore.StudentScore;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public ListView<StudentScore> lv;
    public static final ObservableList<StudentScore> students = FXCollections.observableArrayList();
    private boolean sortName = false;
    private boolean sortScore = false;

    public void sortByName(ActionEvent actionEvent) {
        sortName = !sortName;
        sortScore=false;
        students.sort((o1, o2) -> {
            return sortName ? o1.getName().compareTo(o2.getName()) : o2.getName().compareTo(o1.getName());
        });
        lv.refresh();
    }

    public void sortByScore(ActionEvent actionEvent) {
        sortScore=!sortScore;
        sortName=false;
        students.sort((o1, o2) -> {
            return sortScore?Double.compare(o1.getScore(), o2.getScore()):Double.compare(o2.getScore(), o1.getScore());
        });
        lv.refresh();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
      if(students.isEmpty()){
          students.add(new StudentScore("Babruh","3brul@gmail.com",9.9));
          students.add(new StudentScore("Aqua","konosu3@gmail.com",0.9));
          students.add(new StudentScore("Darkness","Lightning@gmail.com",7.9));
          students.add(new StudentScore("Sasike","uchiha@gmail.com",10));
          students.add(new StudentScore("Ayanokouji ","Smurf@gmail.com",5));
          students.add(new StudentScore("Simp","3brul@gmail.com",9.9));
      }
        lv.setItems(students);
    }

    public void goAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../addStudent/add.fxml")));
        Main.mainStage.setTitle("Add ");
        Main.mainStage.setScene(new Scene(root, 820,600));
    }
    public void goEdit(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../addStudent/add.fxml")));
        Main.mainStage.setTitle("Add ");
        Main.mainStage.setScene(new Scene(root, 820,600));
    }
}
