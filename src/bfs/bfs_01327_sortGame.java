package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1327
 * 2. 풀이
 *  -
 */
public class bfs_01327_sortGame {

    static int N, K;

    static int solve(String start) {
        HashSet<String> set = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        set.add(start);
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(isAsc(now.val))
                return now.cnt;

            for(int i = 0; i < N - K + 1; i++) {
                String next = convert(now.val, i);
                if(set.contains(next)) continue;
                set.add(next);
                q.add(new Node(next, now.cnt + 1));
            }

        }

        return -1;
    }

    static String convert(String val, int idx) {
        return val.substring(0, idx) + new StringBuilder(val.substring(idx, idx + K)).reverse().toString() + val.substring(idx + K);
    }

    static boolean isAsc(String val) {
        char[] arr = val.toCharArray();
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] - arr[i + 1] > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder("");
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sb.append(st.nextToken());
        }

        bw.write(solve(sb.toString()) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        String val;
        int cnt;
        public Node(String val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
