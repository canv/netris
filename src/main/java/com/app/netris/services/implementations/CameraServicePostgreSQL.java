package com.app.netris.services.implementations;

import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import com.app.netris.models.mapper.CameraMapper;
import com.app.netris.models.mapper.CameraSourceMapper;
import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.repositories.CameraRepository;
import com.app.netris.services.CameraSegregationService;
import com.app.netris.services.CameraService;
import com.app.netris.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraServicePostgreSQL implements CameraService {

    @Autowired
    private CameraRepository repository;

    @Autowired
    private CameraSegregationService segregationService;

    @Override
    public List<CameraDto> addCameras(List<CameraSourceDto> cameraSourcesDto) {

        List<Camera> cameras = new ArrayList<>();

        for (CameraSourceDto cameraSourceDto : cameraSourcesDto) {
            CameraSource cameraSource = CameraSourceMapper.INSTANCE.toCameraSource(cameraSourceDto);

            CheckUtils.dataItemCheck(cameraSource);
            cameras.add(segregationService.toCamera(cameraSource));
        }

        List<Camera> savedCameras = repository.saveAll(cameras);

        ArrayList<CameraDto> savedCamerasDto = new ArrayList<>();
        for (Camera savedCamera : savedCameras) {
            savedCamerasDto.add(CameraMapper.INSTANCE.fromCamera(savedCamera));
        }

        return savedCamerasDto;
    }

    @Override
    public List<CameraDto> getAllCameras() {
        List<Camera> allCameras = repository.findAll();
        ArrayList<CameraDto> allCamerasDto = new ArrayList<>();

        for (Camera camera : allCameras) {
            CameraDto cameraDto = CameraMapper.INSTANCE.fromCamera(camera);
            allCamerasDto.add(cameraDto);
        }
        return allCamerasDto;
    }
}
