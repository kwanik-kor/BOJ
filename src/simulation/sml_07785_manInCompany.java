package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/7785
 */
public class sml_07785_manInCompany {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.nextToken().equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());
        for (String name : list) {
            System.out.println(name);
        }
    }
}
