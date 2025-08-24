package Arrays;

public class TrappedWater {

    public static int trappedWater(int height[]){
        int n = height.length;
        int trappedWater = 0;

        //calculate left max boundary - helper array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //calculate right max boundary - helper array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        for (int i = 0; i<n; i++){
            System.out.println(rightMax[i]);
        }

        //loop
        for(int i=0; i<n; i++){
            //water level = min(leftmax bound, rightmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            //trapped water = (water level - height) * width
            trappedWater += waterLevel - height[i];
            //System.out.println(trappedWater);
        }

        return trappedWater;
    }
    
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappedWater(height));
    }
}
