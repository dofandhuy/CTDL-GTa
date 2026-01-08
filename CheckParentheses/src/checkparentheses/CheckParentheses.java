package checkparentheses;
import java.util.*;

public class CheckParentheses {

public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
     String expression = sc.nextLine(); // Thay bằng biểu thức cần kiểm tra
        System.out.println(isValid(expression) ? 1 : 0);
    }

    public static boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            // Nếu là dấu ngoặc mở, đẩy vào stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Nếu là dấu ngoặc đóng, kiểm tra
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // Không có dấu ngoặc mở tương ứng
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false; // Dấu ngoặc không khớp
                }
            }
        }

        return stack.isEmpty(); // Nếu stack rỗng, biểu thức hợp lệ
    }
    
}
