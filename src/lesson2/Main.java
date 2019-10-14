package lesson2;

public class Main {
public static final int SIZE = 4; //нужная размерность

    public static void main(String[] args) {


        // Массив № 1 (не попадает в размертость)
        String[][] myArray1 = {
                {"1", "1", "1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1", "1", "1"},
        };

        // Массив № 2 (все - ok)
        String[][] myArray2 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };

        // Массив № 3 (имеются невалидные элементы)
        String[][] myArray3 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "null"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "ldfksjklfd"},
        };


        System.out.println("Массив № 1. "); getSumArray(myArray1);
        System.out.println("Массив № 2. "); getSumArray(myArray2);
        System.out.println("Массив № 3. "); getSumArray(myArray3);
    }



    private static void getSumArray(String array[][]) {
        boolean isValidArraySize = true;


        // проверка размерности массива
        try {
            if (array.length != SIZE || array [0].length != SIZE) {
                isValidArraySize = false;
                throw new MyArraySizeException ();
            }
        } catch (MyArraySizeException e) {          //сделал с захватом, чтобы программа не вылетала после отработки исключения
            e.printStackTrace();
        }


        // подсчет суммы всех элементов
        if (isValidArraySize == true){
            int result = 0;
            int stringToInteger = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        stringToInteger = Integer.parseInt(array[i][j]);
                        result = result + stringToInteger;                  // если предыдущая строка вылетела в ошибку, добавление элемента здесь не произойдет
                    } catch (Exception e1) {
                        try {
                            throw new MyArrayDataException(i, j);
                        } catch (MyArrayDataException e2) {          //тут получился двойной try-catch, чтобы программа не прерывалась (сразу вызвать MyArrayDataException не выходит)
                        }
                    }
                }
            }
            System.out.println("Результат суммирования: " + result);
        }


        System.out.println();
    }
}