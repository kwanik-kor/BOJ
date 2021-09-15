package bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16166
 * 2. 풀이
 *  - 역과 호선을 각각의 독립된 개체로 보고 Queue 내부에서 각각 방문처리를 진행함.
 *  - 단, 역에 대한 방문처리를 먼저 처리해야 하는데,
 *    환승을 할 수 있다면 굳이 환승횟수를 올리지 않고 현재 호선에서 방문하는 것이 이득이기 때문
 */
public class bfs_16166_seoulSubway {

    static int N, end;
    static Map<Integer, List<Integer>> stations; // key(station) - value(line)
    static Map<Integer, Set<Integer>> lines; // key(line) - value(station)

    static int solve() {
        Set<Integer> visit = new HashSet<>();
        Set<Integer> visitL = new HashSet<>();
        visit.add(0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Integer line : stations.get(0)) {
            pq.add(new Node(0, line, 0));
        }

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            visitL.add(now.l);

            if(now.s == end)
                return now.cnt;
            for(Integer station : lines.get(now.l)) {
                if(visit.contains(station)) continue;
                visit.add(station);
                pq.add(new Node(station, now.l, now.cnt));
            }
            for(Integer line : stations.get(now.s)) {
                if(line == now.l || visitL.contains(line)) continue;
                visitL.add(line);
                pq.add(new Node(now.s, line, now.cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        stations = new HashMap<>();
        lines = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for(int k = 0; k < K; k++) {
                int n = Integer.parseInt(st.nextToken());
                getLine(i).add(n);
                getStation(n).add(i);
            }
        }
        end = Integer.parseInt(br.readLine());

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> getStation(int n) {
        return stations.computeIfAbsent(n, k -> new ArrayList<>());
    }

    static Set<Integer> getLine(int n) {
        return lines.computeIfAbsent(n, k -> new HashSet<>());
    }

    static class Node implements Comparable<Node> {
        int s; // station
        int l; // line
        int cnt;
        public Node(int s, int l, int cnt) {
            this.s = s;
            this.l = l;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
}
