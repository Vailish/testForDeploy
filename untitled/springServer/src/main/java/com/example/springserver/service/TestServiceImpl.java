package com.example.springserver.service;

import com.example.springserver.dto.CreateDataRequestDto;
import com.example.springserver.dto.CreateDataResponseDto;
import com.example.springserver.entity.Test;
import com.example.springserver.repository.TestRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

    @Override
    public CreateDataResponseDto createData(CreateDataRequestDto requestDto) {
        CreateDataResponseDto createDataResponseDto = new CreateDataResponseDto();
        Test test = new Test();
        test.setCnt(requestDto.getCnt());
        testRepository.save(test);
        return null;
    }
}
