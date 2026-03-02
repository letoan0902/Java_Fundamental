import java.util.ArrayList;
import java.util.List;

class Manager<T> {
    protected List<T> list;

    public Manager() {
        list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

}
