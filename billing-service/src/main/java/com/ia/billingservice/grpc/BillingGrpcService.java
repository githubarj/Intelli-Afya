package com.ia.billingservice.grpc;


import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(
            BillingGrpcService.class
    );

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest, StreamObserver<BillingResponse> responseObserver) {

        log.info("Create Billing Account Request Received: {}", billingRequest.toString()); // to see server is accepting requests

        // Business logic - eg save to database, perform calculations etc

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response); // send response from our service
        responseObserver.onCompleted(); // the response is completed and we are ready to end the cycle for this response, we can send multiple responses

    }
}
