import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IRepository<Product> {
    private final List<Product> products = new ArrayList<>();

    private final Map<String, Product> byId = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || item.getId() == null || item.getId().isBlank()) {
            return false;
        }
        if (byId.containsKey(item.getId())) {
            return false;
        }
        products.add(item);
        byId.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }
        Product removed = byId.remove(id);
        if (removed == null) {
            return false;
        }
        products.remove(removed);
        return true;
    }

    @Override
    public Product findById(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        return byId.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
}
