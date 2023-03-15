import java.util.Scanner;

public class RomainCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пример формата 1 + 1 или I + I(числа от 1 до 10)");
        String input = scan.nextLine();
        scan.close();
        System.out.println(calc(input));
    }
    static String calc(String input) {
        String[] inputSplit = input.split(" ");
        if (inputSplit.length != 3) {
            throw new IllegalArgumentException("Операции только с 2 числами");
        }
        String operation = inputSplit[1];
        int a, b;
        boolean isArabian = false;
        try {
            Converter.ConvertToArab(inputSplit[0]);
        } catch (IllegalArgumentException e) {
            isArabian = true;
        }
        if (isArabian) {
            a = Integer.parseInt(inputSplit[0]);
            b = Integer.parseInt(inputSplit[2]);
        } else {
            a = Converter.ConvertToArab(inputSplit[0]);
            b = Converter.ConvertToArab(inputSplit[2]);
        }

        if (1 <= a && a <= 10 && 1 <= b && b <= 10) {
            int result;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неправильная операция");
            }
            if(isArabian){
                return Integer.toString(result);
            } else {
                return Converter.ConvertToRoma(result);
            }
        }
        else {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
    }
}