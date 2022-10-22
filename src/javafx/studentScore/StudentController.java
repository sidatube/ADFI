package javafx.studentScore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collections;

public class StudentController {
    public TextField txtName,txtEmail, txtScore;
    public ListView<StudentScore> lv;
    private ObservableList<StudentScore> students = FXCollections.observableArrayList();
    private boolean sortName = false;
    private boolean sortScore = false;

    public void submit(ActionEvent actionEvent) {
        double studentScore =0;
        try {
            studentScore =Double.parseDouble(txtScore.getText());
        }catch (Exception ignored){

        }
        save(new StudentScore(txtName.getText(),txtEmail.getText(),studentScore));
        txtName.setText("");
        txtEmail.setText("");
        txtScore.setText("");
        lv.setItems(students);
    }

    private void save(StudentScore student) {
        for (StudentScore st: students
             ) {
            if (st.getName().equals(student.getName())){
                st.setEmail(student.getEmail());
                st.setScore(student.getScore());
                lv.refresh();
                return;
            }
        }
        students.add(student);

    }

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

    public void addData(ActionEvent actionEvent) {
        students.clear();
        students.add(new StudentScore("Babruh","3brul@gmail.com",9.9));
        students.add(new StudentScore("Aqua","konosu3@gmail.com",0.9));
        students.add(new StudentScore("Darkness","Lightning@gmail.com",7.9));
        students.add(new StudentScore("Sasike","uchiha@gmail.com",10));
        students.add(new StudentScore("Ayanokouji ","Smurf@gmail.com",5));
        students.add(new StudentScore("Simp","3brul@gmail.com",9.9));
        lv.setItems(students);
    }
}
