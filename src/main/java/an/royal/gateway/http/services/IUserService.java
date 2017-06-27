package an.royal.gateway.http.services;

import an.royal.gateway.grpc.GreetServiceProto;

/**
 * Created by carl.huang on 27/06/2017.
 */
public interface IUserService {

    GreetServiceProto.HelloCommandAck sayHello(String requestId, String greeterId, String greeting);

}
