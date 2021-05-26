package com.app.netris.services.implementations;

import com.app.netris.exceptions.CameraNotFoundException;
import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import com.app.netris.models.mapper.CameraMapper;
import com.app.netris.models.mapper.CameraSourceMapper;
import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.repositories.CameraRepository;
import com.app.netris.services.CameraSegregationService;
import com.app.netris.services.CameraServiceSupport;
import com.app.netris.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraServiceSupportPostgreSQL implements CameraServiceSupport {

    @Autowired
    private CameraRepository repository;

    @Autowired
    private CameraSegregationService segregationService;

    @Override
    public CameraDto addCamera(CameraSourceDto cameraSourceDto) {
        CameraSource cameraSource = CameraSourceMapper.INSTANCE.toCameraSource(cameraSourceDto);
        CheckUtils.dataItemCheck(cameraSource);
        Camera save = repository.save(segregationService.toCamera(cameraSource));
        return CameraMapper.INSTANCE.fromCamera(save);
    }

    @Override
    public CameraDto getCamera(Long id) {
        CheckUtils.idCheck(id);
        Camera camera = repository.findById(id)
                .orElseThrow(() -> new CameraNotFoundException(String.format("Camera with ID %s not found", id)));

        return CameraMapper.INSTANCE.fromCamera(camera);
    }

    @Override
    public CameraDto removeCamera(Long id) {
        CheckUtils.idCheck(id);
        Camera camera = repository.findById(id)
                .orElseThrow(() -> new CameraNotFoundException(String.format("Camera with ID %s not found", id)));

        repository.deleteById(id);
        return CameraMapper.INSTANCE.fromCamera(camera);
    }

    @Override
    public List<CameraDto> clear() {
        List<Camera> allCameras = repository.findAll();
        ArrayList<CameraDto> allCamerasDto = new ArrayList<>();

        for (Camera camera : allCameras) {
            CameraDto cameraDto = CameraMapper.INSTANCE.fromCamera(camera);
            allCamerasDto.add(cameraDto);
        }

        repository.deleteAll();
        return allCamerasDto;
    }
}
