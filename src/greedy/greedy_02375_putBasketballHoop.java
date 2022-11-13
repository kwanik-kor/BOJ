package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2375
 */
public class greedy_02375_putBasketballHoop {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] xArr = new int[N][2];
        int[][] yArr = new int[N][2];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            xArr[i][0] = x;
            xArr[i][1] = c;
            yArr[i][0] = y;
            yArr[i][1] = c;
            cnt += c;
        }

        sort(xArr);
        sort(yArr);

        cnt += (cnt % 2 == 0) ? 0 : 1;
        int pivot = cnt / 2;

        int[] flag = new int[2];
        int[] ret = new int[2];

        for (int i = 0; i < N; i++) {
            if (flag[0] >= pivot && flag[1] >= pivot) {
                break;
            }

            if (flag[0] < pivot) {
                flag[0] += xArr[i][1];
                if (flag[0] >= pivot) {
                    ret[0] = xArr[i][0];
                }
            }

            if (flag[1] < pivot) {
                flag[1] += yArr[i][1];
                if (flag[1] >= pivot) {
                    ret[1] = yArr[i][0];
                }
            }
        }

        bw.write(ret[0] + " " + ret[1]);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void sort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }
}
