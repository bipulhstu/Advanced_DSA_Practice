package ArrayList;

import java.util.ArrayList;

public class PairSum1 {

    //Brute Force Approach
    //Time Complexity O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    // 2 Pointer Approach
    // Time Complexity O(n)
    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size() - 1;

        while (lp < rp){
            int currSum = list.get(lp) + list.get(rp);

            if(currSum == target){ //case 1
                return true;
            } else if(currSum < target){ //case 2
                lp++;
            } else { //case 3
                rp--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1, 2, 3, 4, 5, 6
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(pairSum2(list, 10));
    }
}
