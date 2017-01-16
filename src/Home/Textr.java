package Home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Textr {
    public static void main(String[] args) {
        long t1, t2;
        String someText = "Simple Java programm - Hello World"; // Создание строки и разбивка на токены
        String[] someTextTokens = someText.split(" ");
        for (int i = 0; i < someTextTokens.length; i++) {
            System.out.println(someTextTokens[i]);
        }

        int justInt = 2;
        // =============== Сравнение скорости работы String и StringBuilder
        final int TEST_COUNT = 15000;
        t1 = System.currentTimeMillis();
        String h = "Hello";
        for (int i = 0; i < TEST_COUNT; i++) {
            h += "1" + justInt + "2";
            if (h.length() > 1800) h = "Hello";
        }
        t2 = System.currentTimeMillis();
        System.out.println("String Time: " + (t2 - t1));

        t1 = System.currentTimeMillis();
        StringBuilder h2 = new StringBuilder("Hello");
        for (int i = 0; i < TEST_COUNT; i++) {
            h2.append("1");
            h2.append(justInt);
            h2.append("2");
            if (h.length() > 1800) h2 = new StringBuilder("Hello");
        }
        t2 = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (t2 - t1));

        readFileTest();
        writeStringToFileTest(someText);
    }

    public static void readFileTest() {
        System.out.println("================ READ TEST ==================");
        int i;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("1.txt");
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
            fin.close();
        } catch (IOException е) {
            System.out.println("Произошла ошибкa чтения файла");
        }
        System.out.println("==========================================");
    }

    public static void writeStringToFileTest(String text) {
        System.out.println("================ WRITE TEST =================");
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("out.txt");
            for (int i = 0; i < text.length(); i++) {
                fout.write(text.charAt(i));
            }
            if (fout != null) fout.close();
        } catch (IOException е) {
            System.out.println("Произошла ошибка при записи в файл");
        }
        System.out.println("=============================================");
    }


}
