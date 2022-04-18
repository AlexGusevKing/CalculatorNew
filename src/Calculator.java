import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Здравствуйте, вас приветствует умный калькулятор Java!\n" +
                "Он умеет складывать, делить, умножать, и вычитать два целых, арабских и римских числа!\n" +
                "Для этого, необходимо ввести два числа, и знак операции между ними.\n" +
                "\nВведите выражение:");
        String meaning = sc.nextLine();
        sc.close();
        String del = meaning.replaceAll("\\s", "");
        String[] numbersStr = del.split("[\\+\\-\\*\\/]", 2);
        String impOperand = meaning.replaceAll("[\\w\\s]", "");
        char operand = impOperand.charAt(0);
        if (numbersStr.length != 2) {
            throw new Exception("Не удалось распознать введенное выражение");
        } else {
            int[] num1 = conversionIntegerRome(numbersStr[0]);
            int[] num2 = conversionIntegerRome(numbersStr[1]);
            if (num1[0] < 1 || num1[0] > 9 || num2[0] < 1 || num2[0] > 9) {
                throw new Exception("Допустимый диапазон чисел от 1 до 9 как для арабских так и для римских");
            }
            if (num1[1] != num2[1]) {
                throw new Exception("Необходимо ввести либо два римских, либо два арабских числа");
            }
            int rezult = operation(num1[0], num2[0], operand);
            if (rezult < 0)
                System.out.println("Натуральное число не может быть отрицательным.");
            else if (num1[1] == 0)
                System.out.println("Ответ: " + rezult);
            else if (rezult == 0)
                System.out.println("Значение выражения у римских цифр не может равнятся нулю!");
            else
                reverseConversion(rezult);
        }
    }


    public static int[] conversionIntegerRome(String val) {
        switch (val) {
            case "1":
                return new int[]{1, 0};
            case "2":
                return new int[]{2, 0};
            case "3":
                return new int[]{3, 0};
            case "4":
                return new int[]{4, 0};
            case "5":
                return new int[]{5, 0};
            case "6":
                return new int[]{6, 0};
            case "7":
                return new int[]{7, 0};
            case "8":
                return new int[]{8, 0};
            case "9":
                return new int[]{9, 0};
            case "10":
                return new int[]{10, 0};
            case "I":
                return new int[]{1, 1};
            case "II":
                return new int[]{2, 1};
            case "III":
                return new int[]{3, 1};
            case "IV":
                return new int[]{4, 1};
            case "V":
                return new int[]{5, 1};
            case "VI":
                return new int[]{6, 1};
            case "VII":
                return new int[]{7, 1};
            case "VIII":
                return new int[]{8, 1};
            case "IX":
                return new int[]{9, 1};
            case "X":
                return new int[]{10, 1};
            default:
                return new int[]{0, 0};
        }
    }

    public static int operation(int numbers1, int numbers2, char operand) {
        switch (operand) {
            case '+':
                return numbers1 + numbers2;
            case '-':
                return numbers1 - numbers2;
            case '*':
                return numbers1 * numbers2;
            default:
                return numbers1 / numbers2;
        }
    }

    public static void reverseConversion(int res) {
        String rome = "";
        if (res >= 90 && res < 100) {
            rome += "XC";
            res -= 90;
            rome += rezultRomeDo10(res);
        } else if (res >= 50 && res < 90) {
            rome += "L";
            res -= 50;
            for (int i = 0; i < res / 10; i++)
                rome += "X";
            rome += rezultRomeDo10(res % 10);
        } else if (res >= 40 && res < 50) {
            rome += "XL";
            res -= 40;
            rome += rezultRomeDo10(res);
        } else if (res < 40) {
            for (int i = 0; i < res / 10; i++)
                rome += "X";
            rome += rezultRomeDo10(res % 10);
        } else if (res == 100)
            rome += "C";
        System.out.println("Ответ: " + rome);
    }

    public static String rezultRomeDo10(int res) {
        String rezultRomeDo10 = "";
        if (res > 0 && res < 3)
            for (int i = 0; i < res; i++)
                rezultRomeDo10 += "I";
        if (res == 4)
            rezultRomeDo10 += "IV";
        if (res >= 5 && res < 9) {
            rezultRomeDo10 += "V";
            res -= 5;
            if (res > 0 && res < 3)
                for (int i = 0; i < res; i++)
                    rezultRomeDo10 += "I";
        }
        if (res == 9)
            rezultRomeDo10 += "IX";
        return rezultRomeDo10;


    }
}
