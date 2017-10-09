package in.ac.gndec.academicportal;


public class Teacher {

    //POJO OR BEAN

    //Attributes

    String name;
    String password;
    long mobile;

    public Teacher(){

    }

    public Teacher(String name, String password, long mobile) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
