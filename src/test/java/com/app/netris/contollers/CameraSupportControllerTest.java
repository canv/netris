package com.app.netris.contollers;

import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.services.CameraServiceSupport;
import com.app.netris.utils.data.TestDataUtils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.app.netris.utils.data.TestDataUtils.getRandom;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CameraSupportController.class)
class CameraSupportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CameraServiceSupport service;

    @Test
    void findCameraById() throws Exception {
        List<CameraDto> allCamerasDto = TestDataUtils.getCamerasDto();
        int index = getRandom(allCamerasDto.size());

        List<CameraSourceDto> cameraSourcesDto = TestDataUtils.getCameraSourcesDto();

        Long findCameraId = cameraSourcesDto.get(index).getId();
        CameraDto findCamera = allCamerasDto.get(index);

        Mockito.when(service.getCamera(findCameraId))
                .thenReturn(findCamera);

        String cameraDtoJson = new Gson().toJson(findCamera);

        this.mockMvc
                .perform(get(supportTemplate("/findById/" + findCameraId)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(cameraDtoJson));
    }

    @Test
    void addCamera() throws Exception {
        List<CameraDto> allCamerasDto = TestDataUtils.getCamerasDto();
        int index = getRandom(allCamerasDto.size());

        List<CameraSourceDto> cameraSourcesDto = TestDataUtils.getCameraSourcesDto();
        CameraSourceDto addCameraSource = cameraSourcesDto.get(index);
        CameraDto addCameraDto = allCamerasDto.get(index);

        Mockito.when(service.addCamera(addCameraSource))
                .thenReturn(addCameraDto);

        MediaType contentType = new MediaType(
                MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                StandardCharsets.UTF_8);

        Gson gson = new Gson();
        String cameraSourceDtoJson = gson.toJson(addCameraSource);
        String cameraDtoJson = gson.toJson(addCameraDto);
        this.mockMvc
                .perform(
                        post(supportTemplate("/addCamera"))
                                .contentType(contentType)
                                .content(cameraSourceDtoJson)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(cameraDtoJson));
    }

    @Test
    void removeCameraById() throws Exception {

        List<CameraDto> allCamerasDto = TestDataUtils.getCamerasDto();
        int index = getRandom(allCamerasDto.size());

        List<CameraSourceDto> cameraSourcesDto = TestDataUtils.getCameraSourcesDto();

        Long removeCameraId = cameraSourcesDto.get(index).getId();
        CameraDto removeCamera = allCamerasDto.get(index);

        Mockito.when(service.removeCamera(removeCameraId))
                .thenReturn(removeCamera);

        String cameraDtoJson = new Gson().toJson(removeCamera);

        this.mockMvc
                .perform(get(supportTemplate("/removeById/" + removeCameraId)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(cameraDtoJson));
    }

    @Test
    void clearAllCameras() throws Exception {

        Mockito.when(service.clear())
                .thenReturn(TestDataUtils.getCamerasDto());

        this.mockMvc.perform(get(supportTemplate("/clearAll")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(TestDataUtils.getAllJsonCamerasDto()));
    }

    String supportTemplate(String path) {
        return "/support" + path;
    }
}