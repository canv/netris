package com.app.netris.contollers;

import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.services.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CameraController {

    @Autowired
    private CameraService service;

    @GetMapping
    public ResponseEntity<List<CameraDto>> findAllCameras() {
        return ResponseEntity.ok(service.getAllCameras());
    }

    @PostMapping
    public ResponseEntity<List<CameraDto>> addCamerasSource(@RequestBody List<CameraSourceDto> cameraSourcesDto) {
        return ResponseEntity.ok(service.addCameras(cameraSourcesDto));
    }
}
