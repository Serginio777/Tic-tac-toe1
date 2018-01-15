package com.devcolibri;


import java.util.Scanner;

public class krestiki_noliki {

    public static final int CONTINUE = 0;
    public static final int WIN_1 = 1;
    public static final int WIN_2 = 2;
    public static final int DRAW = 3;

    public static final char PLAYER_1 = '+';
    public static final char PLAYER_2 = '-';
    public static final char EMPTY = '@';

    public static void main(String[] args) {
        char[][] gameField = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
        showGameField(gameField);
        int result;
        char symbol = PLAYER_1;
        do {
            makeMove(gameField, symbol);
            symbol = symbol == PLAYER_1 ? PLAYER_2 : PLAYER_1;
            showGameField(gameField);
            result = checkField(gameField);
        } while (result == CONTINUE);
        showResult(result);
    }

    public static void makeMoveRandom(char[][] gameField, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходит " + symbol);
        int n;
        int m;
        int number;
        do {
            number = (int) (Math.random() * 10);
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || gameField[n][m] != EMPTY);
        gameField[n][m] = symbol;
    }

    public static void makeMove(char[][] gameField, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходит " + symbol);
        int n;
        int m;
        int number;
        do {
            number = scanner.nextInt();
            n = 2 - (number - 1) / 3;
            m = (number - 1) % 3;
        } while (number < 1 || number > 9 || gameField[n][m] != EMPTY);
        gameField[n][m] = symbol;
    }


    public static void showGameField(char[][] gameField) {
        System.out.println(gameField[0][0] + "|" + gameField[0][1] + "|" + gameField[0][2]);
        System.out.println("-----");
        System.out.println(gameField[1][0] + "|" + gameField[1][1] + "|" + gameField[1][2]);
        System.out.println("-----");
        System.out.println(gameField[2][0] + "|" + gameField[2][1] + "|" + gameField[2][2]);
    }

    public static int checkField(char[][] gameField) {
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1]
                    && gameField[i][0] == gameField[i][2]) {
                if (gameField[i][0] == PLAYER_1)
                    return WIN_1;
                if (gameField[i][0] == PLAYER_2)
                    return WIN_2;
            }
            if (gameField[0][i] == gameField[1][i]
                    && gameField[0][i] == gameField[2][i]) {
                if (gameField[0][i] == PLAYER_1)
                    return WIN_1;
                if (gameField[0][i] == PLAYER_2)
                    return WIN_2;
            }
        }
        if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]) {
            if (gameField[0][0] == PLAYER_1)
                return WIN_1;
            if (gameField[0][0] == PLAYER_2)
                return WIN_2;
        }
        if (gameField[2][0] == gameField[1][1] && gameField[2][0] == gameField[0][2]) {
            if (gameField[2][0] == PLAYER_1)
                return WIN_1;
            if (gameField[2][0] == PLAYER_2)
                return WIN_2;
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (gameField[i][j] == EMPTY)
                    return CONTINUE;

        return DRAW;
    }

    public static void showResult(int result) {
        switch (result) {
            case WIN_1:
                System.out.println("Победа 1");
                break;
            case WIN_2:
                System.out.println("Победа 2");
                break;
            case DRAW:
                System.out.println("Ничья");
        }
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



