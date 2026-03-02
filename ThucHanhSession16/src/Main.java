import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PetManager petManager = new PetManager();
    static CustomerManager<Customer> customerManager = new CustomerManager<>();
    static SpaQueue<Pet> spaQueue = new SpaQueue<>();
    static HistoryManager historyManager = new HistoryManager();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== PET KINGDOM =====");
            System.out.println("1. Quan ly thu cung");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly dich vu Spa");
            System.out.println("4. Nhat ky hoat dong");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    menuPet();
                    break;
                case 2:
                    menuCustomer();
                    break;
                case 3:
                    menuSpa();
                    break;
                case 4:
                    menuHistory();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
        sc.close();
    }

    // ===================== MENU QUAN LY THU CUNG =====================
    static void menuPet() {
        int choice;
        do {
            System.out.println("\nQUAN LY THU CUNG");
            System.out.println("1. Them moi thu cung");
            System.out.println("2. Hien thi danh sach thu cung");
            System.out.println("3. Tim kiem thu cung theo ID");
            System.out.println("4. Xoa thu cung");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhap ten: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap loai: ");
                    String species = sc.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int age = sc.nextInt();

                    Pet newPet = new Pet(id, name, species, age);
                    petManager.addPet(newPet);
                    // Luu vao nhat ky
                    historyManager.saveActionToHistory(
                            new HistoryActions("Them thu cung: " + name + " (ID: " + id + ")", LocalDateTime.now()));
                    break;

                case 2:
                    petManager.showPets();
                    break;

                case 3:
                    System.out.print("Nhap ID can tim: ");
                    String searchId = sc.nextLine();
                    Pet pet = petManager.findPetById(searchId);
                    if (pet != null) {
                        System.out.println(pet);
                    } else {
                        System.out.println("Khong tim thay thu cung");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ID can xoa: ");
                    String deleteId = sc.nextLine();
                    Pet deletedPet = petManager.findPetById(deleteId);
                    if (petManager.deletePetById(deleteId)) {
                        System.out.println("Xoa thanh cong");
                        // Luu vao nhat ky
                        historyManager.saveActionToHistory(
                                new HistoryActions("Xoa thu cung: " + deletedPet.getName() + " (ID: " + deleteId + ")", LocalDateTime.now()));
                    } else {
                        System.out.println("Khong tim thay thu cung");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }

    // ===================== MENU QUAN LY KHACH HANG =====================
    static void menuCustomer() {
        int choice;
        do {
            System.out.println("\nQUAN LY KHACH HANG");
            System.out.println("1. Dang ky thanh vien");
            System.out.println("2. Tim kiem nhanh");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhap ten: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap SDT: ");
                    String phone = sc.nextLine();

                    Customer c = new Customer(id, name, phone);
                    customerManager.registerCustomer(c);
                    // Luu vao nhat ky
                    historyManager.saveActionToHistory(
                            new HistoryActions("Dang ky khach hang: " + name + " (ID: " + id + ")", LocalDateTime.now()));
                    break;

                case 2:
                    System.out.print("Nhap ID can tim: ");
                    String searchId = sc.nextLine();
                    Customer found = customerManager.findById(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Khong tim thay khach hang!");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }

    // ===================== MENU QUAN LY DICH VU SPA =====================
    static void menuSpa() {
        int choice;
        do {
            System.out.println("\nQUAN LY DICH VU SPA");
            System.out.println("1. Tiep nhan thu cung");
            System.out.println("2. Xu ly dich vu");
            System.out.println("3. Hien thi danh sach cho");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID thu cung can tiep nhan: ");
                    String petId = sc.nextLine();
                    Pet pet = petManager.findPetById(petId);
                    if (pet != null) {
                        spaQueue.receive(pet);
                        // Luu vao nhat ky
                        historyManager.saveActionToHistory(
                                new HistoryActions("Tiep nhan thu cung vao Spa: " + pet.getName() + " (ID: " + petId + ")", LocalDateTime.now()));
                    } else {
                        System.out.println("Khong tim thay thu cung voi ID: " + petId);
                    }
                    break;

                case 2:
                    Pet served = spaQueue.serve();
                    if (served != null) {
                        // Luu vao nhat ky
                        historyManager.saveActionToHistory(
                                new HistoryActions("Phuc vu Spa cho thu cung: " + served.getName() + " (ID: " + served.getId() + ")", LocalDateTime.now()));
                    }
                    break;

                case 3:
                    spaQueue.showWaitingList();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }

    // ===================== MENU NHAT KY HOAT DONG =====================
    static void menuHistory() {
        int choice;
        do {
            System.out.println("\nNHAT KY HOAT DONG GAN DAY");
            System.out.println("1. Xem lich su hoat dong");
            System.out.println("2. Hoan tac (Undo)");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    historyManager.displayHistoryAction();
                    break;

                case 2:
                    historyManager.undoAction(sc);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }
}