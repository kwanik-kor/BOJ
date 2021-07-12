package bfs;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16397
 * 2. 풀이
 *  - 문제의 조건만 꼼꼼하게 따진다면 큰 무리 없이 풀 수 있음
 *  - BFS 를 이용해 두 가지 조건으로 만들어 질 수 있는 수들을 차근차근 진행함
 */
public class bfs_16397_escape {

    static int N, T, G;

    static int solve() {
        HashSet<Integer> set = new HashSet<>();
        set.add(N);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int cnt = 0;
        while(!q.isEmpty()) {
            if(cnt > T)
                return -1;

            int size = q.size();
            while(size-- > 0) {
                int now = q.poll();
                if(now == G)
                    return cnt;

                int next_1 = now + 1;
                if(next_1 <= 99999 && !set.contains(next_1)) {
                    set.add(next_1);
                    q.add(next_1);
                }

                int next_2 = buttonB(now);
                if(next_2 != -1 && next_2 <= 99999 && !set.contains(next_2)) {
                    set.add(next_2);
                    q.add(next_2);
                }
            }

            cnt++;
        }
        return -1;
    }

    static int buttonB(int no) {
        if(no == 0 || no * 2 > 99999)
            return -1;
        char[] temp = String.valueOf(no * 2).toCharArray();
        temp[0] = (char)(temp[0] - 1);

        return Integer.parseInt(String.valueOf(temp));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        int ans = solve();
        bw.write(ans == -1? "ANG" : ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
