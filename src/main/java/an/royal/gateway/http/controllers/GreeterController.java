package an.royal.gateway.http.controllers;

import an.royal.gateway.grpc.GreetServiceGrpc;
import an.royal.gateway.grpc.GreetServiceProto;
import an.royal.gateway.http.constants.ResponseErrorCode;
import an.royal.gateway.http.dto.req.SayHelloReq;
import an.royal.gateway.http.dto.resp.ErrorResp;
import an.royal.gateway.http.dto.resp.HttpResponse;
import an.royal.gateway.http.dto.resp.SayHelloResp;
import an.royal.gateway.http.services.IEncodeService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by carl.huang on 12/05/2017.
 */
@RestController
@RequestMapping("/greet")
public class GreeterController {
    private static final Logger log = LoggerFactory.getLogger(GreeterController.class);

    // For demonstrating error response
    private List<String> validUserNames = Arrays.asList("Royalan", "Carl", "Cockroach");

    private IEncodeService encodeService;

    private String greetServiceHost;
    private Integer greetServicePort;

    /**
     * Greet to service.
     *
     * @param greeter
     * @param req     - SayHelloReq
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{greeter}", method = RequestMethod.POST)
    public ResponseEntity<?> sayHello(@PathVariable String greeter, @RequestBody SayHelloReq req) {
        log.debug("Received request to say hello!");
        if (!validUserNames.contains(greeter)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new HttpResponse(
                            req.getRequestId(),
                            new ErrorResp(ResponseErrorCode.USER_NOT_FOUND, "Cannot find user.")));
        }

        ManagedChannel channel = ManagedChannelBuilder.forAddress(greetServiceHost, greetServicePort).usePlaintext(true).build();
        GreetServiceGrpc.GreetServiceBlockingStub blockingStub = GreetServiceGrpc.newBlockingStub(channel);

        GreetServiceProto.HelloCommand command = GreetServiceProto.HelloCommand.newBuilder()
                .setEventId(UUID.randomUUID().toString())
                .setName(greeter)
                .setGreeting(req.getGreeting())
                .build();

        GreetServiceProto.HelloCommandAck ack = blockingStub.sayHello(command);
        log.info("Got response from gRPC server: {}", ack);

        return ResponseEntity.ok(new SayHelloResp(ack.getMessage()));
    }


    @Autowired
    public void setEncodeService(IEncodeService encodeService) {
        this.encodeService = encodeService;
    }

    @Value("${greet.service.grpc.host}")
    public void setGreetServiceHost(String greetServiceHost) {
        this.greetServiceHost = greetServiceHost;
    }

    @Value("${greet.service.grpc.port}")
    public void setGreetServicePort(Integer greetServicePort) {
        this.greetServicePort = greetServicePort;
    }
}
