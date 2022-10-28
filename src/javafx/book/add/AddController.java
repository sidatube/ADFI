package javafx.book.add;

import javafx.book.Book;
import javafx.book.Contains;
import javafx.book.Main;
import javafx.book.list.ListController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.studentScore.StudentScore;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UUID;

public class AddController implements Initializable {

    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtPrice;
    public ChoiceBox<String> choiceNxb;
    public ChoiceBox<String> choiceType;
    public TextField txtQty;
    public void goList(ActionEvent actionEvent) throws IOException {
        onGoList();
    }

    private void onGoList() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../list/list.fxml")));
        Main.mainStage.setTitle("List");
        Main.mainStage.setScene(new Scene(root, 820, 600));
    }

    public void submit(ActionEvent actionEvent) throws IOException {
        String id = UUID.randomUUID().toString();
        int qty = 0;
        BigDecimal price;
        try {
            qty = Integer.parseInt(txtQty.getText());
            if (qty < 0)
                throw new Exception("Số lượng phải lớn hơn 0");
            int priceInt = Integer.parseInt(txtPrice.getText());
            if (priceInt < 0) {
                throw new Exception("Giá phải lớn hơn 0");
            }
            price = new BigDecimal(priceInt);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
            return;
        }
        save(new Book(id,txtName.getText(), txtAuthor.getText(), choiceNxb.getValue(),choiceType.getValue(),price,qty));
        resetTextField();

    }

    private void save(Book book) throws IOException {
        ListController.books.add(book);
        onGoList();
    }

    public void reset(ActionEvent actionEvent) {
        resetTextField();
    }

    private void resetTextField() {
        txtName.setText("");
        txtAuthor.setText("");
        choiceNxb.setValue("");
        choiceType.setValue("");
        txtQty.setText("");
        txtPrice.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceNxb.setItems(FXCollections.observableList(Contains.nxbALl));
        choiceType.setItems(FXCollections.observableList(Contains.types));
    }
}
