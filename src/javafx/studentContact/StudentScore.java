package javafx.studentContact;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.studentContact.edit.EditController;

import java.io.IOException;
import java.util.Objects;

public class StudentScore {
    private String name;
    private String email;
    private double score;
 private Button btn;

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public StudentScore(String name, String email, double score) {
        this.name = name;
        this.email = email;
        this.score = score;
        this.btn = new Button("Edit");
        this.btn.setOnAction(event -> {
            EditController.editing=this;
            Parent root = null;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit/edit.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            Main.mainStage.setTitle("Edit");
            Main.mainStage.setScene(new Scene(root, 820, 600));
        });
    }

    public StudentScore() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return
                name +
                        ", " + email +
                        ", score: " + score
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentScore that = (StudentScore) o;
        return Double.compare(that.score, score) == 0 && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, score);
    }
}
