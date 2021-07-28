package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11095
 * 2. 풀이
 *  - 경로를 탐색하고 최적 경로의 역추적을 하는 문제
 *   - 사실 아래 코드처럼 복잡하게 갈 필요 없이, 내부 클래스를 통해 경로를 계속 물고가도 되지만
 *    역추적을 오랜만에 다시 짜보고 싶었음
 */
public class bfs_11095_tornToPieces {

    static int no = 0;
    static int[] path = new int[1025];
    static String[] stations = new String[1025];

    static String start, end;
    static Map<String, Integer> stationNumber = new HashMap<>();
    static Map<String, Set<String>> map = new HashMap<>();

    static boolean solve() {
        Arrays.fill(path, -1);

        Queue<String> q = new LinkedList<>();
        q.add(start);
        path[stationNumber.get(start)] = stationNumber.get(start);
        while(!q.isEmpty()) {
            String now = q.poll();
            if(now.equals(end))
                return true;

            int nowIdx = stationNumber.get(now);
            for(String next : map.get(now)) {
                int nextIdx = stationNumber.get(next);
                if(path[nextIdx] != -1) continue;
                path[nextIdx] = nowIdx;
                q.add(next);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String depart = st.nextToken();
            addStation(depart);
            while(st.hasMoreTokens()) {
                String arrival = st.nextToken();
                addStation(arrival);
                map.get(depart).add(arrival);
                map.get(arrival).add(depart);
            }
        }

        st = new StringTokenizer(br.readLine());
        start = st.nextToken();
        end = st.nextToken();
        addStation(start);
        addStation(end);

        if(solve()) {
            StringBuilder sb = new StringBuilder("");
            int startIdx = path[stationNumber.get(end)];
            int endIdx = stationNumber.get(end);

            while(startIdx != endIdx) {
                sb.insert(0, stations[endIdx] + " ");
                endIdx = startIdx;
                startIdx = path[endIdx];
            }
            sb.insert(0, start + " ");
            bw.write(sb.toString());
        } else {
            bw.write("no route found");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void addStation(String stationNm) {
        if(stationNumber.containsKey(stationNm))
            return;
        stations[no] = stationNm;
        stationNumber.put(stationNm, no++);
        map.put(stationNm, new HashSet<>());
    }

}
