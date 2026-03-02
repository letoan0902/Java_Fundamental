import java.util.List;

public interface IManagement<T> {
    void add(T item);

    void display();

    List<T> search(String keyword);

    void sort(int option);
}
