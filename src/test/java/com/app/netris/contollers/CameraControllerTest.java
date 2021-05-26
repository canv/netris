package com.app.netris.contollers;

import com.app.netris.models.CameraDto;
import com.app.netris.models.source.CameraSourceDto;
import com.app.netris.services.CameraService;
import com.app.netris.utils.data.TestDataUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CameraController.class)
public class CameraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CameraService service;

    @Test
    public void getAllCameras() throws Exception {

        Mockito.when(service.getAllCameras())
                .thenReturn(TestDataUtils.getCamerasDto());

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(TestDataUtils.getAllJsonCamerasDto()));
    }

    @Test
    public void getEmptyCameras() throws Exception {
        Mockito.when(service.getAllCameras())
                .thenReturn(new ArrayList<CameraDto>());

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void addCamerasSource() throws Exception {
        List<CameraDto> allCamerasDto = TestDataUtils.getCamerasDto();

        Mockito.when(service.addCameras(TestDataUtils.getCameraSourcesDto()))
                .thenReturn(allCamerasDto);

        MediaType contentType = new MediaType(
                MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                StandardCharsets.UTF_8);

        this.mockMvc
                .perform(
                        post("/")
                                .contentType(contentType)
                                .content(TestDataUtils.getAllJsonCameraSourcesDto())
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(TestDataUtils.getAllJsonCamerasDto()));
    }

    @Test
    public void addEmptyCamerasSource() throws Exception {
        Mockito.when(service.addCameras(new ArrayList<CameraSourceDto>()))
                .thenReturn(new ArrayList<CameraDto>());

        MediaType contentType = new MediaType(
                MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                StandardCharsets.UTF_8);

        this.mockMvc
                .perform(
                        post("/")
                                .contentType(contentType)
                                .content("[]")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}