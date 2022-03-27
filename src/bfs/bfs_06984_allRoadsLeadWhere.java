package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6984
 * 2. 풀이
 *  - 노드간의 이동 경로만 잘 저장해두면 큰 문제 없음
 */
public class bfs_06984_allRoadsLeadWhere {

    static int M, N;
    static char start, end;
    static List<Character>[] adj;

    static String solve() {
        boolean[] visit = new boolean[26];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, String.valueOf(start)));
        visit[start - 'A'] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.city == end)
                return now.path;
            for(Character next : adj[now.city - 'A']) {
                if(visit[next - 'A']) continue;
                visit[next - 'A'] = true;
                q.add(new Node(next, now.path + next));
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        adj = new List[26];
        for(int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            adj[a - 'A'].add(b);
            adj[b - 'A'].add(a);
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = st.nextToken().charAt(0);
            end = st.nextToken().charAt(0);
            String ans = solve();
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        char city;
        String path;

        public Node(char city, String path) {
            this.city = city;
            this.path = path;
        }
    }
}
