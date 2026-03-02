class Customer {
    private String id;
    private String name;
    private String phone;

    public Customer(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Phone: " + phone;
    }
}
