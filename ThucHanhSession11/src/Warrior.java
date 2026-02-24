public class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = Math.max(armor, 0);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = Math.max(armor, 0);
    }

    @Override
    public void attack(GameCharacter target) {
        if (target == null) return;
        System.out.println("[Chiến binh] " + getName() + " tấn công " + target.getName() + "!");
        target.takeDamage(getAttackPower());
        System.out.println("    -> " + target.getName() + " mất " + getAttackPower() + " máu. HP còn: " + target.getHp() + ".");
    }

    @Override
    public void takeDamage(int damage) {
        int actual = damage - armor;
        if (actual < 0) actual = 0;
        super.takeDamage(actual);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (target == null) return;
        System.out.println("[Chiến binh] " + getName() + " dùng chiêu cuối 'Đấm ngàn cân' lên " + target.getName() + "!");
        int dmg = getAttackPower() * 2;
        target.takeDamage(dmg);

        int selfLoss = (int) Math.ceil(getHp() * 0.10);
        if (selfLoss < 0) selfLoss = 0;
        setHp(getHp() - selfLoss);

        System.out.println("    -> Gây " + dmg + " sát thương. " + getName() + " mất " + selfLoss + " HP do gắng sức.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + getName() + " | HP: " + getHp() + " | Giáp: " + armor);
    }
}
