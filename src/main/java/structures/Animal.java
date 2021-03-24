package structures;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(10);

        Animall l = new Parrot();
        System.out.println(l.t());
        System.out.println(1.0d);
        System.out.println(l.y);
    }
}

class Animall {
    {
        System.out.println(3);
    }

    public int t(){
        return 0;
    }

    static {
        System.out.println(4);
    }

    int y = t();

    public Animall(){
        System.out.println(5);
    }
}

class Parrot extends Animall{

    @Override
    public int t(){
        return 1;
    }
}


