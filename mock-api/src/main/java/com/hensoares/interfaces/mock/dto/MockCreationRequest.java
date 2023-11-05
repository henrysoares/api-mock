package com.hensoares.interfaces.mock.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.domain.entity.mock.MockMethodType;
import com.hensoares.domain.entity.mock.WorkflowType;
import lombok.NonNull;

/**
 * Record that represents a request to create a new mock.
 * @param mockName
 * @param mockMethodType
 */
public record MockCreationRequest(
        @NonNull String mockName,
        @NonNull MockMethodType mockMethodType,
        @NonNull JsonNode payload,
        @NonNull String path,
        WorkflowType workflowType,
        JsonNode metadata) {
}
