import java.util.Stack;

public class Patient extends Person {
    protected String medicalCondition;
    protected Stack<String> history;

    public Patient(String id, String fullName, int age, String medicalCondition) {
        super(id, fullName, age);
        this.medicalCondition = medicalCondition;
        this.history = new Stack<>();
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public Stack<String> getHistory() {
        return history;
    }

    public void addHistory(String record) {
        if (record == null) return;
        String trimmed = record.trim();
        if (!trimmed.isEmpty()) {
            history.push(trimmed);
        }
    }

    public boolean isEmergency() {
        return false;
    }

    public int getPriorityLevelOrDefault() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void showInfo() {
        System.out.printf("ID: %s | Name: %s | Age: %d | Condition: %s%n", id, fullName, age, medicalCondition);
    }

    @Override
    public String toString() {
        return String.format("Patient{id='%s', fullName='%s', age=%d, condition='%s'}", id, fullName, age, medicalCondition);
    }
}
