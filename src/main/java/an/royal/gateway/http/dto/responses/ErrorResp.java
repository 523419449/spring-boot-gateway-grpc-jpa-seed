package an.royal.gateway.http.dto.responses;

import an.royal.gateway.http.constants.ResponseErrorCode;

/**
 * Created by carl.huang on 19/05/2017.
 */
public class ErrorResp {
    private ResponseErrorCode code;
    private String message;

    public ErrorResp() {
    }

    public ErrorResp(ResponseErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code.getCode();
    }

    public void setCode(ResponseErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
