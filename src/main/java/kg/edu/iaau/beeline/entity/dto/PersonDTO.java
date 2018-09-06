package kg.edu.iaau.beeline.entity.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import kg.edu.iaau.beeline.transfer.TransferDTO;
import lombok.Data;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
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
}
