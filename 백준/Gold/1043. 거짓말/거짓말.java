import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] parents, truth;
    static ArrayList<int[]> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parents[i] = i;

        StringTokenizer truthSt = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(truthSt.nextToken());
        truth = new int[truthCnt];
        if (truth.length >= 1) {
            for (int i = 0; i < truth.length; i++) {
                truth[i] = Integer.parseInt(truthSt.nextToken());
                if (i >= 1)
                    union(find(truth[i]), find(truth[i - 1]));
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] party = new int[Integer.parseInt(st.nextToken())];
            for (int j = 0; j < party.length; j++) {
                party[j] = Integer.parseInt(st.nextToken());
                if (j >= 1)
                    union(find(party[j]), find(party[j - 1]));
            }
            parties.add(party);
        }

        if (truthCnt == 0) {
            System.out.println(parties.size());
            return;
        }

        int answer = 0;
        for (int[] party: parties) {
            boolean isTruthKnowed = false;
            for (int p: party) {
                if (find(p) == find(truth[0])) {
                    isTruthKnowed = true;
                    break;
                }
            }

            if (!isTruthKnowed) answer++;
        }

        System.out.println(answer);
    }

    public static int find(int node) {
        if (parents[node] == node) return node;
        return parents[node] = find(parents[node]);
    }

    public static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) return false;

        if (parentX < parentY)
            parents[parentY] = parentX;
        else
            parents[parentX] = parentY;

        return true;
    }

}