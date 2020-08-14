package GB.HW7;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите колличество строк:");
        int m = in.nextInt();
        System.out.println("Введите колличество столбцов:");
        int n = in.nextInt();

        //С помощью переменной s задаются числа внутри массива начиная с 1.
        int s = 1;

        //Объявляем и инициализируем массив.
        int[][] array = new int[m][n];

        //Заполняем периметр массива по часовой стрелке.
        for (int y = 0; y < n; y++) {
            array[0][y] = s;
            s++;
        }
        for (int x = 1; x < m; x++) {
            array[x][n - 1] = s;
            s++;
        }
        for (int y = n - 2; y >= 0; y--) {
            array[m - 1][y] = s;
            s++;
        }
        for (int x = m - 2; x > 0; x--) {
            array[x][0] = s;
            s++;
        }

        //Периметр заполнен. Продолжаем заполнять массив и задаём
        //координаты ячейки, которую необходимо заполнить следующей.
        int c = 1;
        int d = 1;

        while (s < m * n) {
            //Движемся вправо.
            while (array[c][d + 1] == 0) {
                array[c][d] = s;
                s++;
                d++;
            }

            //Движемся вниз.
            while (array[c + 1][d] == 0) {
                array[c][d] = s;
                s++;
                c++;
            }

            //Движемся влево.
            while (array[c][d - 1] == 0) {
                array[c][d] = s;
                s++;
                d--;
            }

            //Движемся вверх.
            while (array[c - 1][d] == 0) {
                array[c][d] = s;
                s++;
                c--;
            }
        }

        //Убираем незаполненную ячейку в центре при помощи следующего цикла.
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] == 0) {
                    array[x][y] = s;
                }
            }
        }

        //Выводим массив в консоль.
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] < 10) {
                    //Два пробела, чтобы в консоли столбцы были ровные.
                    System.out.print(array[x][y] + ",  ");
                } else {
                    System.out.print(array[x][y] + ", ");
                }
            }
            System.out.println("");
        }
    }
}
