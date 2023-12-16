package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.repository.StatusRepository;
import com.example.stringboot_hieugui.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusImpl implements StatusService {

    private StatusRepository statusRepository;
    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<String> findAllStatusName() {
        return statusRepository.findAllStatusName();
    }
}
