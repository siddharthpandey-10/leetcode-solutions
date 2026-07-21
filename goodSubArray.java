import java.util.HashMap;
public class goodSubArray {
    public static int maxSumSubArray(int[]A, int k){
        int left = 0;
        
        int sum = 0;
        int max= 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right<A.length; right++){
            sum += A[right];
            map.put(A[right],map.getOrDefault(A[right], 0)+1);
            while(map.size() > k){
                sum -= A[left];
                map.put(A[left], map.get(A[left])-1);
                if(map.get(A[left]) == 0){
                    map.remove(A[left]);
                }
                left++;

                

            }
            max = Math.max(max, sum);


        }
        return max;


    }



    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1};
        int k = 2;
        System.out.println(maxSumSubArray(A, k));
    }
}
