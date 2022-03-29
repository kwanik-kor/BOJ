package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1525
 * 2. 풀이
 *  - 빈 칸에 대해서 9로 처리한 후, 해당 형태가 나타날 떄까지 BFS를 수행해준다.
 */
public class bfs_01525_puzzle {

    static final String ARRIVAL = "123456789";

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int solve(int start) {
        int cnt = 0;

        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit.add(start);

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                String now = String.valueOf(q.poll());
                if(now.equals(ARRIVAL))
                    return cnt;
                int pos = now.indexOf('9');
                int y = pos / 3;
                int x = pos % 3;

                for(int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(ny < 0 || nx < 0 || 3 <= ny || 3 <= nx) continue;

                    int nextPos = ny * 3 + nx;
                    char[] arr = now.toCharArray();
                    arr[pos] = arr[nextPos];
                    arr[nextPos] = '9';
                    int next = Integer.parseInt(String.valueOf(arr));
                    if(visit.contains(next)) continue;
                    visit.add(next);
                    q.add(next);
                }
            }

            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int start = 0;
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                int no = Integer.parseInt(st.nextToken());
                if(no == 0)
                    no = 9;
                start = start * 10 + no;
            }
        }

        bw.write(solve(start) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
