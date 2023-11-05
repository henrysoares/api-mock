package com.hensoares.application.mock.assemblers;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.application.mock.acl.MockDTO;
import com.hensoares.application.mock.acl.MockDetailsDTO;
import com.hensoares.domain.entity.mock.Mock;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Class that contains the logic for assembling the entities related to mock.
 */
@Component
public class MockAssembler {

    private static final String EMPTY_STRING = "";

    /**
     * Method Responsible for assembling {@link Mock} entity.
     * @param mockDTO The dto request.
     * @return The entity assembled.
     */
    public Mock assemble(@NonNull final MockDTO mockDTO){
        final var payload = Optional.ofNullable(mockDTO.payload()).map(JsonNode::toString).orElse(EMPTY_STRING);
        final var metadata = Optional.ofNullable(mockDTO.metadata()).map(JsonNode::toString).orElse(EMPTY_STRING);

        return Mock.builder()
                .mockName(mockDTO.mockName())
                .method(mockDTO.mockMethodType())
                .isActive(true)
                .payload(payload)
                .status(mockDTO.status())
                .metadata(metadata)
                .path(mockDTO.path())
                .workflow(mockDTO.workflowType())
                .build();
    }
}
