package collectionexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.id = 564;
        emp.ename = "ajai";
        emp.sal = 10000;

        try {
            emp.doj = new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-11");
            emp.dob = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        emp.des = "karur";
        emp.dept = "IT";
        emp.address = "Karunelivalasu, karur";
        emp.photo = "img.jpg";

        PreparedStatement pst = null;
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb1", "root", "root");

            String sql = "INSERT INTO employees (emp_address, emp_department, emp_designation, emp_name, emp_photo, emp_dob, emp_doj, emp_id, emp_salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getAddress());
            pst.setString(2, emp.getDept());
            pst.setString(3, emp.getDes());
            pst.setString(4, emp.getEname());
            pst.setString(5, emp.getPhoto());
            pst.setDate(6, new java.sql.Date(emp.getDob().getTime()));
            pst.setDate(7, new java.sql.Date(emp.getDoj().getTime()));
            pst.setInt(8, emp.getId());
            pst.setFloat(9, emp.getSal());

            pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
