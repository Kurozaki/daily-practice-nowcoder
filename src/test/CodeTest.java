package test;

import java.io.File;
import java.io.FileWriter;

public class CodeTest {
    public static void main(String[] args) throws Exception {
        File f = new File("data.txt");

        FileWriter fw = new FileWriter(f);

        for (int i = 0; i < 100000; i++) {

            fw.write("0 ");
        }
        fw.close();
    }
}