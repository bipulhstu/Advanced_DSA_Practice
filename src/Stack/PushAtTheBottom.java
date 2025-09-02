package Stack;

import java.util.Stack;

public class PushAtTheBottom {

    public static void pushAtTheBottom(Stack<Integer> stack, int data){
        //base case
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }

        //recursive call
        int top = stack.pop();
        pushAtTheBottom(stack, data);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        pushAtTheBottom(stack, 4);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
