package lesson5;


public class Main_lesson5 {

        public static void main(String[] args) throws InterruptedException {

            final int SIZE = 10_000_000;
            float[] fullArray = new float[SIZE];
            for (int i = 0; i < SIZE; i++) { fullArray[i] = 1; }

            int partSize;
            long startTime;
            long resultTime;
            long bestTime = 9999999;
            int bestThreadsNumber = 1;

            for (int parts = 1; parts < 32768; parts *=2) {                 // в каждом цикле количество создаваемых потоков увеличивается вдвое
                for (int j = 0; j < SIZE; j++) { fullArray[j] = 1; }        // "обнуляем" главный массив перед каждым замером

                System.out.print("Измерение в " + parts + " поток(ов) ... ");
                startTime = System.currentTimeMillis();

                partSize = SIZE / parts;                                    // определяем количество элементов в каждом куске

                float[][] partArray = new float[parts][partSize];           // создаем двумерный массив для разбивки на куски главного массива
                Th[] thr = new Th[parts];                                   // создаем нужное количество потоков (по количеству кусков)
                for (int i = 0; i < parts; i++) {                           // в цикле каждый кусок помещаем в массив и сразу направляем в свой поток для обработки
                    System.arraycopy(fullArray, 0, partArray[i], 0, partSize);
                    thr[i] = new Th(partArray[i], partSize);
                    thr[i].start();
                }
                for (int i = 0; i < parts; i++) {                           // ждем когда все потоки отработают
                    thr[i].join();
                }
                for (int i = 0; i < parts; i++) {                           // склеиваем все куски обратно в главный массив
                    System.arraycopy(thr[i].getArr(), 0, fullArray, i * partSize, partSize);
                }
                resultTime = System.currentTimeMillis() - startTime;      // проверяем время
                System.out.println(resultTime + " ms");
                if (resultTime < bestTime){ bestTime = resultTime; bestThreadsNumber = parts;} // при необходимости записываем как лучший результат
            }
            System.out.println("\n!!!!! Лучший результат: в " + bestThreadsNumber + " поток(ов), " + bestTime + " ms !!!!!");
        }
}
