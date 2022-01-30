package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12319
 * 2. 풀이
 *  - 최종적으로 움직여야할 스텝 수를 미리 계산하여, 역산하는 작업
 */
public class greedy_12319_pogoSmall {

    static String solve(int x, int y) {
        int step = calcStep(x, y);

        StringBuilder sb = new StringBuilder("");
        while(step > 0) {
            if(Math.abs(x) > Math.abs(y)) {
                if(x > 0) {
                    sb.append('E');
                    x -= step;
                } else {
                    sb.append('W');
                    x += step;
                }
            } else {
                if(y > 0) {
                    sb.append('N');
                    y -= step;
                } else {
                    sb.append('S');
                    y += step;
                }
            }
            step--;
        }
        return sb.reverse().toString();
    }

    static int calcStep(int x, int y) {
        int s = 0;
        int dist = 0;
        while(dist < Math.abs(x) + Math.abs(y) || (dist + x + y) % 2 == 1) {
            s++;
            dist += s;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        IntStream.rangeClosed(1, T)
                .forEach(idx -> {
                    try {
                        StringTokenizer st = new StringTokenizer(br.readLine());
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());

                        bw.write(String.format("Case #%d: %s\n", idx, solve(x, y)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.flush();
        bw.close();
        br.close();
    }
}
