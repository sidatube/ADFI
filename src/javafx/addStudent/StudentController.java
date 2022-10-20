package javafx.addStudent;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StudentController {
    public TextField txtName,txtEmail,txtAddress,txtPhone,txtAge;
    public Text textName,textEmail,textAddress,textPhone,textAge;

    public void submit(ActionEvent actionEvent) {
        textName.setText(txtName.getText());
        textEmail.setText(txtEmail.getText());
        textAddress.setText(txtAddress.getText());
        textPhone.setText(txtPhone.getText());
        textAge.setText(txtAge.getText());
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtAge.setText("");
    }
}
