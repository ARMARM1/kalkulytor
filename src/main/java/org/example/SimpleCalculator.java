package org.example;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение (например, 5 + 3):");
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                throw new IllegalArgumentException("Некорректный формат ввода. Используйте пример: a + b");
            }

            int num1 = Integer.parseInt(tokens[0]);
            char operator = tokens[1].charAt(0);
            int num2 = Integer.parseInt(tokens[2]);

            validateInput(num1, num2);

            int result = performOperation(num1, num2, operator);
            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Введите целые числа от 1 до 10.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка: Деление на ноль.");
        }
    }

    private static void validateInput(int num1, int num2) {
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }
    }

    private static int performOperation(int num1, int num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                return num1 / num2;

             default:
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);}
        }

    }



