package javafx.book;

import javafx.book.edit.EditController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private String id;
    private String name;
    private String author;
    private String nxb;
    private String type;
    private BigDecimal price;
    private int qty;
    private Button edit;

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Book() {
    }

    public Book(String id, String name, String author, String nxb, String type, BigDecimal price, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.nxb = nxb;
        this.type = type;
        this.price = price;
        this.qty = qty;
        this.edit = new Button("Edit");
        edit.setOnAction(event -> {
            EditController.editing = this;
            Parent root = null;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit/edit.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            Main.mainStage.setTitle("Edit");
            Main.mainStage.setScene(new Scene(root, 820,600));
        });
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return
                "name:'" + name + '\'' +
                ", author:'" + author + '\'' +
                ", nxb:'" + nxb + '\'' +
                ", type:'" + type + '\'' +
                ", price:" + price +
                ", qty:" + qty ;
    }
}
