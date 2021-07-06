package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6382
 * 2. 풀이
 *   - Map과 Set을 이용한 BFS 처리
 *    > Set을 통해 중복 방문을 예방함
 */
public class bfs_6382_nCredibleMazes {

    static int N;
    static String start, end;
    static Map<String, List<String>> map;

    static boolean solve() {
        Set<String> set = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.add(start);
        set.add(start);

        while(!q.isEmpty()) {
            String now = q.poll();
            if(now.equals(end)) return true;

            for(String next : map.getOrDefault(now, new ArrayList<>())) {
                if(set.contains(next)) continue;
                set.add(next);
                q.add(next);
            }
        }

        return false;
    }

    static String dimensionToString(StringTokenizer st) {
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < N; i++)
            sb.append(st.nextToken());
        return sb.toString();
    }

    static void putNodesToMap(String a, String b) {
        if(map.containsKey(a))
            map.get(a).add(b);
        else {
            ArrayList<String> li = new ArrayList<>();
            li.add(b);
            map.put(a, li);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int caseNo = 0;

        while((N = Integer.parseInt(br.readLine())) != 0) {
            caseNo++;
            map = new HashMap<>();

            st = new StringTokenizer(br.readLine());

            start = dimensionToString(st);
            end = dimensionToString(st);

            String temp = "";
            while(!(temp = br.readLine()).equals("-1")) {
                st = new StringTokenizer(temp);
                String a = dimensionToString(st);
                String b = dimensionToString(st);
                putNodesToMap(a, b);
                putNodesToMap(b, a);
            }

            bw.write(solve()? String.format("Maze #%d can be travelled\n", caseNo) : String.format("Maze #%d cannot be travelled\n", caseNo));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
