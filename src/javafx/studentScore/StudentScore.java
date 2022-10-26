package javafx.studentScore;

import java.util.Objects;

public class StudentScore {
    private String name;
    private String email;
    private double score;

    public StudentScore(String name, String email, double score) {
        this.name = name;
        this.email = email;
        this.score = score;
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
