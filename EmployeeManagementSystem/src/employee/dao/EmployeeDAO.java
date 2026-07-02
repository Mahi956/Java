package employee.dao;

import employee.database.DBConnection;
import employee.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {

        String query =
                "INSERT INTO employees(name,department,salary) VALUES(?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDepartment());
            ps.setDouble(3, employee.getSalary());

            ps.executeUpdate();

            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {

        String query = "SELECT * FROM employees";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " | "
                                + rs.getString("name")
                                + " | "
                                + rs.getString("department")
                                + " | "
                                + rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateEmployee(int id, double salary) {

        String query =
                "UPDATE employees SET salary=? WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Employee Updated Successfully");
            }
            else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteEmployee(int id){
        String query = "DELETE FROM employees WHERE id=?" ;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)

                ) {
            ps .setInt(1,id);
            int rows = ps.executeUpdate();

            if (rows > 0){
                System.out.println("Employee Deleted successfully");
            }else{
                System.out.println("Employee not Found");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void searchEmployee(int id ){
        String query = "SELECT * FEOM employees WHERE id=?";
        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
;                ){
            ps .setInt(1,id);

            ResultSet rs =ps.executeQuery();

            if (rs.next()){
                System.out.println("\nEmployee Founded");

                System.out.println(
                        rs.getInt("id")
                                + " | "
                                + rs.getString("name")
                                + " | "
                                + rs.getString("department")
                                + " | "
                                + rs.getDouble("salary")
                );
            }else {
                System.out.println("Employee Not Found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
