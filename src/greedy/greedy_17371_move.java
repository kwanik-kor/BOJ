package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17371
 * 2. 풀이
 *  - 거리를 구하는 것이 아니라 지점을 구하는 것이므로, 각 지점간의 최대거리가 최소가 되는 지점을 뽑으면 됨
 */
public class greedy_17371_move {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        new greedy_17371_move().solve();
        bw.close();
    }

    private void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ansDist = Integer.MAX_VALUE;
        int ansIdx = -1;

        for (int i = 0; i < N; i++) {
            int maxDist = -1;
            int maxIdx = -1;
            for (int j = 0; j < N; j++) {
                int dist = (int) Math.pow(nodes[i].x - nodes[j].x, 2) + (int) Math.pow(nodes[i].y - nodes[j].y, 2);
                if (dist > maxDist) {
                    maxDist = dist;
                    maxIdx = i;
                }
            }

            if (maxDist < ansDist) {
                ansDist = maxDist;
                ansIdx = maxIdx;
            }
        }

        bw.write(nodes[ansIdx].x + " " + nodes[ansIdx].y);
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
