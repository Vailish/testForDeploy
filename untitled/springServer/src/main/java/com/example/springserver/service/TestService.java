package com.example.springserver.service;

import com.example.springserver.dto.CreateDataRequestDto;
import com.example.springserver.dto.CreateDataResponseDto;
import com.example.springserver.dto.DeleteDataResponseDto;
import com.example.springserver.dto.GetDataResponseDto;
import com.example.springserver.entity.Test;

import java.util.List;

public interface TestService {
     CreateDataResponseDto createData(CreateDataRequestDto requestDto);
     GetDataResponseDto getData(Long dataId);

     DeleteDataResponseDto deleteData(Long dataId);

     List<Test> getAllData();
}
