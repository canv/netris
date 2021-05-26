package com.app.netris.models;

import java.util.Objects;

public class CameraDto {

    private Long id;

    private String urlType;

    private String videoUrl;

    private String value;

    private Long ttl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraDto cameraDto = (CameraDto) o;
        return Objects.equals(id, cameraDto.id) && Objects.equals(urlType, cameraDto.urlType) && Objects.equals(videoUrl, cameraDto.videoUrl) && Objects.equals(value, cameraDto.value) && Objects.equals(ttl, cameraDto.ttl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, urlType, videoUrl, value, ttl);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
}
