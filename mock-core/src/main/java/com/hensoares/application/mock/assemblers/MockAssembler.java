package com.hensoares.application.mock.assemblers;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.application.mock.acl.MockDTO;
import com.hensoares.application.mock.acl.MockDetailsDTO;
import com.hensoares.domain.entity.mock.Mock;
import com.hensoares.domain.entity.mock.details.MockDetails;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MockAssembler {

    private static final String EMPTY_STRING = "";

    public Mock assemble(@NonNull final MockDTO mockDTO){
        return Mock.builder()
                .mockName(mockDTO.mockName())
                .method(mockDTO.mockMethodType())
                .isActive(true)
                .build();
    }

    public MockDetails assembleMockDetails(@NonNull final MockDetailsDTO mockDetailsDTO, @NonNull final Mock mock){
        final String metadata = Optional.ofNullable(mockDetailsDTO.metadata())
                .map(JsonNode::toString).orElse(EMPTY_STRING);

        final String payload = Optional.ofNullable(mockDetailsDTO.payload())
                .map(JsonNode::toString).orElse(EMPTY_STRING);

        return MockDetails.builder()
                .mock(mock)
                .metadata(metadata)
                .payload(payload)
                .workflow(mockDetailsDTO.workflowType())
                .build();
    }

}
