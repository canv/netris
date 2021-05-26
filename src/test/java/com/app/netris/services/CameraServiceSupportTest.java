package com.app.netris.services;

import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.repositories.CameraRepository;
import com.app.netris.utils.data.TestDataUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static com.app.netris.utils.data.TestDataUtils.getRandom;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CameraServiceSupportTest {

    @MockBean
    private CameraRepository repository;

    @Autowired
    private CameraServiceSupport service;

    @Test
    void addCamera() {
        List<Camera> allCameras = TestDataUtils.getCameras();
        List<CameraSourceDto> allCameraSources = TestDataUtils.getCameraSourcesDto();
        int index = getRandom(allCameras.size());

        when(repository.save(allCameras.get(index))).thenReturn(allCameras.get(index));
        assertEquals(service.addCamera(allCameraSources.get(index)), TestDataUtils.getCamerasDto().get(index));
    }

    @Test
    void getCamera() {
        List<Camera> allCameras = TestDataUtils.getCameras();
        int index = getRandom(allCameras.size());

        Camera camera = allCameras.get(index);
        Long id = camera.getId();

        List<CameraDto> camerasDto = TestDataUtils.getCamerasDto();

        when(repository.findById(id)).thenReturn(Optional.of(camera));
        assertEquals(service.getCamera(id), camerasDto.get(index));
    }

    @Test
    void removeCamera() {
        List<Camera> allCameras = TestDataUtils.getCameras();
        int index = getRandom(allCameras.size());

        Camera camera = allCameras.get(index);
        Long id = camera.getId();

        List<CameraDto> camerasDto = TestDataUtils.getCamerasDto();

        when(repository.findById(id)).thenReturn(Optional.of(camera));
        assertEquals(service.getCamera(id), camerasDto.get(index));
    }

    @Test
    void clear() {
        List<Camera> allObjectCameras = TestDataUtils.getCameras();

        when(repository.findAll()).thenReturn(allObjectCameras);
        assertEquals(service.clear(), TestDataUtils.getCamerasDto());
    }
}