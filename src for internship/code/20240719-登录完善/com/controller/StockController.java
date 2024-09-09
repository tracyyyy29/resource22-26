package com.controller;

import com.po.ResultTo;
import dao.AbstractDaoImpl;
import org.MultipartFile;

import java.io.File;
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
     * @param startDate 开始查询的时间位置  20231231
     * @param endDate   结束查询的时间位置  20240713
     * @return   返回到页面的是数据
     */
    public List  getStocks(String startDate,String endDate,Integer pageNow,String gpName){
        Integer PAGESIZE = 100;
        Integer start = (pageNow-1)*PAGESIZE;
        //return   abstractDao.getMaps("table_stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate,start.toString(),PAGESIZE.toString());
        return  abstractDao.getMaps("table_stock","*","yyyymmdd > "+startDate+" and yyyymmdd < "+endDate+" and gpName='"+gpName+"'",start.toString(),PAGESIZE.toString());
        //return  abstractDao.getMaps("table_stock","yyyymmdd",null);

    }

    public Boolean register(String username, String password, String phone, MultipartFile file){
        String path = this.getClass().getResource("/").getPath()+"web/";
        File  folder = new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }
        file.transferTo(new File(path+username+".jpg"));

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("phone",phone);
        map.put("header",username+".jpg");
        return abstractDao.insert("user",map);
    }

    public ResultTo login(String username,String password){
       Map user =  abstractDao.getMap("user","*","username='"+username+"' and password='"+password+"'");
       ResultTo resultTo = new ResultTo();  //存数据
       if(user==null){
           resultTo.value=null;
           resultTo.msg = "登录失败";
       }else {
           resultTo.value =user;
           resultTo.msg = "登录成功";
       }
       return resultTo;
    }
}




//select table_stock.yyyymmdd table_stock_yyyymmdd,table_stock.openrice table_stock_openrice,table_stock.closePrice table_stock_closePrice,table_stock.lowPrice table_stock_lowPrice,table_stock.hiPrice table_stock_hiPrice,table_stock.zhangfu table_stock_zhangfu,table_stock.gpName table_stock_gpName,table_stock.volume table_stock_volume from table_stock where yyyymmdd > 19990101 and yyyymmdd < 20240717 and gpName='张家界' limit 0,100