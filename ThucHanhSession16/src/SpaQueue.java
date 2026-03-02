import java.util.LinkedList;
import java.util.Queue;

class SpaQueue<T> {
    private Queue<T> waitingQueue;

    public SpaQueue() {
        waitingQueue = new LinkedList<>();
    }

    // Tiep nhan doi tuong vao danh sach cho spa
    public void receive(T item) {
        waitingQueue.offer(item);
        System.out.println("Da tiep nhan vao Spa: " + item);
    }

    // Xu ly dich vu theo FIFO
    public T serve() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Khong co doi tuong nao dang cho Spa.");
            return null;
        }

        T currentItem = waitingQueue.peek();
        waitingQueue.remove();

        System.out.println("Dang phuc vu: " + currentItem);
        return currentItem;
    }

    // Hien thi danh sach cho
    public void showWaitingList() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Danh sach cho Spa trong.");
            return;
        }

        System.out.println("Danh sach dang cho Spa:");
        for (T item : waitingQueue) {
            System.out.println(item);
        }
    }
}
