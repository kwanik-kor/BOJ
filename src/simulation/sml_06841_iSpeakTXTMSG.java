package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6841
 */
public class sml_06841_iSpeakTXTMSG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line.equals("TTYL")) {
                bw.write("talk to you later");
                break;
            }
            switch (line) {
                case "CU": bw.write("see you\n"); break;
                case ":-)": bw.write("I’m happy\n"); break;
                case ":-(": bw.write("I’m unhappy\n"); break;
                case ";-)": bw.write("wink\n"); break;
                case ":-P": bw.write("stick out my tongue\n"); break;
                case "(~.~)": bw.write("sleepy\n"); break;
                case "TA": bw.write("totally awesome\n"); break;
                case "CCC": bw.write("Canadian Computing Competition\n"); break;
                case "CUZ": bw.write("because\n"); break;
                case "TY": bw.write("thank-you\n"); break;
                case "YW": bw.write("you’re welcome\n"); break;
                default: bw.write(line + "\n");
            }
        }
        bw.close();
        br.close();
    }

}
