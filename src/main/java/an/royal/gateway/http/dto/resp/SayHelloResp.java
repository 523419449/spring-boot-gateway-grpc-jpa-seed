package an.royal.gateway.http.dto.resp;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by carl.huang on 19/05/2017.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SayHelloResp extends HttpResponse {
    private String greeting;

    public SayHelloResp(String requestId) {
        super(requestId);
    }

    public SayHelloResp(String requestId, String greeting) {
        super(requestId);
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
