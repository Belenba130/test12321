public class Program {
    private static final String CONST = "Data";

    public static void main(String[] args) {
        Person p = new Person("P01", "Hoàng");
        p.hello();
        p.info();
        Student st = new Student("SV01", "Thắng", "RA/FUKUOKA-JV230929");
        st.hello();
        st.info();
        Employee emp = new Employee("NV1", "Nam");
        emp.hello();
        emp.info();

        int a = 10;
        long b = a; // ngầm định
        //int c = b; // lỗi, phải ép kiểu

        //Student pSt = new Person(); // lỗi, phải ép kiểu


        Person stPer = new Student("SV02", "Hòa", "RA/FUKUOKA-JV230929");
        stPer.hello();
        stPer.info();

        Person person = getPerson();
        if (person != null)
            person.hello();

        System.out.println(stPer instanceof Employee);
        System.out.println(stPer instanceof Student);

        Student st2 = (Student) stPer;
        System.out.println("After casting: " + st2.getClassName());
    }

    public static Person getPerson() {
        return null;
    }

    public void demoLibrary(Person p) {
        p.info();
    }
}
