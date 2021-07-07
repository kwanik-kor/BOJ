package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12886
 * 2. 풀이
 *   - 돌 두 개의 개수가 정해지면 나머지 하나는 자연스럽게 정해지는 것을 기반으로
 *     visit 배열 생성
 *   - 세 개의 그룹이 모두 개수가 같으려면 총 합이 3의 배수여야 함.
 *    > 3의 배수가 아닌 경우에는 일찌감치 제외하고 시작
 */
public class bfs_12886_stoneGroup {

    static int sum;
    static boolean[][] visit = new boolean[1501][1501];

    static boolean solve(Stone start) {
        Queue<Stone> q = new LinkedList<Stone>();
        q.add(start);
        visit[start.a][start.b] = true;

        while(!q.isEmpty()) {
            Stone now = q.poll();
            int[] arr = {now.a, now.b, sum - now.a - now.b};
            if(arr[0] == arr[1] && arr[1] == arr[2])
                return true;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i == j) continue;
                    if(arr[i] < arr[j]) {
                        int next_a = arr[i] + arr[i];
                        int next_b = arr[j] - arr[i];
                        if(visit[next_a][next_b]) continue;
                        visit[next_a][next_b] = true;
                        q.add(new Stone(next_a, next_b));
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        sum = a + b + c;

        if(sum % 3 != 0) {
            bw.write("0");
        } else {
            bw.write(solve(new Stone(a, b))? "1" : "0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Stone {
        int a;
        int b;
        public Stone(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
