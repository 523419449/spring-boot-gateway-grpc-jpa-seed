package an.royal.gateway.http.dto.responses;

import an.royal.gateway.http.constants.ResponseErrorCode;

/**
 * Created by carl.huang on 19/05/2017.
 */
public class ErrorResp {
    private String requestID;
    private ResponseErrorCode code;
    private String message;

    public ErrorResp(String requestID) {
        this.requestID = requestID;
    }

    public ErrorResp(String requestID, ResponseErrorCode code, String message) {
        this.requestID = requestID;
        this.code = code;
        this.message = message;
    }

    public String getRequestID() {
        return requestID;
    }

    public String getCode() {
        return code.getCode();
    }

    public void setCode(ResponseErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return requestID + " - " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
