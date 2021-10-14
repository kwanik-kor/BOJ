package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4852
 * 2. 풀이
 *  - 재귀를 통해 선물을 주고받는 사이클을 찾아내는 문제
 *  - 무조건 1:1 관계가 만들어지기 때문에 재귀를 구현하는 것은 난이도가 굉장히 낮으나,
 *    문제의 조건에 따라 이름의 순서, Index를 부여하는것에 조금더 초점이 맞춰져 있는 문제가 아닐까 생각...
 */
public class dfs_04852_winterFestival {

    static final String FLAG = "#";
    static final String PARTY = "Party number %d\n";

    static Map<String, String> loop;
    static List<String> names;
    static Set<String> visit;

    static StringBuilder sb = new StringBuilder("");

    static void findGroup(String name) {
        sb.append(name);
        if(visit.contains(name)) {
            sb.append(".\n");
            return;
        }

        visit.add(name);
        sb.append(" to ");
        findGroup(loop.get(name));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx = 1;
        while(true) {
            String line = br.readLine();
            if(line.equals(FLAG))
                break;

            loop = new HashMap<>();
            names = new ArrayList<>();
            visit = new HashSet<>();
            StringTokenizer st;
            while(true) {
                st = new StringTokenizer(line);
                String a = st.nextToken();
                String b = st.nextToken();
                loop.computeIfAbsent(a, k -> b);
                names.add(a);

                line = br.readLine();
                if(line.equals(FLAG))
                    break;
            }

            sb.append(String.format(PARTY, idx));
            for(String name : names) {
                if(!visit.contains(name)) {
                    findGroup(name);
                }
            }

            idx++;
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
