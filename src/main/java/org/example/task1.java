package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class task1 {                // создать ячейку , добавить к существующему, вывод 
    static void task_main(){
        Map<String, LinkedList> db = new HashMap<>();

        Scanner a = new Scanner(System.in);

        boolean flag = false;
        while (!flag){
            System.out.println("Выберете операцию с телефонной книгой");
            System.out.println("1 - создать запись");
            System.out.println("2 - добавить к существующей");
            System.out.println("3 - вывод всех записей");
            System.out.println("4 - удалить запись");
            System.out.println("5 - завершить программу");
            System.out.println("ок: ");
            String ch = a.nextLine();
            if (ch.equals("1")){                     // создание записи
                System.out.println("Введите имя: ");
                String name = a.nextLine();
                System.out.println("Введите телефон: ");
                String tel = a.nextLine();
                LinkedList <String> f = new LinkedList<>();
                f.add(tel);
                db.putIfAbsent(name, f);
            } else if (ch.equals("2")){             // добавление
                System.out.println("Введите имя: ");
                String name = a.nextLine();
                System.out.println("Введите телефон для добавления: ");
                String tel = a.nextLine();
                LinkedList <String> f = db.get(name);
                f.add(tel);
                db.put(name, f);
            } else if (ch.equals("3")){              // печать книги
                for (Map.Entry<String, LinkedList> item: db.entrySet()) {
                    System.out.println(String.format("%s - %s", item.getKey(), item.getValue()));
                }
            } else if (ch.equals("4")){              // удаление записи
                System.out.println("Введите имя для удаления: ");
                String name = a.nextLine();
                db.remove(name);
            } else if (ch.equals("5")){           // завершение программы
                flag = true;
            }
        }
        a.close();
    }
}
