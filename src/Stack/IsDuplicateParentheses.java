   package Stack;

import java.util.Stack;

public class IsDuplicateParentheses {

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

    public static boolean isDuplicate(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //closing
            if(ch == ')'){ //closing
                int count = 0;

                while (stack.pop() != '('){
                    count++;
                }

                if(count < 1){
                    return true; //duplicate
                }

            }else{
                //opening
                stack.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))"; // true
        String str2 = "(a+b)"; // false
        System.out.println(isDuplicate(str2));
    }
}
