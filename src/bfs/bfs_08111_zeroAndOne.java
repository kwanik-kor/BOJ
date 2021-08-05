package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/8111
 * 2. 풀이
 *  - '0과 1 - 2' 문제를 먼저 풀어서 본 문제는 쉽게 풀 수 있었다.
 *  - 실질적으로 숫자를 계속 곱하거나 더해가는 것이 아니라,
 *    나머지 이론을 이용해 숫자를 계속해서 만들어가는 방식
 *  - 2 문제와 한가지 차이가 있다면 수의 길이가 100이하여야 하기 때문에
 *    해당 조건만 추가적으로 분기처리해주면 됨
 */
public class bfs_08111_zeroAndOne {

    static int N;
    static String ans;
    static boolean[] visit;

    static boolean isFavorite() {
        visit = new boolean[20001];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, "1"));
        visit[1] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.n == 0) {
                ans = now.str;
                return true;
            }

            if(!visit[(now.n * 10) % N]) {
                visit[(now.n * 10) % N] = true;
                q.add(new Node((now.n * 10) % N, now.str + "0"));
            }
            if(!visit[(now.n * 10 + 1) % N]) {
                visit[(now.n * 10 + 1) % N] = true;
                q.add(new Node((now.n * 10 + 1) % N, now.str + "1"));
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
            boolean isFavorite = isFavorite();
            if(isFavorite && ans.length() <= 100) {
                bw.write(ans + "\n");
            } else {
                bw.write("BRAK\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int n;
        String str;
        public Node(int n, String str) {
            this.n = n;
            this.str = str;
        }
    }
}
