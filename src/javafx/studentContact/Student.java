package javafx.studentContact;

public class Student {
    private String id;
    private String name;
    private String email;
    private double score;

    public Student() {
    }

    public Student(String id, String name, String email, double score) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.score = score;
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
}
