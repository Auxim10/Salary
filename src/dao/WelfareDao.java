package dao;

import domain.Salarygrade;
import domain.Welfare;

import java.util.List;

public interface WelfareDao {
    List<Welfare> findALL();
    void update(Welfare welfare,String oldWname);
    void del(String dname);
    void insert(Welfare welfare);
    Welfare findById(String name);
}
