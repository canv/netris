package com.app.netris.services;

import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.CameraSourceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CameraServiceSupport {
    CameraDto addCamera(CameraSourceDto cameraSourceDto);

    CameraDto getCamera(Long id);

    CameraDto removeCamera(Long id);

    List<CameraDto> clear();
}
