package IUPC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String target = "MOBIS";

        boolean result = true;
        for (int i = 0; i < 5; i++) {
            if (line.indexOf(target.charAt(i)) == -1) {
                result = false;
                break;
            }
        }

        bw.write(result ? "YES" : "NO");
        bw.close();
        br.close();
    }

}
