import java.lang.Math;

public class Player {
    private static int numPlayers = 0;
    private int x, y, z;
    private int direction;
    private int hp;
    private String name;

    public Player() {
        this.name = "P" + (numPlayers + 1);
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.hp = 20;
        this.direction = 1;
        numPlayers++;
    }

    public Player(String name, int x, int y, int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hp = 20;
        this.direction = 1;
        numPlayers++;
    }

    public Player(String name, int x, int y, int z, int health, int direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hp = Math.max(0, health);
        this.direction = (direction >= 1 && direction <= 6) ? direction : 1;
        numPlayers++;
    }

    public static int getNumPlayers() {
        return numPlayers;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getHp() {
        return hp;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nHealth: " + hp + "\nCoordinates: X " + x + " Y " + y + " Z " + z + "\nDirection: " + direction;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public void setDirection(int direction) {
        if (direction >= 1 && direction <= 6) {
            this.direction = direction;
        }
    }

    public void move(int direction, int units) {
        switch (direction) {
            case 1: this.x += units; break; // North
            case 2: this.x -= units; break; // South
            case 3: this.y += units; break; // Up
            case 4: this.y -= units; break; // Down
            case 5: this.z += units; break; // East
            case 6: this.z -= units; break; // West
        }
    }

    public void teleport(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void teleport(Player player) {
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
    }

    public void attack(Player player, int damage) {
        int newHp = player.getHp() - damage;
        player.setHp(Math.max(0, newHp));
        this.hp += damage / 2; 
    }

    public double getDistance(int x, int y, int z) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2));
    }

    public double getDistance(Player player) {
        return getDistance(player.getX(), player.getY(), player.getZ());
    }
}
