package ArrayList;

import java.util.ArrayList;

//Find if any pair in a sorted and rotated arraylist has
//a target sum.
public class PairSum2 {

    // 2 Pointer Approach
    // Time Complexity O(n)
    public static boolean pairSum(ArrayList<Integer> list, int target){
        int n = list.size();
        //find out breaking point
        int bp = -1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > list.get(i + 1)){
                bp = i;
                break;
            }
        }

        int lp = bp + 1; //smallest
        int rp = bp; //largest

        while (lp != rp){
            //case 1
            if(list.get(lp) + list.get(rp) == target){
                return true;
            } else if(list.get(lp) + list.get(rp) < target){
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 11, 16, 6, 8, 9, 10
        list.add(11);
        list.add(16);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        System.out.println(pairSum(list, target));
    }
}
