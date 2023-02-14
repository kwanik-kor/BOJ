package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backtracking_14534_stringPermutation {

    static char[] line;

    static void permutation(int start, int len, String str, boolean[] visit) {
        if (len == line.length) {
            System.out.println(str);
            return;
        }

        for (int i = 0, n = line.length; i < n; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            permutation(i + 1, len + 1, str + line[i], visit);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            line = br.readLine().toCharArray();

            System.out.printf("Case # %d:\n", i);
            permutation(0, 0, "", new boolean[line.length]);
        }

        br.close();
    }
}
