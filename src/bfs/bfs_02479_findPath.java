package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2479
 * 2. 풀이
 *  - 주어진 코드를 Integer로 변경해서 두 수의 차이가 2의 제곱수인가를 체크 했었으나
 *    반례가 존재하는 것으로 보임
 *  - 순수하게 문자열을 파싱해서 해밍 거리를 잡아주니 통과 함
 */
public class bfs_02479_findPath {

    static int N, K, startIdx, endIdx;
    static char[][] codes;
    static int[] path;
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(startIdx);
        path[startIdx] = startIdx;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == endIdx) {
                return true;
            }

            for(Integer next : map.get(now)) {
                if(path[next] != -1) continue;
                path[next] = now;
                q.add(next);
            }
        }

        return false;
    }

    static void setMap() {
        for(int i = 1; i < N; i++) {
            for(int j = i + 1; j <= N; j++) {
                if(isHammingPath(codes[i], codes[j])) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
    }

    static boolean isHammingPath(char[] a, char[] b) {
        int cnt = 0;
        for(int i = 0; i < K; i++) {
            if(a[i] != b[i]) cnt++;
            if(cnt > 1) return false;
        }
        return cnt == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        codes = new char[N + 1][K];
        path = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            codes[i] = br.readLine().toCharArray();
            path[i] = -1;
            map.put(i, new HashSet<>());
        }

        st = new StringTokenizer(br.readLine());
        startIdx = Integer.parseInt(st.nextToken());
        endIdx = Integer.parseInt(st.nextToken());

        setMap();

        if(!bfs()) {
            bw.write("-1");
        } else {
            StringBuilder sb = new StringBuilder("");
            int end = endIdx;
            int start = path[endIdx];
            while(true) {
                sb.insert(0, end + " ");
                end = start;
                start = path[end];
                if(start == end) {
                    sb.insert(0, start + " ");
                    break;
                }
            }
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
