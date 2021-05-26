package com.app.netris.models.mapper;

import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.CameraSourceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CameraSourceMapper {

    CameraSourceMapper INSTANCE = Mappers.getMapper(CameraSourceMapper.class);

    CameraSourceDto fromCameraSource(CameraSource cameraSource);

    CameraSource toCameraSource(CameraSourceDto cameraSourceDto);
}
