package ArrayList;

import java.util.ArrayList;

//For given n lines on x-axis, use 2 lines to form a container
// such that it holds maximum amount of water.
public class ContainingMostWater {

    public static int storeWater(ArrayList<Integer> heights){
        int maxWater = 0;

        //brute force approach
        // Time Complexity: O(n^2)
        for (int i = 0; i < heights.size(); i++){
            for (int j = i+1; j < heights.size(); j++){
                int height = Math.min(heights.get(i), heights.get(j));
                int width = j - i;
                int currWater = height * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
    }

    public static int storeWater2(ArrayList<Integer> heights){
        int maxWater = 0;

        // 2 pointer approach
        // Time Complexity: O(n)
        int lp = 0;
        int rp = heights.size() - 1;

        while(lp < rp){
            //calculate water area
            int height = Math.min(heights.get(lp), heights.get(rp));
            int width = rp - lp;
            int currWater = height * width;
            maxWater = Math.max(maxWater, currWater);

            //update pointers
            if(heights.get(lp) < heights.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        // 1, 8 , 6, 2, 5, 4, 8, 3, 7
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        System.out.println(storeWater2(heights));
    }
}
