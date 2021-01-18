package operate;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import dao.Impl.EmployeeDaoImpl;
import dao.dao;
import domain.Employee;
import domain.Salary;

public class SalaryBegin {
    public void begin(){
        Employee employee = new Employee();
        Salary salary = new Salary();
        String dept;
        String grade;
        String rank;
        String welfare;
        int age;
        int allSalary;
        switch (employee.getEdept()){
            case "公关" :
                salary.setBasicsalary(2000);
            case  "客户" :
                salary.setBasicsalary(2000);
            case  "广告" :
                salary.setBasicsalary(1500);
            case  "技术" :
                salary.setBasicsalary(3000);
            case  "运营" :
                salary.setBasicsalary(1800);
        }
        switch (employee.getEgrade()){
            case "主管" :
                salary.setVocationsalary(2000);
            case "员工" :
                salary.setVocationsalary(800);
            case "实习生" :
                salary.setVocationsalary(300);
            case "经理" :
                salary.setVocationsalary(1500);
        }
        switch (employee.getEwelfare()){
            case "节日" :
        }
    }

}
