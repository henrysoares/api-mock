package com.hensoares.application;

import com.hensoares.application.mock.MockService;
import com.hensoares.application.mock.acl.MockDTO;
import com.hensoares.application.mock.acl.MockDetailsDTO;
import com.hensoares.interfaces.mock.dto.MockCreationRequest;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MockApplicationService {

    MockService mockService;

    public void createMock(@NonNull final MockCreationRequest request){
        var mockDto = new MockDTO(
                request.mockName(),
                request.mockMethodType(),
                request.payload(),
                request.path(),
                request.workflowType(),
                request.metadata());

        mockService.createMock(mockDto);
    }

}
