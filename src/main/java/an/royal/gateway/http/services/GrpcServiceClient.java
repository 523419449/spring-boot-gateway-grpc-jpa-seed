package an.royal.gateway.http.services;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Created by carl.huang on 27/06/2017.
 */
public abstract class GrpcServiceClient {
    protected ManagedChannel channel;

    public GrpcServiceClient(String host, Integer port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
    }

}
