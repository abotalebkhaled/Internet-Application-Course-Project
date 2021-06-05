package DAO;

import Models.Hotel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HotelDAO extends MySqlDAO<Hotel>
{
    public HotelDAO()
    {
        this.tableName = "hotels";
        this.primaryKey = "id";
        this.columns = "user_id, name, phone_number, image_path, rates, number_of_rates, stars, address, governorate, city, zipcode, longitude, latitude, creation_date";
        this.values = "?,?,?,?,?,?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected Hotel toTypeT(ResultSet _resultSet)
    {
        Hotel hotel = null;
        try
        {
            hotel = new Hotel();
            hotel.setId(_resultSet.getInt("id"));
            hotel.setUserId(_resultSet.getInt("user_id"));
            hotel.setName(_resultSet.getString("name"));
            hotel.setPhoneNumber(_resultSet.getString("phone_number"));
            hotel.setImagePath(_resultSet.getString("image_path"));
            hotel.setRates(_resultSet.getInt("rates"));
            hotel.setNumberOfRates(_resultSet.getInt("number_of_rates"));
            hotel.setStars(_resultSet.getInt("stars"));
            hotel.setAddress(_resultSet.getString("address"));
            hotel.setGovernorate(_resultSet.getString("governorate"));
            hotel.setCity(_resultSet.getString("city"));
            hotel.setZipcode(_resultSet.getString("zipcode"));
            hotel.setLongitude(_resultSet.getDouble("longitude"));
            hotel.setLatitude(_resultSet.getDouble("latitude"));
            hotel.setCreationDate(_resultSet.getString("creation_date"));
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
        
        return hotel;
    }

    @Override
    protected void setPreparedStatement(PreparedStatement _preparedStatement, Hotel _hotel)
    {
        try
        {
            _preparedStatement.setInt(1, _hotel.getUserId());
            _preparedStatement.setString(2, _hotel.getName());
            _preparedStatement.setString(3, _hotel.getPhoneNumber());
            _preparedStatement.setString(4, _hotel.getImagePath());
            _preparedStatement.setDouble(5, _hotel.getRates());
            _preparedStatement.setInt(6, _hotel.getNumberOfRates());
            _preparedStatement.setInt(7, _hotel.getStars());
            _preparedStatement.setString(8, _hotel.getAddress());
            _preparedStatement.setString(9, _hotel.getGovernorate());
            _preparedStatement.setString(10, _hotel.getCity());
            _preparedStatement.setString(11, _hotel.getZipcode());
            _preparedStatement.setDouble(12, _hotel.getLongitude());
            _preparedStatement.setDouble(13, _hotel.getLatitude());
            _preparedStatement.setString(14, _hotel.getCreationDate());
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
    }
    
}
