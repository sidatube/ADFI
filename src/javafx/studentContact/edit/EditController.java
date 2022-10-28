package javafx.studentContact.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.studentContact.Main;
import javafx.studentContact.listStudent.ListController;
import javafx.studentScore.StudentScore;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UUID;

public class EditController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtScore;
    public static StudentScore editing;
    private int index= -1;
    public void goList(ActionEvent actionEvent) throws IOException {
        onGoList();
    }

    private void onGoList() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../listStudent/list.fxml")));
        Main.mainStage.setTitle("List");
        Main.mainStage.setScene(new Scene(root, 820,600));
    }
    public void submit(ActionEvent actionEvent) throws IOException {
        String id  = UUID.randomUUID().toString();
        double studentScore =0;
        try {
            studentScore =Double.parseDouble(txtScore.getText());
            if (studentScore<0||studentScore>10)
                throw new  Exception("Điểm nằm trong khoảng từ 0 đến 10");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
            return;
        }
        save(new StudentScore(txtName.getText(),txtEmail.getText(),studentScore));
        resetTextField();

    }

    private void save(StudentScore student) throws IOException {
//        ListController.students.add(student);
        if (index<0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("No item!");
            alert.show();
        }
        ListController.students.set(index,student);
        onGoList();

    }

    private void resetTextField(){
        txtName.setText("");
        txtEmail.setText("");
        txtScore.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editing!= null){
            txtName.setText(editing.getName());
            txtEmail.setText(editing.getEmail());
            txtScore.setText(editing.getScore()+"");
          index=  ListController.students.indexOf(editing);
            System.out.println(index);
        }
    }
}
