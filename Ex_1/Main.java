package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Проверка простое ли число
    public static boolean NumberIsSimple(int number, ArrayList<Integer> simpleNumbersArray){
        // Если число без остатка делится на число из массива простых чисел, то оно не простое
        for (Integer i : simpleNumbersArray) {
            if (number % i == 0) {
                return false;
            }
        }
        // Если число прошло цикл и не и функция не вернула false, то число простое
        return true;
    }

    // Подсчет суммы элементов массива
    public static int ArraySum(ArrayList<Integer> simpleNumbersArray){
        int sum = 0;
        for (Integer i : simpleNumbersArray) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Сканер для считывания данных вводимых пользователем
        Scanner in = new Scanner(System.in);

        // Получение X
        System.out.print("Введите X: ");
        int x = in.nextInt();

        // Массив простых чисел
        ArrayList<Integer> simpleNumbersArray = new ArrayList<>();
        // Проходимся по всем числам до Х включительно
        for (int i = 2; i <= x; i++) {
            if (NumberIsSimple(i, simpleNumbersArray)) {
                simpleNumbersArray.add(i);
            }
        }
        // Печать суммы
        System.out.println(ArraySum(simpleNumbersArray));
    }
}
