package com.awsports.service;

import org.springframework.stereotype.Service;

@Service
public interface ApikeyService {
    public String findById(Integer id) throws Exception;
}
