package domain;

public class Salarygrade {
    private String grade;
    private int gradesalary;
    private String oldGrade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getGradesalary() {
        return gradesalary;
    }

    public void setGradesalary(int gradesalary) {
        this.gradesalary = gradesalary;
    }

    public String getOldGrade() {
        return oldGrade;
    }

    public void setOldGrade(String oldGrade) {
        this.oldGrade = oldGrade;
    }

    @Override
    public String toString() {
        return "Salarygrade{" +
                "grade='" + grade + '\'' +
                ", gradesalary=" + gradesalary +
                '}';
    }
}
