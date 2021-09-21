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

public class bfs_6383_SPF {

    static List<Integer>[] edges;
    static Set<Integer> nodes;
    static Set<Integer> visit;

    static HashMap<Integer, Integer> ans = new HashMap<>();

    static void setArea(int start, int spf) {
        System.out.println(start);
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

    static void solve() {
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
            solve();

            System.out.printf("Network #%d\n", network);
            for(Integer key : ans.keySet()) {
                System.out.println(key + " : " + ans.get(key));
            }

            network++;
            br.readLine();
        }

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
