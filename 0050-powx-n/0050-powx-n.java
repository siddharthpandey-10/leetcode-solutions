class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }
        return pow(x, exp, 1);
    }
    double pow(double x, long n, double ans){
        if(n == 0){
            return ans;
        }

        if(n%2 != 0){
            ans *= x;
        }
        return pow(x*x, n/2, ans);
        
    }
}