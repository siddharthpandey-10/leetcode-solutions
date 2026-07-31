class Solution {
    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for(char c: word.toCharArray()){
            frequency[c - 'a']++;
        }

        Arrays.sort(frequency);

        int pushes = 0;
        int position = 0;

        for(int i=25; i>=0; i--){

            if(frequency[i] == 0){
                continue;
            }
            int cost = (position / 8) + 1;
            pushes += frequency[i] * cost;
            position++;
        }
        return pushes;
    }
}