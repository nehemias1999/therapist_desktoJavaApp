package therapist_desktopJavaApp.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import therapist_desktopJavaApp.model.entity.City;

public class CityDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_BY_PROV =
        "SELECT city_id, city_name, city_zip_code, province_id " +
        "FROM tbl_city WHERE province_id = ? ORDER BY city_name";

    public List<City> findCitiesByProvinceId(UUID provinceId) {
        List<City> list = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_PROV)) {
        	
            ps.setString(1, provinceId.toString());
            try (ResultSet rs = ps.executeQuery()) {
                
            	while (rs.next()) {
            		
                    City c = new City(
                    		
                    		UUID.fromString(rs.getString("city_id")),
                            rs.getString("city_name"),
                            rs.getString("city_zip_code"),
                            UUID.fromString(rs.getString("province_id"))
                            
                    );
                    
                    list.add(c);
                }
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
