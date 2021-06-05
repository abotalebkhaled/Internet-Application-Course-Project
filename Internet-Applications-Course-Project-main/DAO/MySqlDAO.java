package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import Utils.MySqlConnection;

public abstract class MySqlDAO<T> implements IDAO<T>
{      
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    protected String tableName;
    protected String primaryKey;
    protected String columns;
    protected String values;
    
    protected abstract T toTypeT(ResultSet _resultSet);
    protected abstract void setPreparedStatement(PreparedStatement _preparedStatement, T _t);
    
    public T get(int _id)
    {
        T t = null;
        String sql = "SELECT * FROM " + this.tableName + " WHERE " + this.primaryKey + " = ?";
        
        try
        {
            this.connection = MySqlConnection.openConnection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, _id);
            this.resultSet = this.preparedStatement.executeQuery();
            
            if(this.resultSet.next())
                t = this.toTypeT(this.resultSet);
        }
        catch(Exception _e)
        {
            _e.printStackTrace();
        }

        return t;
    }
    
    public List<T> getAll()
    {
        List<T> list = null;

        try
        {
            list = new ArrayList<T>();
            
            String sql = "SELECT * FROM " + this.tableName;
            this.connection = MySqlConnection.openConnection();
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);
            
            while(resultSet.next())
                list.add(this.toTypeT(this.resultSet));
        }
        catch(SQLException _e) 
        {
            _e.printStackTrace();
        }
        
        return list;
    }
    
    public int save(T _t)
    {
        int flag = 0;
        
        try
        {
            String sql = "INSERT INTO " + this.tableName + "(" + this.columns + ") VALUES(" + this.values + ")";
            this.connection = MySqlConnection.openConnection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.setPreparedStatement(this.preparedStatement, _t);
            flag = this.preparedStatement.executeUpdate();
        }
        catch(SQLException _ex) 
        {
            _ex.printStackTrace();
        }
        
        return flag;
    }
    
    //public void update(T _t, String[] _params);
    
    public boolean delete(int _id)
    {
        boolean flag = false;
        try
        {
            String sql = "DELETE FROM " + this.tableName + " WHERE " + this.primaryKey + " = ?";
            
            this.connection = MySqlConnection.openConnection();
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, _id);
            this.preparedStatement.executeUpdate();
            
            flag = true;
        }
        catch(SQLException _e)
        {
            _e.printStackTrace();
        }
        
        return flag;
    }
}