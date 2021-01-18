package domain;

public class Salary {
    private String sno;
    private String sname;
    private int basicsalary;
    private int vocationsalary;
    private int agesalary;
    private int welfare;
    private int allsalary;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getVocationsalary() {
        return vocationsalary;
    }

    public void setVocationsalary(int vocationsalary) {
        this.vocationsalary = vocationsalary;
    }

    public int getAgesalary() {
        return agesalary;
    }

    public void setAgesalary(int agesalary) {
        this.agesalary = agesalary;
    }

    public int getWelfare() {
        return welfare;
    }

    public void setWelfare(int welfare) {
        this.welfare = welfare;
    }

    public int getAllsalary() {
        return allsalary;
    }

    public void setAllsalary(int allsalary) {
        this.allsalary = allsalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", basicsalary=" + basicsalary +
                ", vocationsalary=" + vocationsalary +
                ", agesalary=" + agesalary +
                ", welfare=" + welfare +
                ", allsalary=" + allsalary +
                '}';
    }
}

