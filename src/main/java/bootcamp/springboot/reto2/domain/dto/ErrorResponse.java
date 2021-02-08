package bootcamp.springboot.reto2.domain.dto;


import lombok.Data;

@Data

public class ErrorResponse {

    private int code;
    private String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
