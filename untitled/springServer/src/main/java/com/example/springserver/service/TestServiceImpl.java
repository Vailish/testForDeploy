package com.example.springserver.service;

import com.example.springserver.dto.CreateDataRequestDto;
import com.example.springserver.dto.CreateDataResponseDto;
import com.example.springserver.dto.DeleteDataResponseDto;
import com.example.springserver.dto.GetDataResponseDto;
import com.example.springserver.entity.Test;
import com.example.springserver.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        createDataResponseDto.setCnt(requestDto.getCnt());
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
    public DeleteDataResponseDto deleteData(Long dataId) {
        DeleteDataResponseDto deleteDataResponseDto = new DeleteDataResponseDto();
        deleteDataResponseDto.setTestId(dataId);
        if (testRepository.existsById(dataId)) {
            try {
                testRepository.deleteById(dataId);
                deleteDataResponseDto.setResult(true);
            } catch (Exception e) {
                deleteDataResponseDto.setResult(false);
            }
        } else deleteDataResponseDto.setResult(false);

        return deleteDataResponseDto;
    }

    @Override
    public List<Test> getAllData() {
        try {
            return testRepository.findAllBy();
        } catch (Exception e) {
            return null;
        }
    }
}
