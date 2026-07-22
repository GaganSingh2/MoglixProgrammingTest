import java.util.Scanner;
import java.util.Stack;
public class LongestValidSubstringParenthesesLength {
    public static int lengthOfLongestValidSubstringParenthesis(String str){
        if (str.length() == 0 || str.length() == 1) {
            return 0;
        }
        
        int maxLength = 0;
        //Store the index instead of characters
        Stack<Integer> stk = new Stack<>();

        //push -1 as base case, and also prevent StackUnderflowError
        stk.push(-1);

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //if the current character is '(' so simple store its index.
            if(ch == '('){
                stk.push(i);
            }
            else{
                stk.pop();

                //if the stack becomes empty means current character ')' is unmatched (pair not found). so insert this index as a new base index to prevent StackUnderflow error next time and also calculate to valid substring length for next valid Parenthesis.
                if (stk.isEmpty()) {
                    stk.push(i);
                }
                //otherwise, calculate the length of current length of valid substring and assign into maxLength.
                else{
                    maxLength = Math.max(maxLength, i - stk.peek());
                }
            }
        }

        return maxLength;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Parenthesis: ");
        String str = sc.next();

        int totalCount = lengthOfLongestValidSubstringParenthesis(str);
        System.out.println("Length of Total Valid SubString Parenthesis: "+totalCount);

    }
}
