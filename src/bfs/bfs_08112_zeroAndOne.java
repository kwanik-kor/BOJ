package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/8112
 * 2. 풀이
 *  - 주어진 수의 배수를 순회하는 것이 아니라, 구사과가 좋아하는 수를 만들어가면서
 *   이 수가 주어진 수의 배수인지 확인하면 됨
 *  - 나머지 이론에 입각해 visit 배열은 N만큼만 처리해서 진행할 수 있음
 */
public class bfs_08112_zeroAndOne {

    static int N;
    static boolean[] visit;
    static String ans;

    static boolean bfs(Node n) {
        visit = new boolean[1000001];

        Queue<Node> q = new LinkedList<>();
        q.add(n);
        visit[n.num] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.num == 0) {
                ans = now.str;
                return true;
            }

            if(!visit[(now.num * 10) % N]) {
                visit[(now.num * 10) % N] = true;
                q.add(new Node((now.num * 10) % N, now.str + "0"));
            }
            if(!visit[(now.num * 10 + 1) % N]) {
                visit[(now.num * 10 + 1) % N] = true;
                q.add(new Node((now.num * 10 + 1) % N, now.str + "1"));
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            if(N == 1) {
                bw.write("1\n");
                continue;
            }
            if(!bfs(new Node(1, "1"))) {
                bw.write("BRAK\n");
            } else {
                bw.write(ans + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int num;
        String str;

        public Node(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}
