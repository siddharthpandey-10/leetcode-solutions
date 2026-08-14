class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int max;
        int length;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            max = 1;
            length = 1;
        }
    }

    Node[] tree;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();
        int k = queryCharacters.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1, s);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    private void build(int node, int l, int r, String s) {

        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private void update(
            int node,
            int l,
            int r,
            int index,
            char c) {

        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private Node merge(Node a, Node b) {

        Node res = new Node(a.leftChar);

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.length = a.length + b.length;

        // Prefix
        res.prefix = a.prefix;

        if (a.prefix == a.length &&
            a.leftChar == b.leftChar) {

            res.prefix = a.length + b.prefix;
        }

        // Suffix
        res.suffix = b.suffix;

        if (b.suffix == b.length &&
            a.rightChar == b.rightChar) {

            res.suffix = b.length + a.suffix;
        }

        // Maximum inside either side
        res.max = Math.max(a.max, b.max);

        // Join suffix of a + prefix of b
        if (a.rightChar == b.leftChar) {

            res.max = Math.max(
                res.max,
                a.suffix + b.prefix
            );
        }

        return res;
    }
}