package com.app.netris.services.implementations;

import com.app.netris.exceptions.DataItemNotFoundException;
import com.app.netris.models.Camera;
import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.SourceData;
import com.app.netris.models.source.TokenData;
import com.app.netris.services.CameraSegregationService;
import com.app.netris.utils.CheckUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CameraSegregationRestTemplateService implements CameraSegregationService {

    @Override
    public Camera toCamera(CameraSource cameraSource) {
        Camera camera = new Camera();
        RestTemplate template = new RestTemplate();

        SourceData sourceData = loadSourceData(template, cameraSource.getSourceDataUrl());
        TokenData tokenData = loadTokenData(template, cameraSource.getTokenDataUrl());

        camera.setId(cameraSource.getId());
        camera.setUrlType(sourceData.getUrlType());
        camera.setVideoUrl(sourceData.getVideoUrl());
        camera.setValue(tokenData.getValue());
        camera.setTtl(tokenData.getTtl());

        return camera;
    }

    private SourceData loadSourceData(final RestTemplate template, final String url) {
        final SourceData sourceData;

        try {
            sourceData = template.getForObject(url, SourceData.class);
            CheckUtils.dataItemCheck(sourceData);

        } catch (RestClientException e) {
            throw new DataItemNotFoundException(String.format("Error loading data from: %s", url));
        }
        return sourceData;
    }

    private TokenData loadTokenData(final RestTemplate template, final String url) {
        final TokenData tokenData;

        try {
            tokenData = template.getForObject(url, TokenData.class);
            CheckUtils.dataItemCheck(tokenData);

        } catch (RestClientException e) {
            throw new DataItemNotFoundException(String.format("Error loading data from: %s", url));
        }
        return tokenData;
    }
}
