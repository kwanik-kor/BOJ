package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1864
 */
public class sml_01864_octopusNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }

            char[] arr = line.toCharArray();
            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans += Octopus.getNumber(arr[i], arr.length - 1 - i);
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static enum Octopus {
        ZERO('-', 0),
        ONE('\\', 1),
        TWO('(', 2),
        THREE('@', 3),
        FOUR('?', 4),
        FIVE('>', 5),
        SIX('&', 6),
        SEVEN('%', 7),
        MINUS('/', -1);

        char text;
        int num;

        Octopus(char text, int num) {
            this.text = text;
            this.num = num;
        }

        public char getText() {
            return text;
        }

        public int getNum() {
            return num;
        }

        static long getNumber(char c, int pos) {
            Octopus type = null;
            for (Octopus o : Octopus.values()) {
                if (o.getText() == c) {
                    type = o;
                    break;
                }
            }

            return type.getNum() * ((long) Math.pow(8, pos));
        }
    }
}
