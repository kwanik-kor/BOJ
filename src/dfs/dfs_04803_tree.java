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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4803
 * 2. 풀이
 *  - 트리 그룹 별로 노드에 대한 탐색과 간선에 대한 탐색을 같이 진행한다.
 *  - 정상적인 트리 구조라면 간선의 개수는 N - 1개 여야 함.
 *   > 단, 간선은 두 번 씩 카운트 되기 때문에 (1/2) 처리 해줘야 함
 */
public class dfs_04803_tree {

    static int N, M;
    static boolean[] visitNode, visitEdge;
    static List<Integer>[] edges;

    static int searchNode(int node) {
        int ret = 1;
        visitNode[node] = true;

        for(Integer next : edges[node]) {
            if(!visitNode[next])
                ret += searchNode(next);
        }

        return ret;
    }

    static int searchEdge(int node) {
        int ret = edges[node].size();
        visitEdge[node] = true;

        for(Integer next : edges[node]) {
            if(!visitEdge[next])
                ret += searchEdge(next);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int caseNo = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            edges = new List[N + 1];
            visitNode = new boolean[N + 1];
            visitEdge = new boolean[N + 1];
            for(int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges[a].add(b);
                edges[b].add(a);
            }

            int result = 0;
            for(int i = 1; i <= N; i++) {
                if(!visitNode[i]) {
                    int searchResult = searchNode(i);
                    int searchResult2 = searchEdge(i);
                    if(searchResult - 1 == searchResult2 / 2)
                        result++;
                }

            }

            bw.write(String.format("Case %d: %s\n",
                    caseNo,
                    result == 0? "No trees." : (result == 1? "There is one tree." : String.format("A forest of %d trees.", result))));
            caseNo++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
