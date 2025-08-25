package Recursion;

public class PowerCalculationOptimized {

    // O(log n) time and space complexity
    public static int optimizedPower(int x, int n){
        if(n == 0){
            return 1;
        }

        // Time Complexity: O(n) because of recursive calls
        //int halfPowerSq = optimizedPower(x, n/2) * optimizedPower(x, n/2);

        // Time Complexity: O(log n)
        int halfPower = optimizedPower(x, n/2);
        int halfPowerSq = halfPower * halfPower;

        // n is odd
        if(n % 2 != 0){
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String[] args) {
        System.out.println(optimizedPower(2, 10)); // 2^10 = 1024
    }
}
