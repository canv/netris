package com.app.netris.models;

import com.app.netris.utils.ValidationUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Camera")
public class Camera implements ValidatableDataItem {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private UrlType urlType;

    private String videoUrl;

    private UUID value;

    private Long ttl;

    public Camera() {
    }

    public Camera(Long id, UrlType urlType, String videoUrl, UUID value, Long ttl) {
        this.id = id;
        this.urlType = urlType;
        this.videoUrl = videoUrl;
        this.value = value;
        this.ttl = ttl;
    }

    @JsonIgnore
    @Override
    public boolean isValid() {
        final boolean isValidId = ValidationUtils.isValidId(this.id);
        final boolean isValidUrlType = urlType != null;
        final boolean isValidVideoUrl = ValidationUtils.isValidVideoUri(this.videoUrl);
        final boolean isValidValue = ValidationUtils.isValidValue(this.value);
        final boolean isValidTtl = ValidationUtils.isValidTtl(this.ttl);
        return isValidId && isValidUrlType && isValidVideoUrl && isValidValue && isValidTtl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(id, camera.id) && urlType == camera.urlType && Objects.equals(videoUrl, camera.videoUrl) && Objects.equals(value, camera.value) && Objects.equals(ttl, camera.ttl);
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

    public UrlType getUrlType() {
        return urlType;
    }

    public void setUrlType(UrlType urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
}
