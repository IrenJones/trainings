package patterns;

public class BuilderExample {

    public static void main(String[] args) {
        Cat cat = new CatBuilder().setColor("blue").setEyeColor("orange").build();
        System.out.println(cat);
    }
}

class Cat{
    private String color;
    private String eye;

    public Cat(String c1, String c2){
        this.color = c1;
        this.eye = c2;
    }
}

class CatBuilder{

    private String color;
    private String eye;


    public CatBuilder setColor(String c) {
        this.color = c;
        return this;
    }


    public CatBuilder setEyeColor(String c) {
        this.eye = c;
        return this;
    }

    public Cat build(){
        return new Cat(color, eye);
    }
}

