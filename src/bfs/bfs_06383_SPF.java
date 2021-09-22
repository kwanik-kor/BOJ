package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6383
 * 2. 풀이
 *  - Brute Force로 각 노드가 사라졌을 경우, 나눠지게 되는 구역의 개수를 판단한다.
 *    - 이 때, 2개 이상의 구역으로 분할되게 되는 경우 답안에 추가함
 */
public class bfs_06383_SPF {

    static List<Integer>[] edges;
    static Set<Integer> nodes;
    static Set<Integer> visit;

    static HashMap<Integer, Integer> ans = new HashMap<>();
    static StringBuilder ansStr = new StringBuilder();

    static void setArea(int start, int spf) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit.add(start);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : edges[now]) {
                if(visit.contains(next) || next == spf) continue;
                visit.add(next);
                q.add(next);
            }
        }
    }

    static void solve(int n) {
        ans = new HashMap<>();

        for(Integer SPF : nodes) {
            int area = 0;
            visit = new HashSet<>();
            for(Integer node : nodes) {
                if(node != SPF && !visit.contains(node)) {
                    setArea(node, SPF);
                    area++;
                }
            }
            if(1 < area)
                ans.put(SPF, area);
        }

        ansStr.append(String.format("Network #%d\n", n));
        if(ans.isEmpty()) {
            ansStr.append("  No SPF nodes\n\n");
        } else {
            for(Integer key : ans.keySet()) {
                ansStr.append(String.format("  SPF node %d leaves %d subnets\n", key, ans.get(key)));
            }
            ansStr.append("\n");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int network = 1;
        while(true) {
            String line = "";
            int nodeCnt = 0;
            init();

            while(true) {
                line = br.readLine();
                if(line.equals("0"))
                    break;
                StringTokenizer st = new StringTokenizer(line);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges[a].add(b);
                edges[b].add(a);
                nodes.add(a);
                nodes.add(b);

                nodeCnt++;
            }

            if(nodeCnt == 0)
                break;

            // Solution down here
            solve(network);

            network++;
            br.readLine();
        }
        bw.write(ansStr.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        edges = new List[1001];
        nodes = new HashSet<>();
        for(int i = 1; i <= 1000; i++) {
            edges[i] = new ArrayList<>();
        }
    }
}
