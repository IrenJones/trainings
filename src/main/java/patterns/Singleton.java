package patterns;

public class Singleton {

    private Singleton instance;

    private Singleton(){

    }

    public Singleton getInstance() {
        if(instance == null){
            this.instance = new Singleton();
        }
        return instance;
    }
}
