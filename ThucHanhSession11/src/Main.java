//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ARENA OF HEROES ===");

        GameCharacter[] characters = new GameCharacter[3];
        characters[0] = new Warrior("Yasuo", 400, 50, 20);
        characters[1] = new Mage("Veigar", 300, 40, 150);

        characters[2] = new GameCharacter("Goblin", 100, 0) {
            @Override
            public void attack(GameCharacter target) {
                if (target == null) return;
                System.out.println("[Quái vật] " + getName() + " (Anonymous Class) tấn công!");
                System.out.println("    -> Goblin cắn trộm " + target.getName() + "...");
                target.takeDamage(10);
            }

            @Override
            public void displayInfo() {
                System.out.println("Tên: " + getName() + " | HP: " + getHp());
            }
        };

        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");

        // Mô phỏng 1 vài lượt đánh mẫu (có kiểm tra null)
        if (characters[0] != null && characters[2] != null) {
            characters[0].attack(characters[2]);
        }

        if (characters[1] != null && characters[0] != null) {
            ((ISkill) characters[1]).useUltimate(characters[0]);
        }

        if (characters[2] != null && characters[1] != null) {
            characters[2].attack(characters[1]);
        }

        // Loop cho các nhân vật lần lượt tấn công người kế tiếp (đa hình)
        System.out.println("\n=== LOOP TẤN CÔNG ===");
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == null) continue;
            GameCharacter attacker = characters[i];
            GameCharacter target = characters[(i + 1) % characters.length];
            if (target == null) continue;

            if (!attacker.isAlive() || !target.isAlive()) continue;
            attacker.attack(target);
        }

        // Gọi thử ultimate của warrior nếu còn sống
        if (characters[0] instanceof ISkill && characters[0].isAlive() && characters[1] != null && characters[1].isAlive()) {
            ((ISkill) characters[0]).useUltimate(characters[1]);
        }

        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        System.out.println("Tổng số nhân vật đã tạo: " + GameCharacter.count);
        for (GameCharacter c : characters) {
            if (c == null) continue;
            c.displayInfo();
        }
    }
}