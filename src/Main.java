import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Maria", "maria@gmail.com", new Date(),3000.0, obj);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(seller);
    }
}