package Arrays;

class Print_Subarrays{

    public static void printSubarrays(int numbers[]){
        for(int i = 0; i < numbers.length; i++){
            int start = i;
            for (int j = i; j < numbers.length; j++){
                int end = j;
                for (int k = start; k <= end; k++){
                    System.out.print(numbers[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    //Brute Force Method - Time Complexity O(n^3)
    public static void maxSubarraySum(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++){
            int start = i;

            for (int j = i; j < numbers.length; j++){
                int end = j;
                int currSum = 0;
                for (int k = start; k <= end; k++){
                    //System.out.print(numbers[k] + " ");
                    currSum +=  numbers[k];
                }
                if(maxSum < currSum){
                    maxSum = currSum;
                }
                System.out.println(currSum);
            }
        }
        System.out.println("Maximum sum: " + maxSum);
    }


    //Prefix Array Method - Time Complexity O(n^2)
    public static void maxSubarraySumUsingPrefixSum(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        //calculate prefix array
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i = 0; i < numbers.length; i++){
            int start = i;

            for (int j = i; j < numbers.length; j++){
                int end = j;
                int currSum = 0;
                //replace of for loop
                currSum = start ==0 ? prefix[end]: prefix[end] - prefix[start-1];
                if(maxSum < currSum){
                    maxSum = currSum;
                }
                System.out.println(currSum);
            }
        }
        System.out.println("Maximum sum: " + maxSum);
    }

    public static void maxSubarraySumUsingKadanesAlgorithm(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i < numbers.length; i++){
            currSum = currSum + numbers[i];

            if(currSum < 0){ //kadane's algorithm
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }

        System.out.println("Maximum subarray sum: " + maxSum);

        //NOTE: If all the numbers are negative, then we have to use a for loop 
        //and use other's algorithm rather than Kadane's Algorithm.
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        //printSubarrays(numbers);
        //maxSubarraySum(numbers);
        //maxSubarraySumUsingPrefixSum(numbers);
        maxSubarraySumUsingKadanesAlgorithm(numbers);
    }
}