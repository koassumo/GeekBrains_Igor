package lesson2;

public class MyArrayDataException extends IllegalArgumentException{

    public MyArrayDataException (int i, int j){
        System.out.println("Исключено из подсчета невалидное значение по адресу: " + (i+1) + ", " + (j+1));

    }
}
