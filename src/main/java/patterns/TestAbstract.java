package patterns;

public class TestAbstract {

    public static void main(String[] args) {
        Base o = new Derived();
//        System.out.println(o.x);
        o.foo();
    }
}

abstract class Base{
    public int y = 13;

    public Base(){
        foo();
    }

    public abstract void foo();
}

class Derived extends Base{

    int x = 2;

    @Override public void foo() {
        System.out.println(y);
        System.out.println(x);
    }
}
