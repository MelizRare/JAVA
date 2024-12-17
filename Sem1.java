class Answer {

    public int factorial(int n) {
        // Введите свое решение ниже
        if (n < 0) {
            return -1;
        }
        //Если число n<0, метод должен вернуть - 1(проверка на отрицацтельное число)
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i;
        }
        //Факториал 0 и 1 - равен 1, поэтому с i=2
        return res;
    }

    public static void printEvenNums() {
        // Напишите свое решение ниже
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            //Четное число — это число, которое делится на 2 без остатка. Например, если n % 2 == 0, то n является четным.
        }
    }

    public int sumDigits(int n) {
        // Введите свое решение ниже
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        //Чтобы получить последнюю цифру числа, используйте оператор остатка от деления. Например, n % 10 вернет последнюю цифру числа n.
        return sum;

    }

    // Функция для нахождения максимума из двух чисел
    public int findMaxOfTwo(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Функция для нахождения максимума из трех чисел
    public int findMaxOfThree(int a, int b, int c) {
        return findMaxOfTwo(findMaxOfTwo(a, b), c);
    }

}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class Printer {

    /**
     * Для задания 1. Нахождение факториала числа public static void
     * main(String[] args) { int n = 0; if (args.length > 0) { n =
     * Integer.parseInt(args[0]); } // Вывод результата на экран Answer ans =
     * new Answer(); int itresume_res = ans.factorial(n);
     * System.out.println(itresume_res); }
     */
    /**
     * Для задания 2. Вывод всех четных чисел от 1 до 100
     *
     * public static void main(String[] args) { Answer ans = new Answer();
     * ans.printEvenNums(); }
     */
    /**
     * Для задания 3. Подсчет суммы цифр числа public static void main(String[]
     * args) { int n = 12345; if (args.length > 0) { n =
     * Integer.parseInt(args[0]); } // Вывод результата на экран Answer ans =
     * new Answer(); int itresume_res = ans.sumDigits(n);
     * System.out.println(itresume_res); }
     */
    /**
     * Для задания 4*. Нахождение максимального из трех чисел
     */
    public static void main(String[] args) {
        int a = 5, b = 10, c = 3;
        if (args.length == 3) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            c = Integer.parseInt(args[2]);
        }
        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.findMaxOfThree(a, b, c);
        System.out.println(itresume_res);
    }

}
