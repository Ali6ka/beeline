package kg.edu.iaau.beeline.entity.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import kg.edu.iaau.beeline.transfer.TransferDTO;
import lombok.Data;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class PersonDTO
{
    @Null(groups = {TransferDTO.New.class, TransferDTO.Update.class})
    private Integer id;

    @Null(groups = {TransferDTO.Update.class})
    @NotNull(groups = {TransferDTO.New.class})
    private String username;

    @Null(groups = {TransferDTO.Update.class})
    @NotNull(groups = {TransferDTO.New.class})
    private String password;

    @NotNull(groups = {TransferDTO.New.class})
    private String fullname;

    @NotNull(groups = {TransferDTO.New.class})
    private String phoneNumber;

    @NotNull(groups = {TransferDTO.New.class})
    private Boolean isAdmin;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsAdmin()
    {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }
}
