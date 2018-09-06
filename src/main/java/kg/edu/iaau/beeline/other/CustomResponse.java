package kg.edu.iaau.beeline.other;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class CustomResponse
{
    private String status;

    private String message;

    private Object data;

    public CustomResponse(String status, String message)
    {
        this.status = status;
        this.message = message;
        this.data = Collections.EMPTY_LIST;
    }

    public CustomResponse(String status, String message, Object data)
    {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
