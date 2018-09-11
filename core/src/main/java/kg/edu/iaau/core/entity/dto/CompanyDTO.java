package kg.edu.iaau.core.entity.dto;

import javax.validation.constraints.Null;

import static kg.edu.iaau.core.transfer.Groups.New;
import static kg.edu.iaau.core.transfer.Groups.Update;

public class CompanyDTO
{
    @Null(groups = {New.class, Update.class})
    private Integer id;

    private String name;

    private String website;

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

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }
}
