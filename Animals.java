package zoo;

public abstract class Animals extends Object {
    protected String name;
    protected float age;
    float maxrun = 0;
    float maxjump = 0;
    float maxswim = 0;


    public void setMaxrun(int a){

    }

    public Animals(String name, float age, float maxjump, float maxrun, float maxswim) {
        this.name = name;
        this.age = age;
        // Добавил  животным  разброс  в  20 %!
        this.maxjump = maxjump +(float) (Math.random() *((maxjump*0.2)*2)-(maxjump*0.2));
        this.maxrun = maxrun+(float) (Math.random() *((maxrun*0.2)*2)-(maxrun*0.2));
        this.maxswim = maxswim+(float) (Math.random() *((maxswim*0.2)*2)-(maxswim*0.2));
    }

    public void run(int a) {
        if (a < maxrun) {
            System.out.println(this.name + " пробежал");
        }else
        System.out.println(this.name + " не пробежал");
    }

    public void jump(int a) {
        if (a < maxjump) {
            System.out.println(this.name + " прыгнул");
        }else
            System.out.println(this.name + " не  прыгнул");
    }

    public void swim(int a) {
        if (a < maxswim) {
            System.out.println(this.name + " проплыл");
        }else
            System.out.println(this.name + " не  проплыл");
    }
}

