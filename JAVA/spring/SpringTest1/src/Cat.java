/**
 * Created by crazyacking on 16-5-12.
 */
public class Cat {
    public void Cat(){}
    Cat cat;
    public Cat getCat(){
        return cat;
    }

    public void setCat(Cat cat){
        this.cat=cat;
    }

    public void catSay(String name){
        System.out.println("cat:"+name);
    }
}
