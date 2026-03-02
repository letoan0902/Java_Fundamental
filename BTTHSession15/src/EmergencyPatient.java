public class EmergencyPatient extends Patient {
    private int priorityLevel; // lower number => higher priority

    public EmergencyPatient(String id, String fullName, int age, String medicalCondition, int priorityLevel) {
        super(id, fullName, age, medicalCondition);
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public boolean isEmergency() {
        return true;
    }

    @Override
    public int getPriorityLevelOrDefault() {
        return priorityLevel;
    }

    @Override
    public void showInfo() {
        System.out.printf("ID: %s | Name: %s | Age: %d | Condition: %s | EMERGENCY priority: %d%n",
                id, fullName, age, medicalCondition, priorityLevel);
    }

    @Override
    public String toString() {
        return String.format("EmergencyPatient{id='%s', fullName='%s', age=%d, condition='%s', priority=%d}",
                id, fullName, age, medicalCondition, priorityLevel);
    }
}
