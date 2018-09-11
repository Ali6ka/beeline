package kg.edu.iaau.core.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import static kg.edu.iaau.core.transfer.Groups.New;
import static kg.edu.iaau.core.transfer.Groups.Update;

public class PointDTO
{
    @Null(groups = {New.class, Update.class})
    private Integer id;

    @NotNull(groups = New.class)
    private String name;

    @Null(groups = Update.class)
    @NotNull(groups = New.class)
    @JsonProperty(value = "company_id")
    private Integer companyId;

    @NotNull(groups = New.class)
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @NotNull(groups = New.class)
    private String address;

    @NotNull(groups = New.class)
    private Long latitude;

    @NotNull(groups = New.class)
    private Long longitude;

    @JsonProperty(value = "user_id")
    private Integer userId;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(Integer companyId)
    {
        this.companyId = companyId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Long getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Long latitude)
    {
        this.latitude = latitude;
    }

    public Long getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Long longitude)
    {
        this.longitude = longitude;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
}
