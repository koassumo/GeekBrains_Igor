package lesson1;

public class Wall {

    String name;
    int height;

    public Wall (String name, int height) {
        this.name = name;
        this.height = height;
    };

    // результат попытки преодолеть препятствие
    public void doJump (Jumpable jumpingUnit) {
        System.out.println(height <= jumpingUnit.canJump());
    }

    public String getName() {
        return name;
    }
}
