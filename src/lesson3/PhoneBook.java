package lesson3;

import java.util.HashMap;

public class PhoneBook {
    private String name;
    private String phoneNumber;
    private HashMap <String, String> hashMap = new HashMap<>();

    public void setName (String name, String phoneNumber) {

        if (hashMap.get(name) == null) {      // с такой фамилией записи нет
            hashMap.put(name, phoneNumber);
        }
        else {
            hashMap.put(name, hashMap.get(name) + "," + phoneNumber); // такая фамилия уже есть, поэтому дописываем новый номер
        }
    }

    public void screenInfo (){
        System.out.println(hashMap);
    }
}
