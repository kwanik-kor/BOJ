package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1068
 * 2. 풀이
 *  - Top Down으로 최상위 노드부터 아래쪽으로 탐색을 진행하되, DP를 이용해 리프노드의 개수를 역으로 count-up 해온다.
 *
 *  - 단, 리프노드가 되기 위한 조건이 중요하다..!!
 *   1) 현재 노드에서 더 이상 자식 노드가 없다.
 *   2) 현재 노드에 자식 노드가 하나 있지만, 해당 노드는 지워질 노드다.
 *      > 즉, 현재 노드가 리프노드가 되는 상황
 *      
 *  - 요거 조건만 잘 맞춰서 Recursive 로 풀어주면됨!
 */
public class dfs_01068_tree {

    static int N, TOP, DELETED;
    static int[] cnt;
    static List<Integer>[] edges;

    static void solve(int n) {
        if(n == DELETED)
            return;

        if(edges[n].isEmpty()
                || (edges[n].size() == 1 && edges[n].get(0) == DELETED)) {
            cnt[n] = 1;
            return;
        }

        for(Integer child : edges[n]) {
            solve(child);
            cnt[n] += cnt[child];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        cnt = new int[N];
        edges = new List[N];
        for(int i = 0; i < N; i++)
            edges[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int node = 0; node < N; node++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1)
                TOP = node;
            else
                edges[parent].add(node);
        }

        DELETED = Integer.parseInt(br.readLine());

        solve(TOP);

        bw.write(cnt[TOP] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
