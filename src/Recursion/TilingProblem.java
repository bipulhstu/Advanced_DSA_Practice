package Recursion;

//Tiling Problem
//Given a 2xn board and tiles of size 2x1, find out
//the number of ways to tile the board using 2x1 tiles.

// A tile can eith er be placed horizontally or vertically.

public class TilingProblem {
    public static int tilingProblem(int n){ // 2 x n (floor size)
        //base case
        if(n == 0 || n == 1){
            return 1;
        }

        //Kaam
        //Vertical Choice
        int fnm1 = tilingProblem(n-1);

        //Horizontal Choice
        int fnm2 = tilingProblem(n-2);

        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(3));
    }
}
