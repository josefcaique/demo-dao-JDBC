import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: finding by id ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 1: finding by department ===");
        Department department = new Department(2, null);
        List<Seller> list  = sellerDao.findByDepartment(department);
        for (Seller obj: list){
            System.out.printf("Name: %s%n", obj.getName());
        }
    }
}