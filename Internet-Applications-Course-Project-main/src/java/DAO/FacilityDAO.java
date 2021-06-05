package DAO;

import Models.Facility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FacilityDAO extends MySqlDAO<Facility>
{
    public FacilityDAO()
    {
        this.tableName = "facilities";
        this.primaryKey = "id";
        this.columns = "room_id, name";
        this.values = "?,?";
    }

    @Override
    protected Facility toTypeT(ResultSet _resultSet)
    {
        Facility facility = null;
        try
        {
            facility = new Facility();
            facility.setId(_resultSet.getInt("id"));
            facility.setRoomId(_resultSet.getInt("room_id"));
            facility.setName(_resultSet.getString("name"));
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
        
        return facility;
    }

    @Override
    protected void setPreparedStatement(PreparedStatement _preparedStatement, Facility _facility)
    {
        try
        {
            _preparedStatement.setInt(1, _facility.getRoomId());
            _preparedStatement.setString(2, _facility.getName());
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
    }
    
}
