package domain;

public class Employee {
    private String id;
    private String eno;
    private String ename;
    private String edept;
    private String esex;
    private String egrade;
    private String erank;
    private Integer eage;
    private String ewelfare;

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEdept() {
        return edept;
    }

    public void setEdept(String edept) {
        this.edept = edept;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public String getEgrade() {
        return egrade;
    }

    public void setEgrade(String egrade) {
        this.egrade = egrade;
    }

    public String getErank() {
        return erank;
    }

    public void setErank(String erank) {
        this.erank = erank;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEwelfare() {
        return ewelfare;
    }

    public void setEwelfare(String ewelfare) {
        this.ewelfare = ewelfare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno='" + eno + '\'' +
                ", ename='" + ename + '\'' +
                ", edept='" + edept + '\'' +
                ", esex='" + esex + '\'' +
                ", egrade='" + egrade + '\'' +
                ", erank='" + erank + '\'' +
                ", eage=" + eage +
                ", ewelfare='" + ewelfare + '\'' +
                '}';
    }
}
