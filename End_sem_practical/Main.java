import java.util.*;

public class Main {
    static void build(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, tree, 2 * node + 1, start, mid);
        build(arr, tree, 2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static int query(int[] tree, int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        int left = query(tree, 2 * node + 1, start, mid, l, r);
        int right = query(tree, 2 * node + 2, mid + 1, end, l, r);
        return left + right;
    }

    static void update(int[] tree, int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid)
            update(tree, 2 * node + 1, start, mid, idx, val);
        else
            update(tree, 2 * node + 2, mid + 1, end, idx, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        int[] tree = new int[4 * n];

        build(arr, tree, 0, 0, n - 1);

        System.out.println(query(tree, 0, 0, n - 1, 1, 3));

        update(tree, 0, 0, n - 1, 1, 10);

        System.out.println(query(tree, 0, 0, n - 1, 1, 3));
    }
}