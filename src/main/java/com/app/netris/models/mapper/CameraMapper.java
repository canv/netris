package com.app.netris.models.mapper;

import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CameraMapper {
    CameraMapper INSTANCE = Mappers.getMapper(CameraMapper.class);

    CameraDto fromCamera(Camera camera);

    Camera toCamera(CameraDto cameraDto);

    default String map(UUID value) {
        return value.toString();
    }

    default UUID map(String value) {
        return UUID.fromString(value);
    }
}
