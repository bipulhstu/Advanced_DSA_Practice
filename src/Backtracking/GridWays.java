package Backtracking;

//Find number of ways to reach from (0,0) to (n-1, m-1) in a nxm grid.
//Allowed move - right or down.

public class GridWays {
    // Time Complexity: O(2^n*m)
    public static int gridWays(int i, int j, int n, int m){
        //base case
        if(i == n-1 && j == m-1){ // condition for last cell
            return 1;
        } else if(i == n || j == m){ // condition for boundary cells
            return 0;
        }

        //recursive case
        int w1 = gridWays(i+1, j, n, m); //down move
        int w2 = gridWays(i, j+1, n, m); //right move
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3, m = 4;
        System.out.println(gridWays(0, 0, n, m));
    }
}
