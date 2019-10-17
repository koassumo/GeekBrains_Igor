package lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Main_lesson3 {


    public static void main(String[] args) {

// -------------------------------------------------------------------------------------
// ЗАДАЧА 1
// -------------------------------------------------------------------------------------
        String[] myArray = {"A",
                "B",
                "C", "C",
                "D", "D", "D",
                "E",
                "F", "F",
                "B"};



// ____________________________________________________________________________________
        System.out.println("\nЗАДАЧА 1. Вариант решения 1. - Через HashMap");


        HashMap<String, String> hashMap = new HashMap<>();
        int currentNumber;

        for (int i = 0; i < myArray.length; i++) {
            currentNumber = 1;
            if (hashMap.get(myArray[i]) != null) {
                currentNumber = Integer.parseInt(hashMap.get(myArray[i])) + 1;
            }
            hashMap.put(myArray[i], currentNumber + "");
        }
        System.out.println(hashMap);



// ____________________________________________________________________________________
        System.out.println("\nЗАДАЧА 1. Вариант решения 2. - Через ArrayList (просто, чтобы попрактиковаться на ArrayList)");

        // Перегонка в ArrayList. Способ 1
        ArrayList<String> newArr = new ArrayList<>(myArray.length);
        for (int i = 0; i < myArray.length; i++) {
            newArr.add(myArray[i]); // дописка нового элемента просто в конец списка
        }

        // Перегонка в ArrayList. Способ 2 (лаконичнее)
        // List<String> newArray = new ArrayList<>(Arrays.asList(myArray));


        // после каждого элемента дописываем "1" (типа инициация счетчика для каждого элемента
        for (int i = 0; i < newArr.size(); i += 2) {
            newArr.add(i + 1, "1");    // впихивание нового элемента внутрь массива (остальные элементы смещаются вправо)
        }

        // теперь проверка: элемент (currentElementLookingFor) уже встречался ранее?
        String currentElementLookingFor;
        for (int i = 2; i < newArr.size(); i += 2) {
            currentElementLookingFor = newArr.get(i);

            // идем от начала массива до currentElementLookingFor и проверяем встречался ли ранее в списке currentElementLookingFor
            int count;
            for (int j = 0; j < i; j += 2) {
                if (newArr.get(j) == currentElementLookingFor) {       //нашли !
                    count = Integer.parseInt(newArr.get(j + 1)) + 1;   // +1 к счетчику первого в списке аналогичного элемента
                    newArr.set(j + 1, count + "");                    // ВНИМАНИЕ! тут как раз set позволяет не раздвинуть, а заменить элемент (в отличие от add)

                    // т.к currentElementLookingFor - это повторка, то убиваем ее
                    newArr.remove(i + 1);
                    newArr.remove(i);
                    i -= 2;
                }
            }
        }

        // Перегонка обратно в традиционный массив и вывод результата
        String[] arrResult = new String[newArr.size()];
        newArr.toArray(arrResult);

        for (int i = 0; i < arrResult.length; i += 2) {
            System.out.println(arrResult[i] + ": " + arrResult [i+1]);
        }


// -------------------------------------------------------------------------------------
// ЗАДАЧА 2
// -------------------------------------------------------------------------------------
// ____________________________________________________________________________________
        System.out.println("\nЗАДАЧА 2.");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setName ("Ivanov", "111-111");
        phoneBook.setName ("Petrov", "222-222");
        phoneBook.setName ("Sidorov", "333-333");
        phoneBook.setName ("Ivanov", "555-555");

        phoneBook.screenInfo();
    }
}
