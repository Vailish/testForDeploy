package com.example.springserver.service;

import com.example.springserver.dto.CreateDataRequestDto;
import com.example.springserver.dto.CreateDataResponseDto;

public interface TestService {
     CreateDataResponseDto createData(CreateDataRequestDto requestDto);
}
