package javafx.addStudent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController {
    public TextField txtName,txtEmail,txtAddress,txtPhone,txtAge;
    public ListView<Student> lv;
    private ObservableList<Student> students = FXCollections.observableArrayList();
    public void submit(ActionEvent actionEvent) {
        int age =0;
        try {
            age =Integer.parseInt(txtAge.getText());
        }catch (Exception ignored){

        }
        save(new Student(txtName.getText(),txtEmail.getText(),txtAddress.getText(),txtPhone.getText(),age));
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtAge.setText("");
        lv.setItems(students);
    }

    private void save(Student student) {
        for (Student st: students
             ) {
            if (st.getName().equals(student.getName())){
                st.setAddress(student.getAddress());
                st.setPhone(student.getPhone());
                st.setEmail(student.getEmail());
                st.setAge(student.getAge());
                lv.refresh();
                return;
            }
        }
        students.add(student);

    }
}
