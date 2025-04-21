package therapist_desktopJavaApp.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import therapist_desktopJavaApp.model.entity.Province;

public class ProvinceDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_ALL =
        "SELECT province_id, province_name, country_id FROM tbl_province ORDER BY province_name";
    
    private static final String SELECT_BY_COUNTRY =
            "SELECT province_id, province_name, country_id " +
            "FROM tbl_province WHERE province_id = ? ORDER BY province_name";
    
    public List<Province> findAll() {
        List<Province> list = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             
        		ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	
                Province p = new Province(
                		
                    rs.getInt("province_id"),
                    rs.getString("province_name"),
                    rs.getInt("country_id")
                );
                
                list.add(p);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Province> findProvincesByCountryId(int countryId) {
        List<Province> list = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_COUNTRY)) {
        	
            ps.setInt(1, countryId);
            try (ResultSet rs = ps.executeQuery()) {
                
            	while (rs.next()) {
            		
                    Province p = new Province(
                    		
                		rs.getInt("province_id"),
                        rs.getString("province_name"),
                        rs.getInt("country_id")
                            
                    );
                    
                    list.add(p);
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