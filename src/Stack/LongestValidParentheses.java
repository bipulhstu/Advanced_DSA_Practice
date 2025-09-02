package Stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static int isValid(String str){
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //1. Opening Bracket
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{ //Closing Bracket

                if(!stack.isEmpty()){
                    //check match
                    if( (stack.peek() == '(' && ch == ')')
                            || (stack.peek() == '{' && ch == '}')
                            || (stack.peek() == '[' && ch == ']') ){
                        //remove
                        stack.pop();
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = ""; // true
        System.out.println(isValid(str));
    }
}
