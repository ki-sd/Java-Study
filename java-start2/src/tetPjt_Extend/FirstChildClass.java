package tetPjt_Extend;

public class FirstChildClass extends ParentClass {

    public FirstChildClass() {
        System.out.println("First ChildClass Constructor");
    }
    public void childFun() {
        System.out.println("-- childFun() START --");
    }
    public void makeJJajang() {
        System.out.println("--Override Jjajang--");
    }
}
