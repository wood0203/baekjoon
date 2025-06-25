import java.util.*;
import java.io.*;

public class Main {

    static String[] tree;
    static HashMap<String, String[]> nodes = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new String[(int) Math.pow(2, N)];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            nodes.put(input[0], new String[] {input[1], input[2]});
        }

        tree[1] = "A";
        setTree("A", 1);
        frontTravel(1);
        sb.append("\n");
        midTravel(1);
        sb.append("\n");
        postTravel(1);
        System.out.println(sb.toString());
    }

    public static void setTree(String alpha, int index) {
        tree[index] = alpha;
        int i = 0;
        for (String child: nodes.get(alpha)) {
            int childIndex = index * 2 + i++;
            if (child.equals(".") || childIndex >= tree.length) continue;

            setTree(child, childIndex);
        }
    }

    public static void frontTravel(int index) {
        if (index >= tree.length || tree[index] == null) return;

        sb.append(tree[index]);
        frontTravel(index * 2);
        frontTravel(index * 2 + 1);
    }

    public static void midTravel(int index) {
        if (index >= tree.length || tree[index] == null) return;

        midTravel(index * 2);
        sb.append(tree[index]);
        midTravel(index * 2 + 1);
    }

    public static void postTravel(int index) {
        if (index >= tree.length || tree[index] == null) return;

        postTravel(index * 2);
        postTravel(index * 2 + 1);
        sb.append(tree[index]);
    }
}