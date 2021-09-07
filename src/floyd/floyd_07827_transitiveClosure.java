package floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  1. 문제 링크 : https://www.acmicpc.net/problem/7827
 *  2. 풀이
 *   - 문제의 풀이 방식은 간단하나, 아래의 케이스로 풀이하였을 때 틀렸었음
 *    > 무지성 플로이드-와샬 : 테스트 케이스 && 최대 노드 개수 를 보면 최대 6850만 번의 연산을 조져야함... 최단거리를 구할 필요가 없기 때문에 dfs로 선회
 *    > DFS with Map<Integer, Set<Integer>> : 메모리 초과... 배열로 선회..
 */
public class floyd_07827_transitiveClosure {

    static int N, M;
    static boolean[] visit;
    static List<Integer>[] edges;

    static void dfs(int n) {
        visit[n] = true;
        for(Integer next : edges[n]) {
            if(!visit[next])
                dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new List[N];
            for(int i = 0; i < N; i++)
                edges[i] = new ArrayList<>();

            visit = new boolean[N];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                edges[a].add(b);
            }

            int ans = 0;
            for(int i = 0; i < N; i++) {
                Arrays.fill(visit, false);
                dfs(i);
                for(int n = 0; n < N; n++) {
                    if(i != n && visit[n])
                        ans++;
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
