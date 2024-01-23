package com.example.springserver.service;

import com.example.springserver.dto.CreateDataRequestDto;
import com.example.springserver.dto.CreateDataResponseDto;
import com.example.springserver.dto.DeleteDataResponseDto;
import com.example.springserver.dto.GetDataResponseDto;
import com.example.springserver.entity.Test;
import com.example.springserver.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

    @Override
    public CreateDataResponseDto createData(CreateDataRequestDto requestDto) {
        CreateDataResponseDto createDataResponseDto = new CreateDataResponseDto();
        Test test = new Test();
        test.setCnt(requestDto.getCnt());
        try {
            testRepository.save(test);
        } catch (Exception e) {
            return null;
        }
        createDataResponseDto.setResult(true);
        createDataResponseDto.setCnt(createDataResponseDto.getCnt());
        return createDataResponseDto;
    }

    @Override
    public GetDataResponseDto getData(Long dataId) {
        Test test = testRepository.findByTestId(dataId);
        GetDataResponseDto getDataResponseDto = new GetDataResponseDto();
        getDataResponseDto.setTestId(test.getTestId());
        getDataResponseDto.setCnt(test.getCnt());
        return getDataResponseDto;
    }

    @Override
    public DeleteDataResponseDto deleteData(Long id) {
        DeleteDataResponseDto deleteDataResponseDto = new DeleteDataResponseDto();
        deleteDataResponseDto.setTestId(id);
        try {
            testRepository.deleteById(id);
            deleteDataResponseDto.setResult(true);
        } catch (Exception e) {
            deleteDataResponseDto.setResult(false);
        }
        return deleteDataResponseDto;
    }
}
