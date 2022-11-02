package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4436
 */
public class bf_04436_elfSword {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";
        while ((line = br.readLine()) != null && !line.equals("")) {
            int k = 1;
            long n = Long.parseLong(line);

            boolean[] flag = new boolean[10];
            while (!isComplete(flag)) {
                long tmp = k * n;
                while (tmp > 0) {
                    flag[(int) (tmp % 10)] = true;
                    tmp /= 10;
                }
                k++;
            }

            bw.write(k - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isComplete(boolean[] flag) {
        for (int i = 0; i < 10; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        return true;
    }
}
