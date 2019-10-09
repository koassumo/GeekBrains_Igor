package lesson1;

public class RunningTrack {

    String name;
    int distance;

    public RunningTrack (String name, int distance) {
        this.name = name;
        this.distance = distance;
    };

    // результат попытки преодолеть препятствие
    public void doRun (Runnable111 runningUnit) {
        System.out.println(distance <= runningUnit.canRun());
    }

    public String getName() {
        return name;
    }
}
