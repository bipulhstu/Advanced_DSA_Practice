package Recursion;

public class RemoveDuplicates {

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
        //base case
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        //Kaam: recursive case
        char currentChar = str.charAt(idx);
        if(map[currentChar - 'a'] == true){
            //duplicate found
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currentChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currentChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "appnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
