package org.example;

import java.util.ArrayList;
import java.util.List;


public class task3 {
    public static ArrayList<ArrayList<Integer>> field;
    static void task_main(){
        field = new ArrayList<>(8); // 8 x 8
        for (int i=0; i < 8; i++) {
            ArrayList<Integer> v = new ArrayList<>();
            v.add(0); v.add(0);v.add(0); v.add(0);v.add(0); v.add(0);v.add(0); v.add(0);
            field.add(v);

        }
    work(0);
    }


    static void setQueen (int i, int j){  // ставит битые поля
        for (int x = 0; x < 8; x++) {
            field.get(x).set(j, field.get(x).get(j) + 1);
            field.get(i).set(x, field.get(i).get(x) + 1);
            if(0 <= i + j - x && i + j - x < 8){
                field.get(i + j - x).set(x, field.get(i + j - x).get(x) + 1);
            }
            if(0 <= i - j + x && i - j + x < 8){
                field.get(i - j + x).set(x, field.get(i - j + x).get(x) + 1);
            }
            field.get(i).set(j, -1);
        }
    }
    static void removeQueen (int i, int j){    // убирает битые поля
        for (int x = 0; x < 8; x++) {
            field.get(x).set(j, field.get(x).get(j) - 1);
            field.get(i).set(x, field.get(i).get(x) - 1);
            if(0 <= i + j - x && i + j - x < 8){
                field.get(i + j - x).set(x, field.get(i + j - x).get(x) - 1);
            }
            if(0 <= i - j + x && i - j + x < 8){
                field.get(i - j + x).set(x, field.get(i - j + x).get(x) - 1);
            }
            field.get(i).set(j, 0);
        }
    }

    static void print_the_solution(){  // печатает удачный результат
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field.get(i).get(j) == -1){
                    System.out.print("X"); System.out.print(" ");
                }
                else{
                    System.out.print("0"); System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void work(int i){                // главная функция
        for (int j = 0; j < 8; j++) {
            if (field.get(i).get(j) == 0){
                setQueen(i, j);
                if (i == 7){
                    print_the_solution();
                } else {
                    work(i + 1);
                }
            removeQueen(i, j);
            }
        }
    }
}
