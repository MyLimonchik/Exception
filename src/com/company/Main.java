package com.company;

public class Main {

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "178", "0"},
                {"1", "2", "179", "2"},
                {"1", "3", "180", "4"},
                {"1", "2", "181", "8"}};

        try {
            System.out.println(sumElement(array));
        } catch (MyArraySizeException ex) {
            System.out.println("Размер массива какой-то не такой");
        } catch (MyArrayDataException ex) {
            System.out.println("В элементе (" + (ex.i + 1) + ", " + (ex.j + 1) + ") закрался шпиён");
        }

    }

    public static int sumElement(String[][] array) {

        if (array.length != 4) {
            throw new MyArraySizeException();
        }

        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int integer = Integer.parseInt(array[i][j]);
                    sum = sum + integer;
                } catch (RuntimeException ex) {
                    MyArrayDataException myArrayDataException = new MyArrayDataException();
                    myArrayDataException.i = i;
                    myArrayDataException.j = j;
                    throw myArrayDataException;
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends RuntimeException {
}

class MyArrayDataException extends RuntimeException {
    int i;
    int j;
}