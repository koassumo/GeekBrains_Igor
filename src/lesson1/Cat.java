package lesson1;

public class Cat implements Runnable111, Jumpable, Participant {

    String name;
    public Cat(String name){
        this.name = "Кот " + name;
    }


    @Override
    public void doNothing(){
    };

    @Override
    public int canJump() {
        int limit = 2; // лимит прыжка для кота
        System.out.print(name + " (макс.прыжок: " + limit +") попытался перепрыгнуть. Результат: ");
        return limit;
    }

    @Override
    public int canRun() {
        int limit = 200; // лимит дистанции для кота
        System.out.print(name + " (макс.дистанция: " + limit +") попытался пробежать. Результат: ");
        return limit;
    }
}
