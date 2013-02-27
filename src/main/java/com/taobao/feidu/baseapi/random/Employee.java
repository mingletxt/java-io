package com.taobao.feidu.baseapi.random;

/**
 * User: feidu
 * Date: 13-2-27
 * Time: 下午5:08
 */

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

class Employee {
    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
    private String name;
    private double salary;
    private Day hireDay;

    public Employee(String n, double s, Day d) {
        name = n;
        salary = s;
        hireDay = d;
    }

    public Employee() {
    }

    public void print() {
        System.out.println(name + "    " + salary + "    " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireDay.getYear();
    }

    public void writeData(DataOutput out) throws IOException {
        DataIO.writeFixedString(name, NAME_SIZE, out);
        out.writeDouble(salary);
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonth());
        out.writeInt(hireDay.getDay());
    }

    public void readData(DataInput in) throws IOException {
        name = DataIO.readFixedString(NAME_SIZE, in);
        salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        hireDay = new Day(y, m, d);
    }
}

