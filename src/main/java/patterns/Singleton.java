package patterns;

public class Singleton {

    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getSingleInstance(){

        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
