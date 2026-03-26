import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj = new ArrayList[26];
    static int[] visited = new int[26]; // 0=unvisited,1=visiting,2=done
    static StringBuilder result = new StringBuilder();
    static boolean isPossible = true;

    static void dfs(int node) {
        visited[node] = 1;

        for (int neigh : adj[node]) {
            if (visited[neigh] == 0) {
                dfs(neigh);
            } else if (visited[neigh] == 1) {
                isPossible = false; // cycle detected
            }
        }

        visited[node] = 2;
        result.append((char)(node + 'a'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (int i = 0; i < n - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            int minLen = Math.min(a.length(), b.length());
            boolean found = false;

            for (int j = 0; j < minLen; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    adj[a.charAt(j) - 'a'].add(b.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }

            if (!found && a.length() > b.length()) {
                System.out.println("Impossible");
                return;
            }
        }

        // DFS Topo sort
        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (!isPossible) {
            System.out.println("Impossible");
            return;
        }

        System.out.println(result.reverse().toString());
    }
}
