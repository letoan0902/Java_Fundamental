import java.util.Scanner;
import java.util.Stack;

class HistoryManager {
    Stack<HistoryActions> historyActions = new Stack<>();

    // Sau khi tiep nhan moi/sua thong tin/Loai bo thu cung khoi danh sach
    void saveActionToHistory(HistoryActions action) {
        historyActions.push(action);
    }

    // Hoan tac (Undo): Cho phep xem lai hoac lay ra hanh dong gan nhat vua thuc hien (theo nguyen tac Last-In-First-Out).
    HistoryActions undoAction(Scanner sc) {
        if (historyActions.isEmpty()) {
            System.out.println("Chua co hanh dong nao gan nhat");
            return null;
        }
        HistoryActions currentAction = historyActions.peek();
        System.out.println("Hanh dong gan nhat: " + currentAction.getDescription() + " | Thoi gian: " + currentAction.getTimeAction());
        System.out.println("Hoan tac? (y/n)");
        String undoOption = sc.nextLine();
        if (undoOption.equalsIgnoreCase("y")) {
            return historyActions.pop();
        }
        return currentAction;
    }

    void displayHistoryAction() {
        if (historyActions.isEmpty()) {
            System.out.println("Chua co lich su hoat dong nao.");
            return;
        }
        System.out.println("==== Lich su hoat dong ====");
        for (HistoryActions ha : historyActions) {
            System.out.println(ha.getDescription() + " | Thoi gian: " + ha.getTimeAction());
        }
    }
}
