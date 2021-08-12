package streams;

public class TestLambda {

    interface Operation{
        boolean check(int n);
    }

    public Operation isOdd(){
        return a -> a % 2 == 1;
    }

    static class MyMath{
        public static boolean checker(Operation o, int n){
            return o.check(n);
        }
    }

    public static void main(String[] args) {
        TestLambda s = new TestLambda();
        Operation odd = s.isOdd();
        boolean result = MyMath.checker(odd, 2);
    }
}
