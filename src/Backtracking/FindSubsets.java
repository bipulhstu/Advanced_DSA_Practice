package Backtracking;

public class FindSubsets {

    //Time Complexity: O(n * 2^n) // total subsets for n is 2^n
    //Space Complexity: O(n)
    public static void findSubsets(String str, String ans, int i){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        //recursion
        //Yes choice - character wants to be included
        findSubsets(str, ans + str.charAt(i), i+1);
        //No choice - character wants to be excluded
        findSubsets(str, ans, i+1);
    }

    public static void main(String[] args) {
         String str = "abc";
         findSubsets(str, "", 0);
    }
}
