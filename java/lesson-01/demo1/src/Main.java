public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print();
    }
}


class overload {
    void test() {
        System.out.println("No parameters");
    }
    void test(int a) {
        System.out.println("a="+a);
    }
    void test(int a,int b){
        System.out.println("a and b="+(a+b));
    }
}

class Solution {
    void print() {
        System.out.println("hehe");
    }
}