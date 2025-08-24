class Solution {
    fun trap(height: IntArray): Int {
        var n = height.size
        var trappedWater = 0

        //calculate left max boundary - helper array
        var leftMax = IntArray(n)
        leftMax[0] = height[0]
        for(i in 1 until n){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        

        //calculate right max boundary - helper array
        var rightMax = IntArray(n)
        rightMax[n-1] = height[n-1]
        for (i in n-2 downTo 0){
            rightMax[i] = Math.max(height[i], rightMax[i+1])
        }

        //loop
        for (i in 0 until n){
            //water level = min(leftmax bound, rightmax bound)
            var waterLevel = Math.min(leftMax[i], rightMax[i])

            //trapped water = (water level - height) * width
            trappedWater += waterLevel - height[i]
            //println(trappedWater)
        }

        return trappedWater
        
    }
}

// ✅ main function outside the class
fun main() {
    val solution = Solution()
    println(solution.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}