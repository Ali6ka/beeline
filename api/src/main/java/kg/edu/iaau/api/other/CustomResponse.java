package kg.edu.iaau.api.other;

public class CustomResponse
{
    private String status;

    private String message;

    private Object data;

    public CustomResponse()
    {
    }

    public CustomResponse(String status, String message)
    {
        this.status = status;
        this.message = message;
        this.data = new Object();
    }

    public CustomResponse(String status, String message, Object data)
    {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
