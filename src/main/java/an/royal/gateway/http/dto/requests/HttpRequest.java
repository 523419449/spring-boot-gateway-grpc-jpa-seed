package an.royal.gateway.http.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.core.util.UuidUtil;

/**
 * Created by carl.huang on 19/05/2017.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class HttpRequest {
    private String requestId = UuidUtil.getTimeBasedUuid().toString();

    public HttpRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
