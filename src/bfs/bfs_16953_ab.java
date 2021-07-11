package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16953
 * 2. 풀이
 *  - 일단 한 번 틀려버렸다구~(int로 해서 틀림)
 *  - 자료형 좀 꼼꼼히 보고...풀자...
 */
public class bfs_16953_ab {

    static final long max = 1000000000L;
    static long A, B;

    static int solve() {
        Set<Long> set = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 0));
        set.add(A);

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.a == B)
                return now.cnt + 1;

            long next_1 = now.a * 2;
            long next_2 = Long.parseLong(String.valueOf(now.a + "1"));
            if(!set.contains(next_1) && next_1 <= max) {
                set.add(next_1);
                q.add(new Node(next_1, now.cnt + 1));
            }

            if(!set.contains(next_2) && next_2 <= max) {
                set.add(next_2);
                q.add(new Node(next_2, now.cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        if(B % 2 != 0 && B % 10 != 1) {
            bw.write("-1");
        } else {
            bw.write(solve() + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        long a;
        int cnt;
        public Node(long a, int cnt) {
            this.a = a;
            this.cnt = cnt;
        }
    }
}
