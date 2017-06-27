package an.royal.gateway.http.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by carl.huang on 19/05/2017.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HttpResponse {
    private ErrorResp error;

    public HttpResponse() {
    }

    public HttpResponse(ErrorResp error) {
        this.error = error;
    }

    public ErrorResp getError() {
        return error;
    }

    public void setError(ErrorResp error) {
        this.error = error;
    }
}
