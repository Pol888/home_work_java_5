package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class task2 {
    static void task_main(){
        LinkedList<String> l = new LinkedList<>();             // создали LinkedList
        l.add("Иван Иванов"); l.add("Светлана Петрова"); l.add("Кристина Белова");l.add("Анна Мусина");
        l.add("Анна Крутова");l.add("Иван Юрин"); l.add("Петр Лыков");l.add("Павел Чернов"); l.add("Петр Чернышов");
        l.add("Мария Федорова"); l.add("Марина Светлова");l.add("Мария Савина"); l.add("Мария Рыкова");
        l.add("Марина Лугова"); l.add("Анна Владимирова");l.add("Иван Мечников"); l.add("Петр Петин");l.add("Иван Ежов");

        Map<String, Integer> score = new HashMap<>();   // создаем HashMap

        for (int i = 0; i < l.size(); i++) {
            String name = l.get(i).split(" ")[0];  // наполняем HashMap
            if (score.containsKey(name)){
                score.put(name, score.get(name) + 1);

            } else
                score.put(name, 1);
        }

        int max_element = Collections.max(score.values()); // максимальное количество однообразных имен

        while (max_element != 0){
            for (Map.Entry<String, Integer> item: score.entrySet()) {
                if (item.getValue() == max_element){  // сначала выводим элементы с максимальным value, уменьшаем max_element
                    System.out.println(String.format("%s: %s", item.getKey(), item.getValue()));
                }
            }
            max_element --;
        }









    }
}
