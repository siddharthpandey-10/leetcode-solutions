import java.util.*;

class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // last[j] = rightmost index in word1
        // where word2[j] can be matched
        int[] last = new int[m];

        Arrays.fill(last, -1);

        int j = m - 1;

        // Build last[] from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        // Result
        int[] temp = new int[m];
        int size = 0;

        // skip = 0 -> mismatch has not been used
        // skip = 1 -> mismatch has been used
        int skip = 0;

        j = 0;

        // Greedily construct answer
        for (int i = 0; i < n; i++) {

            if (j == m) {
                break;
            }

            /*
             * We can select word1[i] if:
             *
             * 1. It exactly matches word2[j]
             *
             * OR
             *
             * 2. We haven't used our mismatch yet AND
             *    there is enough room to match the rest.
             */
            if (word1.charAt(i) == word2.charAt(j)
                    || (skip == 0
                    && (j == m - 1 || i < last[j + 1]))) {

                // If characters are different,
                // use our one allowed mismatch.
                if (word1.charAt(i) != word2.charAt(j)) {
                    skip = 1;
                }

                temp[size++] = i;
                j++;
            }
        }

        // Could not match all characters
        if (j != m) {
            return new int[0];
        }

        return Arrays.copyOf(temp, size);
    }
}