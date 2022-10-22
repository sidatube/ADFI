package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactController {
    public TextField txtName,txtEmail;
    public ListView<Contact> lv;
    private ObservableList<Contact> ls = FXCollections.observableArrayList();
    public void submit(ActionEvent actionEvent) {
        ls.add(new Contact(txtName.getText(),txtEmail.getText()));
        txtName.setText("");
        txtEmail.setText("");
        print();
    }
    private void print(){
        lv.setItems(ls);
    }
}
