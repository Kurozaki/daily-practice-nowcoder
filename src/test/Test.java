package test;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int t = sc.nextInt();

            String[] urls = new String[t];
            int size = 0;
            int pos = -1;

            for (int i = 0; i < t; i++) {

                String action = sc.next();
                String out = "ignore";

                switch (action) {
                    case "VISIT":
                        String url = sc.next();
                        urls[++pos] = url;
                        size = pos + 1;
                        out = url;
                        break;

                    case "BACK":
                        if (pos > 0) {
                            out = urls[--pos];
                        }
                        break;

                    case "FORWARD":
                        if (pos < size - 1) {
                            out = urls[++pos];
                        }
                        break;
                }
                System.out.println(out);
            }
        }
    }

}