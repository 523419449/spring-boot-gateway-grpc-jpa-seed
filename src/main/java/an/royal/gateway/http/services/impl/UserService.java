package an.royal.gateway.http.services.impl;

import an.royal.gateway.grpc.GreetServiceGrpc;
import an.royal.gateway.grpc.GreetServiceProto;
import an.royal.gateway.http.services.GrpcServiceClient;
import an.royal.gateway.http.services.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by carl.huang on 27/06/2017.
 */
@Service
public class UserService extends GrpcServiceClient implements IUserService {

    public UserService(
            @Value("${grpc.service.user-service.host}") String host,
            @Value("${grpc.service.user-service.port}")Integer port) {
        super(host, port);
    }

    @Override
    public GreetServiceProto.HelloCommandAck sayHello(String requestId, String greeterId, String greeting) {
        GreetServiceGrpc.GreetServiceBlockingStub blockingStub = GreetServiceGrpc.newBlockingStub(super.channel);
        GreetServiceProto.HelloCommand command = GreetServiceProto.HelloCommand.newBuilder()
                .setEventId(requestId)
                .setName(greeterId)
                .setGreeting(greeting)
                .build();

        return blockingStub.sayHello(command);
    }

}
