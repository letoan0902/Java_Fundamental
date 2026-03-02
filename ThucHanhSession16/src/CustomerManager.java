import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CustomerManager<T extends Customer> {
    private Map<String, T> customerMap = new HashMap<>();
    private Set<String> phoneSet = new HashSet<>();

    public void registerCustomer(T customer) {
        if (customerMap.containsKey(customer.getId())) {
            System.out.println("ID da ton tai");
            return;
        }
        if (phoneSet.contains(customer.getPhone())) {
            System.out.println("So dien thoai da ton tai");
            return;
        }
        customerMap.put(customer.getId(), customer);
        phoneSet.add(customer.getPhone());

        System.out.println("Dang ky thanh cong");
    }

    public T findById(String id) {
        return customerMap.get(id);
    }

}
