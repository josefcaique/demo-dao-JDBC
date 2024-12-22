import dao.DaoFactory;
import dao.DepartmentDao;
import dao.SellerDao;
import dao.impl.SellerDaoJDBC;
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

        System.out.println("\n=== TEST 2: finding by department ===");
        Department department = new Department(2, null);
        List<Seller> list  = sellerDao.findByDepartment(department);
        for (Seller obj: list){
            System.out.printf("Name: %s%n", obj.getName());
        }

        System.out.println("\n=== TEST 3: finding all ===");
        List<Seller> list2  = sellerDao.findAll();
        for (Seller obj: list2){
            System.out.printf("Name: %s%n", obj.getName());
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("update Completed");

        System.out.println("\n=== TEST 6: seller delete ===");
        sellerDao.deleteById(newSeller.getId());
        System.out.println("Seller Deleted");


        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("\n=== TEST 2.1: finding by id ===");
        Department department1 = departmentDao.findById(3);
        System.out.println(department1);

        System.out.println("\n=== TEST 2.5: department update ===");
        department1 = departmentDao.findById(4);
        department1.setName("RH");
        departmentDao.update(department1);
        System.out.println("Department updated");
    }
}