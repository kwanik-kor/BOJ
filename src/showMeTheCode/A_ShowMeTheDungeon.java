package showMeTheCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_ShowMeTheDungeon {

    static int N, K;
    static int[] damage, people;
    static boolean[] visit;

    static int liberate(int health, int totDamage, int liberated) {
        int max = liberated;

        for (int i = 0; i < N; i++) {
            if (visit[i] || health < 2 * totDamage + damage[i]) {
                continue;
            }

            visit[i] = true;
            max = Math.max(max, liberate(health - 2 * totDamage - damage[i], totDamage * 2 + damage[i], liberated + people[i]));
            visit[i] = false;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        damage = new int[N];
        people = new int[N];
        visit = new boolean[N];

        String[] damageStr = br.readLine().split(" ");
        String[] peopleStr = br.readLine().split(" ");
        for (int i = 0 ; i < N; i++) {
            damage[i] = Integer.parseInt(damageStr[i]);
            people[i] = Integer.parseInt(peopleStr[i]);
        }

        bw.write(liberate(K, 0, 0) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
