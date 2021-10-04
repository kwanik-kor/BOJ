package bfs;

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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5248
 * 2. 풀이
 *  - 다시 풀 것, Input ㅈㄴ 귀차나....ㅠㅠㅠㅠㅠㅠ
 */
public class bfs_05248_haulingOre {

    static final int INF = 987654321;
    static final int MAX_NODE = 1000;

    static Map<String, Integer> nodes = new HashMap<>();
    static List<String> nodeNms = new ArrayList<>();

    static int[][] dist = new int[MAX_NODE][MAX_NODE];

    static void floyd() {
        int size = nodeNms.size();

        for(int k = 0; k < size; k++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        if(!line.equals("GRAPH BEGIN"))
            bw.write("BAD INPUT FORMAT");

        for(int i = 0; i < MAX_NODE; i++) {
            for(int j = 0; j < MAX_NODE; j++) {
                dist[i][j] = INF;
                if(i == j)
                    dist[i][j] = 0;
            }
        }

        AtomicInteger nodeIdx = new AtomicInteger();
        while(true) {
            line = br.readLine();
            if(line.equals("GRAPH END"))
                break;

            StringTokenizer st = new StringTokenizer(line);
            List<String> nodeLi = new ArrayList<>();
            while(st.hasMoreTokens()) {
                String nodeNm = st.nextToken();
                nodeLi.add(nodeNm);
                if(!nodes.containsKey(nodeNm))
                    nodeNms.add(nodeNm);
            }

            int a = nodes.computeIfAbsent(nodeLi.get(0), k -> nodeIdx.getAndIncrement());
            for(int i = 1; i < nodeLi.size(); i++) {
                int b = nodes.computeIfAbsent(nodeLi.get(i), k -> nodeIdx.getAndIncrement());
                dist[a][b] = 1;
                dist[b][a] = 1;
            }
        }

        floyd();

        int size = nodeNms.size();
        while(!(line = br.readLine()).equals("")) {
            if(!nodes.containsKey(line))
                continue;

            int idx = nodes.get(line);
            for(int i = 0; i < size; i++) {
                if(dist[idx][i] == 2)
                    bw.write(nodeNms.get(i) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
