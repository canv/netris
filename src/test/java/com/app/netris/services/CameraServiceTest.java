package com.app.netris.services;

import com.app.netris.models.Camera;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.repositories.CameraRepository;
import com.app.netris.utils.data.TestDataUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CameraServiceTest {
    @MockBean
    private CameraRepository repository;

    @Autowired
    private CameraService service;

    @Test
    void addCameras() {
        List<Camera> allObjectCameras = TestDataUtils.getCameras();
        List<CameraSourceDto> allObjectsCameraSources = TestDataUtils.getCameraSourcesDto();

        when(repository.saveAll(allObjectCameras)).thenReturn(allObjectCameras);
        assertEquals(service.addCameras(allObjectsCameraSources), TestDataUtils.getCamerasDto());
    }

    @Test
    void getAllCameras() {
        List<Camera> allObjectCameras = TestDataUtils.getCameras();

        when(repository.findAll()).thenReturn(allObjectCameras);
        assertEquals(service.getAllCameras(), TestDataUtils.getCamerasDto());
    }
}