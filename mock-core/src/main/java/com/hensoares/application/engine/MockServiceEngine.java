package com.hensoares.application.engine;

import com.hensoares.application.mock.MockService;
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

    public String findMocksAndProcess(@NonNull final MockProcessingContext context){
        final var mock = mockService.findMockByPathAndMethod(context.path(), context.methodType());
        return mock.getPayload();
    }

}
