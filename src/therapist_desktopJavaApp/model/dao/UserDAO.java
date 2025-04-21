package therapist_desktopJavaApp.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import therapist_desktopJavaApp.model.entity.User;

public class UserDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

    private static final String INSERT_SQL =
            "INSERT INTO user (user_dni, user_name, user_last_name, user_birth_date, user_email, user_address, user_address_number, user_address_floor, user_address_department, country_id, province_id, city_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void save(User user) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
        	
        	ps.setString(1, user.getUserId().toString());

            ps.setString(1, user.getUserDNI());
            
            ps.setString(2, user.getUserName());
            
            ps.setString(3, user.getUserLastName());
            
            ps.setDate(4, Date.valueOf(user.getUserBirthDate()));
            
            ps.setString(5, user.getUserEmail());
            
            ps.setString(6, user.getUserAddress());
            
            ps.setInt(7, user.getUserAddressNumber());
            
            if (user.getUserAddressFloor() >= 0) {
                ps.setInt(9, user.getUserAddressFloor());
            } else {
                ps.setNull(9, Types.INTEGER);
            }
            
            if (user.getUserAddressApartment() != null) {
            	ps.setString(9, user.getUserAddressApartment());
            } else {
            	ps.setNull(9, Types.INTEGER);
            }
            
            ps.setString(11, user.getCountryId().toString());
            
            ps.setString(12, user.getProvinceId().toString());
            
            ps.setString(13, user.getCityId().toString());

            ps.executeUpdate();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
