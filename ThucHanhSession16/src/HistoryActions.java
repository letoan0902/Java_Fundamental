import java.time.LocalDateTime;

class HistoryActions {
    private String description;
    private LocalDateTime timeAction;

    public HistoryActions() {
    }

    public HistoryActions(String description, LocalDateTime timeAction) {
        this.description = description;
        this.timeAction = timeAction;
    }

    public LocalDateTime getTimeAction() {
        return timeAction;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + " | Thoi gian: " + timeAction;
    }
}
