class Pet {
    private String id;
    private String name;
    private String species;
    private int age;

    public Pet(String id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Ten: " + name +
               " | Loai: " + species +
               " | Tuoi: " + age;
    }
}
