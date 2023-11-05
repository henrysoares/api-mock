package com.hensoares.application.mock;

import com.hensoares.application.mock.acl.MockDTO;
import com.hensoares.application.mock.assemblers.MockAssembler;
import com.hensoares.application.mock.exceptions.MockCreationException;
import com.hensoares.application.mock.exceptions.MockNotFoundException;
import com.hensoares.domain.entity.mock.Mock;
import com.hensoares.domain.entity.mock.MockMethodType;
import com.hensoares.domain.entity.mock.repository.MockRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class that contains all the logic for creating, executing, and managing the mock.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MockService {

    MockRepository mockRepository;

    MockAssembler mockAssembler;

    /**
     * Method responsible for creating and persisting mock entity on database.
     * @param mockDTO Mock request.
     */
    public void createMock(@NonNull final MockDTO mockDTO){
        try{
            final Mock mock = mockAssembler.assemble(mockDTO);

            mockRepository.save(mock);
            log.info("Mock successfully created.");
        } catch (Exception exception){
            log.error("Was not possible to create the mock.", exception);

            throw new MockCreationException(exception);
        }
    }

    public Mock findMockByPathAndMethod(@NonNull final String path, @NonNull final MockMethodType methodType){
        return mockRepository.findByPathAndMethod(path, methodType)
                .orElseThrow(()-> new MockNotFoundException(path, methodType));
    }

}
