package jav;

public class author {

    private String name;
    private String gender;
    private int age;
    private String id;


    public author(String name, String gender, int age, String id) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
    }
    public author() {
        // Set default values or initialize variables if needed
        this.name = "Unknown";
        this.gender = "Unknown";
        this.age = 0;
        this.id = "000"; // Default ID
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void author() {
        System.out.println("Name author:" + name + "||___ID author:" + id + "||___Age author:" + age + "||___Gender author:" + gender);
    }

    ;
}