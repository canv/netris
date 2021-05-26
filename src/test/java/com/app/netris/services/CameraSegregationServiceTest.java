package com.app.netris.services;

import com.app.netris.models.Camera;
import com.app.netris.models.source.CameraSource;
import com.app.netris.utils.data.TestDataUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CameraSegregationServiceTest {

    @Autowired
    private CameraSegregationService service;

    @Test
    void toCameras() {
        List<CameraSource> allObjectsCameraSources = TestDataUtils.getCameraSources();
        List<Camera> allObjectCameras = TestDataUtils.getCameras();

        for (int i = 0; i < allObjectsCameraSources.size(); i++) {
            CameraSource cameraSource = allObjectsCameraSources.get(i);
            Camera camera = allObjectCameras.get(i);

            assertEquals(service.toCamera(cameraSource), camera);
        }
    }
}