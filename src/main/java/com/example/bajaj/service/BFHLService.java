package com.example.bajaj.service;

import com.example.bajaj.dto.RequestDTO;
import com.example.bajaj.dto.ResponseDTO;

public interface BFHLService {
    ResponseDTO processData(RequestDTO request);
}