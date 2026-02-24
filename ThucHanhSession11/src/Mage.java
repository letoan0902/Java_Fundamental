public class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = Math.max(mana, 0);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(mana, 0);
    }

    @Override
    public void attack(GameCharacter target) {
        if (target == null) return;

        int dmg;
        if (mana >= 5) {
            dmg = getAttackPower();
            mana -= 5;
            System.out.println("[Pháp sư] " + getName() + " tung phép lên " + target.getName() + "! (-5 mana)");
        } else {
            dmg = getAttackPower() / 2;
            System.out.println("[Pháp sư] " + getName() + " hết mana, đánh thường lên " + target.getName() + "!");
        }

        target.takeDamage(dmg);
        System.out.println("    -> " + target.getName() + " mất " + dmg + " máu. HP còn: " + target.getHp() + ".");
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (target == null) return;

        System.out.println("[Pháp sư] " + getName() + " dùng chiêu cuối 'Hỏa cầu' lên " + target.getName() + "!");
        if (mana < 50) {
            System.out.println("    -> Không đủ mana (cần 50). Mana hiện tại: " + mana);
            return;
        }

        mana -= 50;
        int dmg = getAttackPower() * 3;
        target.takeDamage(dmg);
        System.out.println("    -> " + getName() + " tốn 50 mana. Gây " + dmg + " sát thương.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + getName() + " | HP: " + getHp() + " | Mana: " + mana);
    }
}
