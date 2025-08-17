package oop;

public class Demo {
    public static void main(String[] args) {
        Customer c = new Customer("John");
        System.out.println(c);
        Controller controller = new Controller(new RepositoryImpl(), new LoggerImpl());
        System.out.println(controller.getById(2));
        System.out.println(ConstantsKt.answer);
        System.out.println(ConstantsKt.key);
        System.out.println(ConstantsKt.prop);
        System.out.println(MyObject.INSTANCE.getProp());
        // @JVMStatic makes answer static but still accessible by getter
        System.out.println(MyObject.getAnswer());

        // @JVMField makes myField static and accessible as a field without getter
        System.out.println(MyObject.myField);

        System.out.println(new Bee().prop);

        // access instance method
        KSingleton.INSTANCE.foo();
        // access static method
        KSingleton.bar();


    }
}
