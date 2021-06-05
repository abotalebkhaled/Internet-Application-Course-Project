package Models;

public class Room
{
    private int id;
    private int hotelId;
    private int facilityId;
    private int number;
    private int status;
    private String type;
    private int numberOfAdults;
    private int numberOfChildren;
    private int pricePerDay;
    private String creationDate;

    public int getId()
    {
        return this.id;
    }

    public int getHotelId()
    {
        return this.hotelId;
    }

    public int getFacilityId()
    {
        return this.facilityId;
    }

    public int getNumber()
    {
        return this.number;
    }

    public int getStatus()
    {
        return this.status;
    }

    public String getType()
    {
        return this.type;
    }

    public int getNumberOfAdults()
    {
        return this.numberOfAdults;
    }

    public int getNumberOfChildren()
    {
        return this.numberOfChildren;
    }

    public int getPricePerDay()
    {
        return this.pricePerDay;
    }

    public String getCreationDate()
    {
        return this.creationDate;
    }

    public void setId(int _id)
    {
        this.id = _id;
    }

    public void setHotelId(int _hotelId)
    {
        this.hotelId = _hotelId;
    }

    public void setFacilityId(int _facilityId)
    {
        this.facilityId = _facilityId;
    }

    public void setNumber(int _number)
    {
        this.number = _number;
    }

    public void setStatus(int _status)
    {
        this.status = _status;
    }

    public void setType(String _type)
    {
        this.type = _type;
    }

    public void setNumberOfAdults(int _numberOfAdults)
    {
        this.numberOfAdults = _numberOfAdults;
    }

    public void setNumberOfChildren(int _numberOfChildren)
    {
        this.numberOfChildren = _numberOfChildren;
    }

    public void setPricePerDay(int _pricePerDay)
    {
        this.pricePerDay = _pricePerDay;
    }

    public void setCreationDate(String _creationDate)
    {
        this.creationDate = _creationDate;
    }

    @Override
    public String toString()
    {
        return "Room{" + 
                "id=" + this.id + 
                ", hotelId=" + this.hotelId + 
                ", facilityId=" + this.facilityId + 
                ", number=" + this.number + 
                ", status=" + this.status + 
                ", type=" + this.type + 
                ", numberOfAdults=" + this.numberOfAdults + 
                ", numberOfChildren=" + this.numberOfChildren + 
                ", pricePerDay=" + this.pricePerDay + 
                ", creationDate=" + this.creationDate + '}';
    }
}
