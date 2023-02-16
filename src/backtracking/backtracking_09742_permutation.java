package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class backtracking_09742_permutation {

    static int[] fact = new int[11];

    static char[] arr, chars;
    static boolean[] visit;
    static int n, cnt;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        calcFactorial();

        String line = "";
        while ((line = br.readLine()) != null && !line.equals("")) {
            bw.write(String.format("%s = ", line));

            StringTokenizer st = new StringTokenizer(line);
            arr = st.nextToken().toCharArray();
            n = Integer.parseInt(st.nextToken());

            cnt = 0;
            visit = new boolean[arr.length];
            chars = new char[arr.length];

            if (n > fact[arr.length]) {
                bw.write("No permutation\n");
            } else {
                bw.write(solveWithBacktracking() + "\n");
            }
        }

        bw.close();
        br.close();
    }

    static void calcFactorial() {
        fact[0] = 1;
        for (int i = 1; i <= 10; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    static String solveWithBacktracking() {
        cnt = 0;
        visit = new boolean[arr.length];
        chars = new char[arr.length];

        backtracking(0);

        return ans;
    }

    static void backtracking(int len) {
        if (len == arr.length) {
            cnt++;
            if (cnt == n) {
                ans = new String(chars);
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            chars[len] = arr[i];
            backtracking(len + 1);
            visit[i] = false;
        }
    }
}
