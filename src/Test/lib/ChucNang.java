package Test.lib;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChucNang {
    public void getAllData() throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connect();

        String query = "select * from teachers";
        Statement statement = connectJDBC.connect().createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Boolean gender = resultSet.getBoolean("gender");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");

            System.out.println("id : " + id + " -name: " + name + " -gender: " + gender + " -age: " + age + " -address: " + address);
        }
    }

    public static void insertData(Teacher newTeacher) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connect();

        String query = "insert into teachers (id,name,gender,age,address) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connectJDBC.connect().prepareStatement(query);

        preparedStatement.setInt(1,newTeacher.getId());
        preparedStatement.setString(2,newTeacher.getName());
        preparedStatement.setBoolean(3,newTeacher.isGender());
        preparedStatement.setInt(4,newTeacher.getAge());
        preparedStatement.setString(5,newTeacher.getAddress());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public static void deleteDataId(int deleteId) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connect();

        String query = "delete from teachers where id = ?";
        PreparedStatement preparedStatement = connectJDBC.connect().prepareStatement(query);
        preparedStatement.setInt(1,deleteId);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
