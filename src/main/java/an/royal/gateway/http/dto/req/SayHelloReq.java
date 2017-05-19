package an.royal.gateway.http.dto.req;

/**
 * Created by carl.huang on 19/05/2017.
 */
public class SayHelloReq extends HttpRequest {
    private String greeting;

    public SayHelloReq() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
