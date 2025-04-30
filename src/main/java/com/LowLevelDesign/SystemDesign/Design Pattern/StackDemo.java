package WopiHostApplication.File;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.push(5);
        System.out.println(st);
        st.remove(2);
        System.out.println(st);
    }
}
