package an.royal.gateway.http.services.impl;

import an.royal.gateway.grpc.GreetServiceGrpc;
import an.royal.gateway.grpc.GreetServiceProto;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * Created by carl.huang on 27/06/2017.
 */
public class GrpcService {

    @GRpcService
    static class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

        @Override
        public void sayHello(GreetServiceProto.HelloCommand request, StreamObserver<GreetServiceProto.HelloCommandAck> responseObserver) {
            GreetServiceProto.HelloCommandAck ack = GreetServiceProto.HelloCommandAck.newBuilder()
                    .setMessage("There is a greeting from gRPC server :D")
                    .setVersion(1L)
                    .build();
            responseObserver.onNext(ack);
            responseObserver.onCompleted();
        }
    }
}
