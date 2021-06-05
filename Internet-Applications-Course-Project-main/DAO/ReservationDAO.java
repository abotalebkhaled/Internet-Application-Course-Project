package DAO;

import Models.Reservation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ReservationDAO extends MySqlDAO<Reservation>
{
    public ReservationDAO()
    {
        this.tableName = "reservations";
        this.primaryKey = "id";
        this.columns = "user_id, room_id, start_date, end_date, status, is_paid, creation_date";
        this.values = "?,?,?,?,?,?,?";
    }
    
    @Override
    protected Reservation toTypeT(ResultSet _resultSet)
    {
        Reservation reservation = null;
        try
        {
            reservation = new Reservation();
            reservation.setId(_resultSet.getInt("id"));
            reservation.setUserId(_resultSet.getInt("user_id"));
            reservation.setRoomId(_resultSet.getInt("room_id"));
            reservation.setStartDate(_resultSet.getString("start_date"));
            reservation.setEndDate(_resultSet.getString("end_date"));
            reservation.setStatus(_resultSet.getString("status"));
            reservation.setIsPaid(_resultSet.getBoolean("is_paid"));
            reservation.setCreationDate(_resultSet.getString("creation_date"));
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
        
        return reservation;
    }

    @Override
    protected void setPreparedStatement(PreparedStatement _preparedStatement, Reservation _reservation)
    {
        try
        {
            _preparedStatement.setInt(1, _reservation.getUserId());
            _preparedStatement.setInt(2, _reservation.getUserId());
            _preparedStatement.setString(3, _reservation.getStartDate());
            _preparedStatement.setString(4, _reservation.getEndDate());
            _preparedStatement.setString(5, _reservation.getStatus());
            _preparedStatement.setBoolean(6, _reservation.getIsPaid());
            _preparedStatement.setString(8, _reservation.getCreationDate());
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }
    }
    
}
