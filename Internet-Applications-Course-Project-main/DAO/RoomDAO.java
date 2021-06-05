package DAO;

import Models.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomDAO extends MySqlDAO<Room>
{
    public RoomDAO()
    {
        this.tableName = "rooms";
        this.primaryKey = "id";
        this.columns = "hotel_id, facility_id, number, status, type, number_of_adults, number_of_children, price_per_day, creation_date";
        this.values = "?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected Room toTypeT(ResultSet _resultSet)
    {
        Room room = null;
        try
        {
            room = new Room();
            room.setId(_resultSet.getInt("id"));
            room.setHotelId(_resultSet.getInt("hotel_id"));
            room.setFacilityId(_resultSet.getInt("facility_id"));
            room.setNumber(_resultSet.getInt("number"));
            room.setStatus(_resultSet.getInt("status"));
            room.setType(_resultSet.getString("type"));
            room.setNumberOfAdults(_resultSet.getInt("number_of_adults"));
            room.setNumberOfChildren(_resultSet.getInt("number_of_children"));
            room.setPricePerDay(_resultSet.getInt("price_per_day"));
            room.setCreationDate(_resultSet.getString("creation_date"));
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
        
        return room;
    }

    @Override
    protected void setPreparedStatement(PreparedStatement _preparedStatement, Room _room)
    {
        try
        {
            _preparedStatement.setInt(1, _room.getHotelId());
            _preparedStatement.setInt(2, _room.getFacilityId());
            _preparedStatement.setInt(3, _room.getNumber());
            _preparedStatement.setInt(4, _room.getStatus());
            _preparedStatement.setString(5, _room.getType());
            _preparedStatement.setInt(6, _room.getNumberOfAdults());
            _preparedStatement.setInt(7, _room.getNumberOfChildren());
            _preparedStatement.setInt(8, _room.getPricePerDay());
            _preparedStatement.setString(9, _room.getCreationDate());
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
    }
}
