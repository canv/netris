package com.app.netris.contollers;

import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.services.CameraServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/support")
public class CameraSupportController {

    @Autowired
    private CameraServiceSupport serviceSupport;

    @GetMapping("/findById/{id}")
    public ResponseEntity<CameraDto> findCameraById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceSupport.getCamera(id));
    }

    @PostMapping("/addCamera")
    public ResponseEntity<CameraDto> addCamera(@RequestBody CameraSourceDto cameraSourceDto) {
        return ResponseEntity.ok(serviceSupport.addCamera(cameraSourceDto));
    }

    @GetMapping("/removeById/{id}")
    public ResponseEntity<CameraDto> removeCameraById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceSupport.removeCamera(id));
    }

    @GetMapping("/clearAll")
    public ResponseEntity<List<CameraDto>> clearAllCameras() {
        return ResponseEntity.ok(serviceSupport.clear());
    }
}
