public abstract class GameCharacter {
    private String name;
    private int hp;
    private int attackPower;

    public static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        if (amount < 0) amount = 0;
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + " đã bị hạ gục");
        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp);
    }
}
