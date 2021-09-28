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

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2310
 * 2. 풀이
 *  - 너비우선탐색으로 Search를 해도 문제 없이 풀 수 있을 것으로 보인다..?
 */
public class dfs_02310_adventureGame {

    static int N;

    static boolean[] visit;
    static Room[] rooms;
    static Map<Integer, List<Integer>> edges;

    static void solve(int num, int pocket) {
        visit[num] = true;
        if(num == N) return;

        for(Integer next : edges.get(num)) {
            if(visit[next]) continue;
            int nextP = getPocket(pocket, next);
            if(0 <= nextP)
                solve(next, nextP);
        }
    }

    static int getPocket(int pocket, int next) {
        char type = rooms[next].type.charAt(0);
        if(type == 'E')
            return pocket;
        else if(type == 'L')
            return Math.max(pocket, rooms[next].cost);
        return pocket - rooms[next].cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            rooms = new Room[N + 1];
            visit = new boolean[N + 1];
            edges = new HashMap<>();
            for(int i = 1; i <= N; i++) {
                String[] in = br.readLine().split(" ");

                rooms[i] = new Room(in[0], Integer.parseInt(in[1]));

                for(int next = 2; next < in.length - 1; next++) {
                    getNode(i).add(Integer.parseInt(in[next]));
                }
            }

            solve(1, getPocket(0, 1));

            bw.write(visit[N]? "Yes\n" : "No\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new ArrayList<>());
    }

    static class Room {
        String type;
        int cost;
        public Room(String type, int cost) {
            this.type = type;
            this.cost = cost;
        }
    }
}
