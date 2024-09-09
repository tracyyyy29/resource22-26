package com.controller;
import dao.AbstractDaoImpl;
import java.util.List;

public class EmpController {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String pass = "123456";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);
    public List getEmps(){
       return abstractDao.getMaps("user2","*",null);
    }
}