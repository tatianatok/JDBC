import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/postgres";
        final String user = "postgres";
        final String password = "1111";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)"); ) {

            statement.setInt(1, 1);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = "first_name: " + resultSet.getString("first_name");
                String lastName = "last_name: " + resultSet.getString("last_name");
                String gender = "gender: " + resultSet.getString("gender");
                String age = "age: " + resultSet.getInt("age");
                String city = "city_id: " + resultSet.getString("city_id");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city);

            }
        }
    }
}
