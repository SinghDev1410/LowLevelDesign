package WopiHostApplication.File;

public class Test1 implements intMethod{
    public static void main(String[] args) {

        Test1 test1 = new Test1();
        NewClass newClass = new NewClass();
        System.out.println(newClass.method1());
        System.out.println(test1.newInt());
    }

    @Override
    public String newInt() {
//        System.out.println("Interface is tested ");
        return "Interface method is tested";

    }
}

class NewClass {

    String method1(){
        return "Test String method ";
    }

}


interface intMethod{
    String newInt();
}
