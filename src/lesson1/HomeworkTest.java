package lesson1;

public class HomeworkTest {
    public static void main(String[] args) {

        Human human = new Human("Толя");
        Robot robot = new Robot("Мегатрон");
        Cat cat = new Cat("Мурзик");

        RunningTrack track;
        Wall zabor;

        int [][] obstacles = {
                {1, 10},    // высота забора, длина трека
                {2, 120},
                {5, 500},
        };

        for (int i = 0; i < 3; i++) {

            int height = obstacles[i][0];
            int distance = obstacles[i][1];

            zabor = new Wall("Забор ", height);
            track = new RunningTrack("Беговая дорожка ", distance);

            System.out.println("");
            System.out.println("------------------- Уровень " + (i+1) + " ---------------------------------------------------");

            System.out.println("____ " + zabor.getName() + height + " м :");
            zabor.doJump(human);
            zabor.doJump(robot);
            zabor.doJump(cat);

            System.out.println("____ " + track.getName() + distance + " м :");
            track.doRun(human);
            track.doRun(robot);
            track.doRun(cat);

        }
    }
}
