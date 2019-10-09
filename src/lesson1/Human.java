package lesson1;

public class Human implements Jumpable, Runnable111, Participant {

    public String name;


    public Human(String name){
        this.name = "Человек " + name;
    }

    @Override
    public void doNothing(){
    };

    @Override
    public int canJump() {
        int limit = 1; // лимит прыжка для человека
        System.out.print(name + " (макс.прыжок: " + limit +") попытался перепрыгнуть. Результат: ");
        return limit;
    }

    @Override
    public int canRun() {
        int limit = 1000; // лимит дистанции для человека
        System.out.print(name + " (макс.дистанция: " + limit +") попытался пробежать. Результат: ");
        return limit;
    }

}
