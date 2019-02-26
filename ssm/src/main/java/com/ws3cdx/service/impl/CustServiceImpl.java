package com.ws3cdx.service.impl;

import com.ws3cdx.dao.CustDao;
import com.ws3cdx.dao.UserDao;
import com.ws3cdx.model.Cust;
import com.ws3cdx.model.User;
import com.ws3cdx.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustServiceImpl implements CustService {
    @Autowired
    private CustDao custDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Cust> showAll() {
        List<Cust> custs = custDao.showAll();
        for (Cust cust : custs) {
            String uid = cust.getCust_link_user();
            User user = userDao.chechUserByUId(uid);
            cust.setUser(user);
        }

        return custs;
    }

    @Override
    public int add(Cust cust) {
        return custDao.add(cust);
    }

    @Override
    public List<Cust> tomer(String custName, String custType) {
        List<Cust> custs = null;
        if (custName != null && !custName.equals("")) {
            custName = "%" + custName + "%";
            if (custType != null && !custType.equals("")) {
                custType = "%" + custType + "%";
                custs = custDao.tomerNT(custName, custType);
            } else {
                custs = custDao.tomerName(custName);
            }
            for (Cust cust : custs) {
                String uid = cust.getCust_link_user();
                User user = userDao.chechUserByUId(uid);
                cust.setUser(user);
            }
        }
        return custs;
    }
}
