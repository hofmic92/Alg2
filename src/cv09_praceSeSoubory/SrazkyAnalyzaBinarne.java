package cv09_praceSeSoubory;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SrazkyAnalyzaBinarne {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Zadej cestu k souboru");
        String jmSoub = sc.nextLine();
        try(DataInputStream dis = new DataInputStream(
                new FileInputStream(jmSoub))) {
            boolean konceSouboru = false;
            while(!konceSouboru) {
                try {
                    byte den = dis.readByte();
                    byte mesic = dis.readByte();
                    short rok = dis.readShort();
                    float srazky = dis.readFloat();
                    System.out.format("%d %d %d  %f %n", den, mesic, rok, srazky);
                } catch (EOFException ex) {
                    konceSouboru = true;
                }
            }
        }
    }
}
