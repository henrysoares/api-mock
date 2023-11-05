package com.hensoares.application.engine;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.hensoares.application.mock.MockService;
import com.hensoares.application.mock.acl.MockDTO;
import com.hensoares.infrastructure.util.safeoperation.SafeOperations;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MockServiceEngine {

    MockService mockService;

    public MockDTO findMocksAndProcess(@NonNull final MockProcessingContext context){
        final ObjectMapper objectMapper = new ObjectMapper();
        final var mock = mockService.findMockByPathAndMethod(context.path(), context.methodType());

        final var payload =
                SafeOperations.doOperationAndReturn(()-> objectMapper.readTree(mock.getPayload()))
                .getOutput();

        final var metadata =
                SafeOperations.doOperationAndReturn(()-> objectMapper.readTree(mock.getMetadata()))
                        .getOutput();

        return new MockDTO(
                mock.getMockName(),
                mock.getMethod(),
                payload,
                mock.getStatus(),
                mock.getPath(),
                mock.getWorkflow(),
                metadata
        );
    }

}
