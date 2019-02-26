package com.ws3cdx.service;

import com.ws3cdx.model.Cust;

import java.util.List;

public interface CustService {
    List<Cust> showAll();

    int add(Cust cust);

    List<Cust> tomer(String custName, String custType);
}
