package an.royal.gateway.http.dto.responses;

/**
 * Created by carl.huang on 19/05/2017.
 */
public class SayHelloResp extends HttpResponse {
    private String greeting;

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
