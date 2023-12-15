public class Employee extends Person {
    private boolean salary;

    public Employee() {
    }

    public Employee(String id, String name) {
        super(id, name);
    }

    public Employee(String id, String name, boolean salary) {
        super(id, name);
        this.salary = salary;
    }

    public boolean isSalary() {
        return salary;
    }

    public void setSalary(boolean salary) {
        this.salary = salary;
    }
}
