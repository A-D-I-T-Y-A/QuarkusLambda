package org.versionx;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbEnhancedClient;

@Named("test")
public class TestLambda implements RequestHandler<InputObject, OutputObject> {

    @Inject
    ProcessingService service;

    @Override
    public OutputObject handleRequest(InputObject input, Context context) {



        FruitEnhancedSyncService fruitService = new FruitEnhancedSyncService(DynamoDbEnhancedClient.builder().build());

        OutputObject obj = new OutputObject();
        obj.setResult(fruitService.get("Apple").toString());
        return obj;
//        return service.process(input).setRequestId(context.getAwsRequestId());
    }
}
