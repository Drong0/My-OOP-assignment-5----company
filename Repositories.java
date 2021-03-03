package com.company;

import com.company.Interfaces.Interfaces;
import com.company.data.IDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;


public class Repositories implements Interfaces {
    private final IDB db;
    public Repositories(IDB db){
        this.db=db;
    }
    private int[] arr = new int[100];
    private int sum;
    private int index;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Override
    public boolean addEmployee(Workers workers) {
        Connection con = null;
        try {
            con = db.getconnection();
            String sql = "INSERT INTO employee(id, status, salary, experience) VALUES(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, workers.getId());
            st.setString(2, workers.getStatus());
            st.setInt(3, workers.getSalary());
            st.setInt(4, workers.getExperience());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public int totalCost() {//method to calculate the total cost of the company
        Connection con = null;
        try {
            con = db.getconnection();
            String sql = "SELECT salary FROM employee";//using query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            for (int i = 0; rs.next(); i++){
                arr[i] = rs.getInt("salary");
                sum+=arr[i];
            }
            return sum;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
    @Override
    public List<Workers> getAllEmployee() {//method to get a list with all employees
        Connection con = null;
        try {
            con = db.getconnection();
            String sql = "SELECT  id, status, salary, experience FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Workers> worker = new LinkedList<>();
            while (rs.next()) {
                Workers workers = new Workers(
                        rs.getInt("id"),
                        rs.getString("status"),
                        rs.getInt("salary"),
                        rs.getInt("experience"));
                worker.add(workers);
            }
            return worker;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}