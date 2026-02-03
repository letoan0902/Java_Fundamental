public class Student {
    private String id;
    private String name;
    private double score;

    public Student() {
    }

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score >= 8.0) {
            return "Gioi";
        }
        if (score >= 6.5) {
            return "Kha";
        }
        if (score >= 5.0) {
            return "Trung Binh";
        }
        return "Yeu";
    }

    @Override
    public String toString() {
        return "Ma: " + id + ", Ten: " + name + ", Diem: " + score + ", Hoc luc: " + getRank();
    }
}
