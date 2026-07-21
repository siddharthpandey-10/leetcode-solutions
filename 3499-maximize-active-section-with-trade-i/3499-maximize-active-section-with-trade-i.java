class Solution {

    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1')
                ones++;
        }

        String t = "1" + s + "1";

        List<Character> type = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        int i = 0;

        while (i < t.length()) {

            char ch = t.charAt(i);
            int count = 0;

            while (i < t.length() && t.charAt(i) == ch) {
                count++;
                i++;
            }

            type.add(ch);
            len.add(count);
        }

        int maxGain = 0;

        // look for 0-block,1-block,0-block
        for (int j = 1; j < type.size() - 1; j++) {

            if (type.get(j) == '1'
                    && type.get(j - 1) == '0'
                    && type.get(j + 1) == '0') {

                int gain = len.get(j - 1) + len.get(j + 1);

                maxGain = Math.max(maxGain, gain);
            }
        }

        return ones + maxGain;
    }
}