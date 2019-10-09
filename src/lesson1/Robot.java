package lesson1;

public class Robot implements Jumpable, Runnable111, Participant {

    public String name;

    public Robot (String name){
        this.name = "Робот " + name;
    }

    @Override
    public void doNothing(){
    };

    @Override
    public int canJump() {
        int limit = 0; // лимит прыжка для робота
        System.out.print(name + " (макс.прыжок: " + limit +") попытался перепрыгнуть. Результат: ");
        return limit;
    }

    @Override
    public int canRun() {
        int limit = 99999; // лимит дистанции для робота
        System.out.print(name + " (макс.дистанция: " + limit +") попытался пробежать. Результат: ");
        return limit;
    }

}
