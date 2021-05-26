package com.app.netris.services;

import com.app.netris.models.Camera;
import com.app.netris.models.source.CameraSource;
import org.springframework.stereotype.Service;

@Service
public interface CameraSegregationService {
    Camera toCamera(CameraSource cameraSource);
}
