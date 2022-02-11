package com.company;

import java.util.Scanner;

public class Main {

    // Функция печатает количество выданных купюр, если будет выдана хоть одна купюра заданного номинала
    // и возвращает оставшуюся для выдачи сумму сдачи
    public static int PrintPayback(int actualPaybackNominal, int remainingPayback) {
        // Проверка будет ли выдана хоть одна купюра данного номинала
        if (remainingPayback >= actualPaybackNominal) {
            // Печать количества выдаваемых купюр
            System.out.print(actualPaybackNominal + " руб: " + remainingPayback / actualPaybackNominal + " шт.");
            // Вычитание выданных купюр из сдачи
            remainingPayback %= actualPaybackNominal;
            // Проверка будут ли выданы другие купюры (имеет ли смысл ставить запятую)
            if (remainingPayback > 0) {
                System.out.print(", ");
            }
        }
        return remainingPayback;
    }

    public static void main(String[] args) {
        // Номиналы купюр сдачи
        final int[] paybackNominals = {5000, 2000, 1000, 500, 200, 100, 50, 10, 5, 2, 1};

        // Сканер для считывания данных вводимых пользователем
        Scanner in = new Scanner(System.in);

        // Получение суммы заказа
        System.out.print("Введите сумму заказа: ");
        int cost = in.nextInt();

        // Получение суммы внесенной клиентом
        System.out.print("Введите сумму внесенную клиентом: ");
        int paid = in.nextInt();

        // Сумма сдачи
        int payback = cost - paid;

        // Печать сдачи для каждой из купюр
        for (int i : paybackNominals) {
            payback = PrintPayback(i, payback);
            // Прерывание цикла если сдача выдана полностью
            if (payback == 0) {
                break;
            }
        }
    }
}
