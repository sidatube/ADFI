package javafx;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ContactController {
    public TextField txtName,txtEmail;
    public Text textName,textEmail;
    public void submit(ActionEvent actionEvent) {
        textName.setText(txtName.getText());
        textEmail.setText(txtEmail.getText());
        txtName.setText("");
        txtEmail.setText("");
    }
}
