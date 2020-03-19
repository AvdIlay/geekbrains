package zoo;

import zoo.Animals;

public class Dog extends Animals {

    public Dog (String name, float age,float maxjump, float maxrun, float maxswim) {
        super(name, age, maxjump,maxrun,maxswim);
    }
    @Override
    public void setMaxrun(int a){
        this.maxrun=a;

    }

}
