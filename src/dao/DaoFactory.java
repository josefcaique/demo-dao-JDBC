package dao;

import dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
