package Stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //1. Opening Bracket
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{ //Closing Bracket
                if(stack.isEmpty()){
                    return false;
                }

                //check match
                if( (stack.peek() == '(' && ch == ')')
                        || (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '[' && ch == ']')){
                    //remove
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }

        //remaining stack
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})[]"; // true
        System.out.println(isValid(str));
    }
}
