package cv09_praceSeSoubory;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Scanner;

public class SrazkyZaznamBinarne {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Zadej cestu k souboru");
        String jmSoub = sc.nextLine();
        System.out.println("Zadej: den, mesic, rok a srazky");
        byte den = sc.nextByte();
        byte mesic = sc.nextByte();
        short rok = sc.nextShort();
        float srazky = sc.nextFloat();

        try(DataOutputStream dos = new DataOutputStream(
                //append prida vice dat
                new FileOutputStream(jmSoub, true))) {
            dos.writeByte(den);
            dos.writeByte(mesic);
            dos.writeShort(rok);
            dos.writeFloat(srazky);
        }


    }
}
