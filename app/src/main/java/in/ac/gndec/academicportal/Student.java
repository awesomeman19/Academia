package in.ac.gndec.academicportal;


public class Student {
    //POJO OR BEAN


    //Attributes

    String name;
    String eclass;
    String password;
    long mobile;

    public Student(){

    }
    public Student(String name, String eclass, String password, long mobile) {
        this.name = name;
        this.eclass = eclass;
        this.password = password;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEclass() {
        return eclass;
    }

    public void setEclass(String eclass) {
        this.eclass = eclass;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", eclass='" + eclass + '\'' +
                ", password='" + password + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
