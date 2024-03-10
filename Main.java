// Interfaz para definir el comportamiento de ataque
interface AttackBehavior {
    void attack();
}

// Implementaciones concretas de comportamientos de ataque
class SwordAttack implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Atacando con espada!");
    }
}

class BowAttack implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Disparando con arco!");
    }
}

class SpearAttack implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Lanzando con lanza!");
    }
}

// Interfaz para definir el comportamiento de movimiento
interface MovementBehavior {
    void move();
}

// Implementaciones concretas de comportamientos de movimiento
class WalkMovement implements MovementBehavior {
    @Override
    public void move() {
        System.out.println("Caminando...");
    }
}

class RunMovement implements MovementBehavior {
    @Override
    public void move() {
        System.out.println("Corriendo...");
    }
}

class HorseMovement implements MovementBehavior {
    @Override
    public void move() {
        System.out.println("Cabalgando...");
    }
}

// Clase principal que representa una unidad militar
class Unit {
    private AttackBehavior attackBehavior;
    private MovementBehavior movementBehavior;

    public Unit(AttackBehavior attackBehavior, MovementBehavior movementBehavior) {
        this.attackBehavior = attackBehavior;
        this.movementBehavior = movementBehavior;
    }

    public void performAttack() {
        attackBehavior.attack();
    }

    public void performMovement() {
        movementBehavior.move();
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public void setMovementBehavior(MovementBehavior movementBehavior) {
        this.movementBehavior = movementBehavior;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una unidad de soldado con ataque de espada y movimiento a pie
        Unit soldier = new Unit(new SwordAttack(), new WalkMovement());
        System.out.println("Soldado:");
        soldier.performAttack();
        soldier.performMovement();
        System.out.println();

        // Cambiar el comportamiento de ataque del soldado a arco y movimiento a caballo
        soldier.setAttackBehavior(new BowAttack());
        soldier.setMovementBehavior(new HorseMovement());
        System.out.println("Soldado (con cambio de comportamiento):");
        soldier.performAttack();
        soldier.performMovement();
        System.out.println();

        // Crear una unidad de arquero con ataque de arco y movimiento corriendo
        Unit archer = new Unit(new BowAttack(), new RunMovement());
        System.out.println("Arquero:");
        archer.performAttack();
        archer.performMovement();
        System.out.println();

        // Crear una unidad de caballero con ataque de lanza y movimiento a caballo
        Unit knight = new Unit(new SpearAttack(), new HorseMovement());
        System.out.println("Caballero:");
        knight.performAttack();
        knight.performMovement();
        System.out.println();
    }
}
