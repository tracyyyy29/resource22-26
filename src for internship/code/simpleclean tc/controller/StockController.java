package com.controller;

import dao.AbstractDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockController {
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String pass = "123456";
    AbstractDaoImpl abstractDao = new AbstractDaoImpl(driver,url,user,pass);
    /**
     *
     * @param startDate 开始查询的时间位置  20231231
     * @param endDate   结束查询的时间位置  20240713
     * @return   返回到页面的是数据
     */
    public List  getStocks(String startDate,String endDate,Integer pageNow){
        Integer PAGESIZE = 10;
        Integer start = (pageNow-1)*PAGESIZE;
        //return   abstractDao.getMaps("table_stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate,start.toString(),PAGESIZE.toString());
        return  abstractDao.getMaps("table_stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate,start.toString(),PAGESIZE.toString());
        //return  abstractDao.getMaps("table_stock","yyyymmdd",null);

    }

    public Map test2(){
        Map<String,Object[]> map = new HashMap<>();
        map.put("data1",new String[]{"衬衫1", "羊毛衫1", "雪纺衫1", "裤子1", "高跟鞋1", "袜子1"});
        map.put("data2",new Integer[]{5, 20, 36, 10, 10, 20});
        return map;
    }
}
