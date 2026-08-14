class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0;
        int max = Integer.MIN_VALUE;
      
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right=0; right<n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            
            while(map.get(c) > 2){
                
                    char leftChar = s.charAt(left);

                    map.put(leftChar, map.get(leftChar) - 1);
                    left++;
            }

            int len = right - left + 1;
            max = Math.max(max, len);

        }
        return max;
    }
}