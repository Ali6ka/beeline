package kg.edu.iaau.beeline.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import kg.edu.iaau.beeline.transfer.Groups;
import kg.edu.iaau.beeline.transfer.View;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@JsonPropertyOrder({"authToken"})
public class PersonDTO
{
    @Null(groups = {Groups.New.class, Groups.Update.class})
    private Integer id;

    @Null(groups = {Groups.Update.class})
    @NotNull(groups = {Groups.New.class})
    @JsonView({View.Details.class})
    private String username;

    @Null(groups = {Groups.Update.class})
    @NotNull(groups = {Groups.New.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(groups = {Groups.New.class})
    private String fullname;

    @NotNull(groups = {Groups.New.class})
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @NotNull(groups = {Groups.New.class})
    @JsonProperty(value = "is_admin")
    private Boolean isAdmin;

    @Null(groups = {Groups.New.class, Groups.Update.class})
    @JsonProperty(value = "auth_token", access = JsonProperty.Access.READ_ONLY)
    @JsonView({View.AuthDetails.class})
    private String authToken;

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

    public String getAuthToken()
    {
        return authToken;
    }

    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }
}
