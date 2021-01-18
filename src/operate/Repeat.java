package operate;

import dao.Impl.EmployeeDaoImpl;
import domain.Employee;
import org.apache.commons.beanutils.BeanUtils;

public class Repeat {
    public int repeat(String eno) {
        Employee employee;
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        System.out.println(dao.findById(eno));
        int a = 0;
        try {
            if (dao.findById(eno) == null) {
                System.out.println("主键重复！");
            a=1;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return a;
    }

}
