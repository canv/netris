package com.app.netris.services;

import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSourceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CameraService {
    List<CameraDto> addCameras(List<CameraSourceDto> cameraSourcesDto);

    List<CameraDto> getAllCameras();
}
