package stack_and_queue;

public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack st = new DynamicStack(5);
        st.push(34);
        st.push(45);
        st.push(2);
        st.push(9);
        st.push(18);
        st.push(19);

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
