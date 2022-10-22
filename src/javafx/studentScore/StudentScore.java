package javafx.studentScore;

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
}
