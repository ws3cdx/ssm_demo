package com.ws3cdx.dao;

import com.ws3cdx.model.Cust;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustDao {
    @Select("SELECT * FROM s_cust")
    List<Cust> showAll();

    @Insert("INSERT INTO s_cust (cust_name,cust_type,cust_phone,cust_address,cust_link_user) VALUES (#{cust_name},#{cust_type},#{cust_phone},#{cust_address},#{cust_link_user})")
    int add(Cust cust);

    @Select("SELECT * FROM s_cust WHERE cust_name LIKE #{custType}")
    List<Cust> tomerName(String custName);

    @Select("SELECT * FROM s_cust WHERE cust_name LIKE #{custType} AND cust_type LIKE #{custType}")
    List<Cust> tomerNT(@Param("custName") String custName, @Param("custType") String custType);
}
