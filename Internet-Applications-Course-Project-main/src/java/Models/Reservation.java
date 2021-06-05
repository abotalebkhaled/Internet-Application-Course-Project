package Models;


public class Reservation
{
    private int id;
    private int userId;
    private int roomId;
    private String startDate;
    private String endDate;
    private String status;
    private boolean isPaid;
    private String creationDate;

    public int getId()
    {
        return this.id;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public int getRoomId()
    {
        return this.roomId;
    }

    public String getStartDate()
    {
        return this.startDate;
    }

    public String getEndDate()
    {
        return this.endDate;
    }

    public String getStatus()
    {
        return this.status;
    }

    public boolean getIsPaid()
    {
        return this.isPaid;
    }

    public String getCreationDate()
    {
        return this.creationDate;
    }

    public void setId(int _id)
    {
        this.id = _id;
    }

    public void setUserId(int _userId)
    {
        this.userId = userId;
    }

    public void setRoomId(int _roomId)
    {
        this.roomId = _roomId;
    }

    public void setStartDate(String _startDate)
    {
        this.startDate = _startDate;
    }

    public void setEndDate(String _endDate)
    {
        this.endDate = _endDate;
    }

    public void setStatus(String _status)
    {
        this.status = _status;
    }

    public void setIsPaid(boolean _isPaid)
    {
        this.isPaid = _isPaid;
    }

    public void setCreationDate(String _creationDate)
    {
        this.creationDate = _creationDate;
    }

    @Override
    public String toString()
    {
        return "Reservation{" + 
                "id=" + this.id + 
                ", userId=" + this.userId + 
                ", roomId=" + this.roomId + 
                ", startDate=" + this.startDate + 
                ", endDate=" + this.endDate + 
                ", status=" + this.status + 
                ", isPaid=" + this.isPaid + 
                ", creationDate=" + this.creationDate + '}';
    }

    
}
