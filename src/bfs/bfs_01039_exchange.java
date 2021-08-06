package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1039
 * 2. 풀이
 *  - 교환하고자 하는 j 번째 수가 0이면 항상 스왑이 안되게끔 했다가 몇번이고 틀렸다.
 *  - 정신차려라.....
 */
public class bfs_01039_exchange {

    static int N, M, K;
    static int ans = 0;
    static List<Comb> combinations = new ArrayList<>();

    static int solve() {
        HashSet<Integer> set;

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int k = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            set = new HashSet<>();

            while(size-- > 0) {
                int now = q.poll();

                if(k == K) {
                    ans = Math.max(ans, now);
                    continue;
                }

                for(Comb comb : combinations) {
                    int next = swap(now, comb);
                    if(next == 0 || set.contains(next)) continue;
                    q.add(next);
                    set.add(next);
                }
            }

            if(k == K)
                return ans;

            k++;
        }

        return -1;
    }

    static int swap(int n, Comb comb) {
        char[] arr = String.valueOf(n).toCharArray();
        if(comb.a == 0 && arr[comb.b] == '0')
            return 0;

        char temp = arr[comb.a];
        arr[comb.a] = arr[comb.b];
        arr[comb.b] = temp;

        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        N = Integer.parseInt(n);
        M = n.length();
        K = Integer.parseInt(st.nextToken());

        // Combination 만들기
        for(int i = 0; i < M - 1; i++) {
            for(int j = i + 1; j < M; j++) {
                combinations.add(new Comb(i ,j));
            }
        }

        if(M == 1)
            bw.write("-1");
        else
            bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Comb {
        int a;
        int b;
        public Comb(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
