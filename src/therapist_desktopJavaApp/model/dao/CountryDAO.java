package therapist_desktopJavaApp.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import therapist_desktopJavaApp.model.entity.Country;

public class CountryDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_ALL =
            "SELECT country_id, country_name FROM tbl_country ORDER BY country_name";

    public List<Country> findAllCountries() {
        List<Country> list = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             
        		ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	
                Country c = new Country(
                    rs.getInt("country_id"),
                    rs.getString("country_name")
                );
                
                list.add(c);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
