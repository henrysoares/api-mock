package com.hensoares.application;

import com.hensoares.application.engine.MockProcessingContext;
import com.hensoares.application.engine.MockServiceEngine;
import com.hensoares.domain.entity.mock.MockMethodType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MockEngineApplicationService {

    private static final short MOCK_DEFAULT_PATH_OFFSET = 5;

    MockServiceEngine mockServiceEngine;

    public String processGetRequests(@NonNull HttpServletRequest request){
        final MockMethodType methodType = MockMethodType.parseString(request.getMethod());
        final String path = parsePath(request.getServletPath());

        final var context = new MockProcessingContext(path, methodType);

        final var response = mockServiceEngine.findMocksAndProcess(context);

        log.info("Response found.");

        return response;
    }

    private String parsePath(@NonNull final String path){
        return path.substring(MOCK_DEFAULT_PATH_OFFSET);
    }
}
