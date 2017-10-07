package com.example.chinna.jsondataread;

/**
 * Created by CHINNA on 10/1/2017.
 */

public class Bean {
    int empNo;
    String name;

    public Bean(int empNo, String name, String dept, int sal) {
        this.empNo = empNo;
        this.name = name;
        this.dept = dept;
        this.sal = sal;
    }

    String dept;
    int sal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bean bean = (Bean) o;

        if (empNo != bean.empNo) return false;
        if (sal != bean.sal) return false;
        if (name != null ? !name.equals(bean.name) : bean.name != null) return false;
        return dept != null ? dept.equals(bean.dept) : bean.dept == null;

    }

    @Override
    public int hashCode() {
        int result = empNo;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + sal;
        return result;
    }
}
