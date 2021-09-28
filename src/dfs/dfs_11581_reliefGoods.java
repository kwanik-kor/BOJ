package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11581
 * 2. 풀이
 *  - 방문했던 경로를 취소하지 않고 다시 재방문하게끔 하여 몇번 틀렸다.. 껄껄
 *   - 어떠한 경로를 선택했을 때, Cycle이 존재하는지 여부를 확인하는 문제
 */
public class dfs_11581_reliefGoods {

    static int N;
    static int[] visit;
    static Map<Integer, List<Integer>> edges = new HashMap<>();

    static boolean dfs(int node) {
        if(visit[node] != 0) {
            return visit[node] == -1;
        }
        visit[node] = -1;
        for(Integer next : getNode(node)) {
            if(dfs(next)) return true;
        }
        visit[node] = 1;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        visit = new int[N + 1];
        for(int i = 1; i <= N - 1; i++) {
            int cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n = 0; n < cnt; n++) {
                getNode(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        bw.write(dfs(1)? "CYCLE" : "NO CYCLE");
        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new ArrayList<>());
    }
}
