package Recursion;

public class PowerCalculation {

    // O(n) time and space complexity
    public static int power(int x, int n){
        if(n == 0){ //base case
            return 1;
        }

        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;

        // return x * power(x, n-1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10)); //2^10 = 1024
    }
}
