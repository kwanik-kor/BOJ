package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10471
 */
public class bf_10471_makeArea {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        boolean[] checked = new boolean[w + 1];
        checked[w] = true;
        List<Integer> partition = new ArrayList<>();
        partition.add(0);
        partition.add(w);

        st = new StringTokenizer(br.readLine());
        while (p-- > 0) {
            int position = Integer.parseInt(st.nextToken());
            for (int target : partition) {
                checked[Math.abs(target - position)] = true;
            }
            partition.add(position);
        }

        for (int i = 0; i <= w; i++) {
            if (checked[i]) {
                bw.write(i + " ");
            }
        }
        bw.close();
        br.close();
    }

}
