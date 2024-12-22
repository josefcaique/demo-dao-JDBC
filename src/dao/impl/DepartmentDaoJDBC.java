package dao.impl;

import dao.DepartmentDao;
import db.DB;
import db.DbException;
import entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private final Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO department" +
                    "(Name) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            int rowAffected = st.executeUpdate();
            if (rowAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("unexpected error! no rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE department" +
                    " SET Name = ? where ID = ?", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department " +
                    "WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()){
                return instantiateDepartment(rs);
            }
            return null;
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();
        try{
            st = conn.prepareStatement("SELECT * FROM department");
            rs = st.executeQuery();
            while (rs.next()){
                Department dep = instantiateDepartment(rs);
                list.add(dep);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }

    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("ID"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
