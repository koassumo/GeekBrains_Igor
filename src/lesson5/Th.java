package lesson5;

public class Th extends Thread    {

    float [] arr;
    int size;

    Th (float [] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public int get (){
        return size - 5;
    }

    public float[] getArr (){
        return arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < size; i++) {
            try {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                    sleep(500);
//                    System.out.println("Обработан: " + i);
            } catch (Exception e) {}
        }
    }


}
