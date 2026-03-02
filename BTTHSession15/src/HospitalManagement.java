import java.util.*;

public class HospitalManagement implements IManagement<Patient> {
    private final LinkedList<Patient> waitingQueue = new LinkedList<>();
    private final Map<String, Patient> patientIndexById = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            printMenu();
            int choice = readInt("Chọn chức năng: ", 0, 6);
            switch (choice) {
                case 1 -> register();
                case 2 -> callAndTreat();
                case 3 -> display();
                case 4 -> searchMenu();
                case 5 -> sortMenu();
                case 6 -> showHistoryMenu();
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("===== HỆ THỐNG QUẢN LÝ KHÁM BỆNH =====");
        System.out.println("1. Đăng ký khám bệnh (Thêm vào hàng đợi)");
        System.out.println("2. Gọi khám bệnh (Lấy đầu hàng đợi và cập nhật lịch sử)");
        System.out.println("3. Xem danh sách hàng đợi");
        System.out.println("4. Tìm kiếm bệnh nhân (ID hoặc tên)");
        System.out.println("5. Sắp xếp hàng đợi (tuổi hoặc ưu tiên)");
        System.out.println("6. Xem lịch sử điều trị của bệnh nhân");
        System.out.println("0. Thoát");
    }

    private void register() {
        System.out.println("--- Đăng ký khám bệnh ---");
        boolean isEmergency = readYesNo("Bệnh nhân cấp cứu? (y/n): ");

        String id;
        while (true) {
            id = readNonEmpty("Nhập mã ID: ");
            if (patientIndexById.containsKey(id)) {
                System.out.println("ID đã tồn tại. Vui lòng nhập ID khác.");
            } else {
                break;
            }
        }

        String fullName = readNonEmpty("Nhập họ tên: ");
        int age = readInt("Nhập tuổi: ", 0, 150);
        String condition = readNonEmpty("Nhập tình trạng bệnh: ");

        Patient p;
        if (isEmergency) {
            int priority = readInt("Nhập mức độ ưu tiên (1 = cao nhất): ", 1, 10);
            p = new EmergencyPatient(id, fullName, age, condition, priority);
            addEmergency((EmergencyPatient) p);
        } else {
            p = new Patient(id, fullName, age, condition);
            add(p);
        }

        patientIndexById.put(id, p);
        System.out.println("Đã thêm bệnh nhân vào hàng đợi.");
    }

    @Override
    public void add(Patient item) {
        waitingQueue.addLast(item); // enqueue
    }

    private void addEmergency(EmergencyPatient ep) {
        // Insert based on priority (lower priorityLevel means more urgent).
        // Stable insertion: keep relative order among equal priority.
        int idx = 0;
        while (idx < waitingQueue.size()) {
            Patient current = waitingQueue.get(idx);
            int curPr = current.getPriorityLevelOrDefault();
            if (ep.getPriorityLevel() < curPr) {
                break;
            }
            idx++;
        }
        waitingQueue.add(idx, ep);
    }

    private void callAndTreat() {
        System.out.println("--- Gọi khám bệnh ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("Hàng đợi rỗng. Không có bệnh nhân để khám.");
            return;
        }

        Patient p = waitingQueue.removeFirst(); // dequeue
        System.out.println("Đang khám cho bệnh nhân:");
        p.showInfo();

        String diagnosis = readNonEmpty("Nhập chẩn đoán / thuốc / ghi chú lần khám này: ");
        p.addHistory(now() + " - " + diagnosis);

        boolean updateCondition = readYesNo("Cập nhật tình trạng bệnh hiện tại? (y/n): ");
        if (updateCondition) {
            String newCondition = readNonEmpty("Tình trạng mới: ");
            p.setMedicalCondition(newCondition);
        }

        System.out.println("Đã cập nhật lịch sử điều trị (Stack push). Hoàn tất khám.");
    }

    @Override
    public void display() {
        System.out.println("--- Danh sách bệnh nhân đang chờ ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("(Trống)");
            return;
        }

        int i = 1;
        for (Patient p : waitingQueue) {
            System.out.print(i++ + ". ");
            p.showInfo();
        }
    }

    private void searchMenu() {
        System.out.println("--- Tìm kiếm ---");
        String keyword = readNonEmpty("Nhập ID hoặc tên: ");
        List<Patient> results = search(keyword);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy bệnh nhân trong hàng đợi.");
            return;
        }
        System.out.println("Kết quả:");
        for (Patient p : results) {
            p.showInfo();
        }
    }

    @Override
    public List<Patient> search(String keyword) {
        String kw = keyword == null ? "" : keyword.trim().toLowerCase(Locale.ROOT);
        if (kw.isEmpty()) return Collections.emptyList();

        List<Patient> results = new ArrayList<>();
        for (Patient p : waitingQueue) {
            if (p.getId().equalsIgnoreCase(kw) || p.getFullName().toLowerCase(Locale.ROOT).contains(kw)) {
                results.add(p);
            }
        }
        return results;
    }

    private void sortMenu() {
        System.out.println("--- Sắp xếp hàng đợi ---");
        System.out.println("1. Theo tuổi (tăng dần)");
        System.out.println("2. Theo mức độ ưu tiên (Emergency trước, ưu tiên nhỏ trước; thường sau)");
        int opt = readInt("Chọn: ", 1, 2);
        sort(opt);
        System.out.println("Đã sắp xếp.");
    }

    @Override
    public void sort(int option) {
        if (waitingQueue.size() <= 1) return;

        Comparator<Patient> comparator;
        if (option == 1) {
            comparator = Comparator
                    .comparingInt(Patient::getAge)
                    .thenComparing(Patient::getFullName, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(Patient::getId, String.CASE_INSENSITIVE_ORDER);
        } else {
            comparator = Comparator
                    .comparingInt(Patient::getPriorityLevelOrDefault)
                    .thenComparing((Patient p) -> !p.isEmergency()) // emergency first
                    .thenComparing(Patient::getFullName, String.CASE_INSENSITIVE_ORDER)
                    .thenComparingInt(Patient::getAge);
        }

        waitingQueue.sort(comparator);
    }

    private void showHistoryMenu() {
        System.out.println("--- Xem lịch sử điều trị ---");
        String id = readNonEmpty("Nhập ID bệnh nhân: ");
        Patient p = patientIndexById.get(id);
        if (p == null) {
            System.out.println("Không tồn tại bệnh nhân với ID này (trong hệ thống).");
            return;
        }

        Stack<String> history = p.getHistory();
        if (history.isEmpty()) {
            System.out.println("Lịch sử rỗng.");
            return;
        }

        System.out.println("Lịch sử (gần nhất trước - LIFO):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println("- " + history.get(i));
        }

        boolean wantPop = readYesNo("Bạn có muốn 'pop' (xóa) bản ghi gần nhất không? (y/n): ");
        if (wantPop) {
            try {
                String removed = history.pop();
                System.out.println("Đã xóa bản ghi gần nhất: " + removed);
            } catch (EmptyStackException e) {
                System.out.println("Stack rỗng, không thể pop.");
            }
        }
    }

    // -------- input helpers --------

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            if (s != null) {
                s = s.trim();
                if (!s.isEmpty()) return s;
            }
            System.out.println("Không được để trống. Vui lòng nhập lại.");
        }
    }

    private int readInt(String prompt, int minInclusive, int maxInclusive) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            try {
                int v = Integer.parseInt(s.trim());
                if (v < minInclusive || v > maxInclusive) {
                    System.out.printf("Giá trị phải trong khoảng [%d..%d].%n", minInclusive, maxInclusive);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            if (s == null) continue;
            s = s.trim().toLowerCase(Locale.ROOT);
            if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("Chỉ nhập y/n.");
        }
    }

    private static String now() {
        return java.time.LocalDateTime.now().withNano(0).toString();
    }
}
