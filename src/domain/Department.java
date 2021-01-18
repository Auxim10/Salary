package domain;

public class Department {
    private String dname;
    private int vocationsalary;
    private String oldDname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getVocationsalary() {
        return vocationsalary;
    }

    public void setVocationsalary(int vocationsalary) {
        this.vocationsalary = vocationsalary;
    }

    public String getOldDname() {
        return oldDname;
    }

    public void setOldDname(String oldDname) {
        this.oldDname = oldDname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dname='" + dname + '\'' +
                ", vocationsalary=" + vocationsalary +
                '}';
    }
}
