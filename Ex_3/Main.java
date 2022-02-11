package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Счетчик для количества линз
        int countOfLensPairs = 0;

        // Сканер для считывания данных вводимых пользователем
        Scanner in = new Scanner(System.in);
        // Получение N
        System.out.print("Введите N: ");
        int n = in.nextInt();

        // Получение массива
        ArrayList<Integer> lensArray = new ArrayList<>();
        System.out.print("Введите массив: ");
        for (int i = 0; i < n; i++) {
            lensArray.add(in.nextInt());
        }

        // Сортируем массив, чтобы значения шли последовательно
        Collections.sort(lensArray);

        while (lensArray.size() > 1) {
            // Если значение текущей линзы равно значению следующей или меньше его на единицу, то они образуют пару,
            // соответственно нужно выбросить оба значения
            if (Objects.equals(lensArray.get(0), lensArray.get(1)) || Objects.equals(lensArray.get(0) + 1, lensArray.get(1))) {
                lensArray.remove(1);
            }
            // Если пары нет, то в любом случае значение удаляется, а счетчик увеличивается
            lensArray.remove(0);
            countOfLensPairs++;
        }
        // Если в массиве осталась одно непарное значение, то счетчик увеличивается
        countOfLensPairs += lensArray.size();

        System.out.print(countOfLensPairs);
    }
}
