
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class URLBuilder {

    public static String buildURL(String baseURL, String params) {
        StringBuilder sb = new StringBuilder(baseURL);
        String[] pairs = params.split("&");
        for (int i = 0; i < pairs.length; i++) {
            String[] keyValue = pairs[i].split("=");
            if (!"null".equals(keyValue[1])) {
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(keyValue[0]).append("=").append(keyValue[1]);
            }
        }
        return sb.toString();
    }
}

class CSVGenerator {

    public static String generateCSV(String[] headers, String[][] data) {
        StringBuilder csv = new StringBuilder();
        // Добавление заголовков
        csv.append(String.join(",", headers)).append("\n");
        // Добавление данных
        for (String[] row : data) {
            csv.append(String.join(",", row)).append("\n");
        }
        return csv.toString().trim(); // Удалить последнюю новую строку
    }
}

class TextCleaner {

    public static String removeEmptyLines(String text) {
        String[] lines = text.split("\n");
        StringBuilder cleanedText = new StringBuilder();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                if (cleanedText.length() > 0) {
                    cleanedText.append("\n");
                }
                cleanedText.append(line);
            }
        }
        return cleanedText.toString();
    }

}

class ArrayOperations {

    private static File log;
    private static FileWriter fileWriter;

    public void findMinMax(int[] arr) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
            int min = arr[0];
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
                logStep(min, max);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void logStep(int min, int max) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String timestamp = dateFormat.format(new Date());
            fileWriter.write(timestamp + " " + min + ", " + max
                    + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer2 {

    /*Задание 1. Формирование URL с параметрами
        public static void main(String[] args) {
            String baseURL = "";
            String params = "";
            if (args.length == 0) {
                baseURL = "https://example.com/search?";
                params = "query=java&sort=desc&filter=null";
            } else {
                baseURL = args[0];
                params = args[1];
            }
            URLBuilder ans = new URLBuilder();
            System.out.println(ans.buildURL(baseURL, params));
        } */
 /*Задача 2. Создание CSV-строки из массива объектов 
        public static void main(String[] args)  {
            String[] headers = {};
            String[][] data = {};
            if (args.length == 0) {
                headers = new String[]{"Name", "Age", "City"};
                data = new String[][]{
                    {"John", "30", "New York"},
                    {"Alice", "25", "Los Angeles"},
                    {"Bob", "35", "Chicago"}
                };
            } else {
                // Преобразование строковых параметров в массивы
                // Пример обработки данных можно дополнить в зависимости от формата args
            }
            CSVGenerator ans = new CSVGenerator();
            System.out.println(ans.generateCSV(headers, data));
        }*/
 /*Задача 3. Удаление пустых строк из текста 
        public static void main(String[] args) {
            String text = "";
            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры 
    
                text = "line1\n\nline2\n\nline3";
            } else {
                text = args[0];
            }
            TextCleaner ans = new TextCleaner();
            System.out.println(ans.removeEmptyLines(text));
        }*/
 /*Задача 4. Логирование операций с массивом во время поиска минимального и максимального элементов */
    public static void main(String[] args) {
        int[] arr = {};
        if (args.length == 0) {
            arr = new int[]{9, 4, 8, 3, 1};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        ArrayOperations ans = new ArrayOperations();
        ans.findMinMax(arr);
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
