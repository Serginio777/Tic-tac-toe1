package com.devcolibri;


import java.util.Scanner;

public class krestiki_noliki {
    //1) Комп ходящий рандомно
    public static void main(String[] args) {
        char[][] gameField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        showGameField(gameField);
        int result;
        char symbol = 'X';
        do {
            makeMove(gameField, symbol);
            symbol = symbol == 'X' ? '0' : 'X';
            if (symbol != 'X')
                makeMoveRandom(gameField, symbol);
            showGameField(gameField);
            result = checkField(gameField);
        } while (result == 0);
        switch (result) {
            case 1:
                System.out.println("Победа X");
                break;
            case 2:
                System.out.println("Победа 0");
                break;
            case 3:
                System.out.println("Ничья");
        }
    }

    //2) Два компа ходящих рандомно (c паузой)
    public static void main1(String[] args) {
        char[][] gameField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        showGameField(gameField);
        int result;
        char symbol = 'X';
        do {
            try { //условие для паузы хода
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            makeMoveRandom(gameField, symbol);
            symbol = symbol == 'X' ? '0' : 'X';
            showGameField(gameField);
            result = checkField(gameField);
        } while (result == 0);
        switch (result) {
            case 1:
                System.out.println("Победа X");
                break;
            case 2:
                System.out.println("Победа 0");
                break;
            case 3:
                System.out.println("Ничья");
        }
    }

    //Мы знаем чем мы ходим(Х или 0), но нам надо узнать в какую клетку
    public static void makeMoveRandom(char[][] gameField, char symbol) {//ходы рандомно
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходит " + symbol);
        int n;
        int m;
        int number;
        do {
            number = (int) (Math.random() * 10);
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || gameField[n][m] != ' ');
        gameField[n][m] = symbol;
    }

    public static void makeMove(char[][] gameField, char symbol) {//ход делает user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходите Вы " + symbol);
        int n;
        int m;
        int number;
        do {
            number = scanner.nextInt();
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || gameField[n][m] != ' ');
        gameField[n][m] = symbol;
    }


    public static void showGameField(char[][] gameField) {//показать игровое поле
        System.out.println(gameField[0][0] + "|" + gameField[0][1] + "|" + gameField[0][2]);
        System.out.println("-----");
        System.out.println(gameField[1][0] + "|" + gameField[1][1] + "|" + gameField[1][2]);
        System.out.println("-----");
        System.out.println(gameField[2][0] + "|" + gameField[2][1] + "|" + gameField[2][2]);
    }

    public static int checkField(char[][] gameField) {//проверка
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1]
                    && gameField[i][0] == gameField[i][2]) {
                if (gameField[i][0] == 'X')
                    return 1;
                if (gameField[i][0] == '0')
                    return 2;
            }
            if (gameField[0][i] == gameField[1][i]
                    && gameField[0][i] == gameField[2][i]) {
                if (gameField[0][i] == 'X')
                    return 1;
                if (gameField[0][i] == '0')
                    return 2;
            }
        }
        if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]) {
            if (gameField[0][0] == 'X')
                return 1;
            if (gameField[0][0] == '0')
                return 2;
        }
        if (gameField[2][0] == gameField[1][1] && gameField[2][0] == gameField[0][2]) {
            if (gameField[2][0] == 'X')
                return 1;
            if (gameField[2][0] == '0')
                return 2;
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (gameField[i][j] == ' ')
                    return 0; //Продолжаем

        return 3; //Ничья
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

    }

    public static int[] createRandomArray(int size, int random) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++)
            randomArray[i] = (int) (random * Math.random());
        return randomArray;
    }

    public static void fillByRandom(int a[], int max) {
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (Math.random() * max);
    }
}



    origin  https://github.com/Serginio777/tic-tac-toe1.git