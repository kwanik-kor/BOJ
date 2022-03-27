package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5786
 */
public class bfs_05786_spam {

    static StringTokenizer st;

    static int N, T;
    static List<Integer>[] adj;
    static Set<Integer> starts;
    static int[][] standard;
    static String[][] attr;
    static String[] names;

    static int[][] cnt;

    static void bfs(int startNode) {
        boolean[] visit = new boolean[N];

        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visit[startNode] = true;
        while(!q.isEmpty()) {
            Integer now = q.poll();
            cnt[startNode][now] = adj[now].size();
            for(Integer next : adj[now]) {
                if(visit[next]) continue;
                visit[next] = true;
                q.add(next);
            }
        }
    }

    static String getAttr(int idx, int start, int t) {
        int send = cnt[start][idx];
        return send < standard[t][1] ? attr[t][0] : (standard[t][2] <= send ? attr[t][2] : attr[t][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            adj = new List[N];
            for(int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }

            // 인접 노드 Input 처리
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    int node = Integer.parseInt(st.nextToken());
                    if(node == 0) break;
                    adj[i].add(node - 1);
                }
            }

            // 설정 정보 추가
            List<String> lines = new ArrayList<>();
            while(true) {
                String line = br.readLine();
                if(line.equals("0")) break;
                lines.add(line);
            }
            T = lines.size();

            names = new String[N];
            for(int i = 0; i < N; i++) {
                names[i] = br.readLine();
            }

            attr = new String[T][3];
            standard = new int[T][3];
            starts = new HashSet<>();
            IntStream.range(0, lines.size()).forEach(idx -> {
                st = new StringTokenizer(lines.get(idx));
                for(int i = 0; i < 3; i++) {
                    standard[idx][i] = Integer.parseInt(st.nextToken());
                    if(i == 0) standard[idx][i]--;
                }
                starts.add(standard[idx][0]);
                for(int i = 0; i < 3; i++) {
                    attr[idx][i] = st.nextToken();
                }
            });

            // solve
            cnt = new int[N][N];
            for(Integer start : starts)
                bfs(start);

            for(int i = 0; i < N; i++) {
                bw.write(names[i] + ": ");
                for(int t = 0; t < T; t++) {
                    bw.write(getAttr(i, standard[t][0], t) + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
