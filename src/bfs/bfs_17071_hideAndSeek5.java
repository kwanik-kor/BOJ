package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17071
 * 2. 풀이
 *  - 단순히 visit 방문 처리 없이 bfs를 돌렸더니 당연하게도 메모리 초과가 났다.
 *  - 그 말인즉슨, 어떻게든 방문처리를 해줘야 한다는 것인데,
 *    짝수번째에 도착한 노드는 다시 짝수번째에 갈 수 있기 때문에(+1, -1) 홀,짝으로 방문처리를 했더니 통과
 */
public class bfs_17071_hideAndSeek5 {

    static final int MAX = 500000;
    static int N;

    static int[][] visit;

    static void bfs() {
        int time = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int now = q.poll();
                if(now < 0 || MAX < now || visit[now][time % 2] != -1) continue;
                visit[now][time % 2] = time;
                q.add(now - 1);
                q.add(now + 1);
                q.add(now * 2);
            }

            time++;
        }
    }

    static int solve(int k) {
        for(int i = 0; i < MAX; i++) {
            k += i;
            if(MAX < k)
                break;
            if(visit[k][i % 2] != -1 && visit[k][i % 2] <= i)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visit = new int[MAX + 1][2];
        for(int i = 0; i < MAX + 1; i++)
            Arrays.fill(visit[i], -1);

        bfs();

        bw.write(solve(k) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
