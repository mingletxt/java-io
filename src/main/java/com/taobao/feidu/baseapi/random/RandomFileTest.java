package com.taobao.feidu.baseapi.random;

/**
 * User: feidu
 * Date: 13-2-27
 * Time: 下午5:08
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Zhang", 600, new Day(1998, 9, 1));
        staff[1] = new Employee("Wang", 800, new Day(1968, 2, 28));
        staff[2] = new Employee("Li", 1000, new Day(1989, 3, 18));
        int i;
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"));
            for (i = 0; i < staff.length; i++) {
                staff[i].writeData(out);
            }
            out.close();
        } catch (IOException e) {
            System.out.print("Error: " + e);
            System.exit(1);
        }

        try {
            RandomAccessFile in = new RandomAccessFile("employee.dat", "rw");
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            System.out.println("Former recorder of the staff:  ");
            for (i = 0; i <= n - 1; i++) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i].readData(in);
                newStaff[i].print();
                newStaff[i].raiseSalary(20.0);
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i].writeData(in);
            }
            System.out.println("Recorder of Staff after raising salary: ");
            in.seek(0L);
            for (i = n - 1; i >= 0; i--) {
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i].readData(in);
                newStaff[i].print();
            }
        } catch (IOException e) {
            System.out.print("Error : " + e);
            System.exit(1);
        }
    }
}

