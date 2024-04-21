package cv09_praceSeSoubory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class ZapisTextuVZadanemKodovani {
    private static final Scanner sc = new Scanner(System.in);
    private static final String text = "čéfrjčéí jfýřčáéí";
    private static final String EOLN = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println("Delka textu " + text.length());
        String jmSoub = "acp";
        try(BufferedWriter bw = new BufferedWriter(
                new FileWriter(jmSoub, Charset.forName("CP1250")))) {
            bw.write(text);
        }

        jmSoub = "auni";
        try(BufferedWriter bw = Files.newBufferedWriter(Path.of(jmSoub), Charset.forName("UNICODE"), StandardOpenOption.CREATE_NEW)) {
            bw.write(text);
        }

        jmSoub = "aut";
        Files.writeString(Path.of(jmSoub), text, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);

        jmSoub = "bcp";
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(jmSoub), "CP1250"))) {
            bw.write(text);
        }

        jmSoub = "ccp";
        try(PrintWriter pw = new PrintWriter(jmSoub, "CP1250")) {
            pw.write(text);
        }


    }
}
