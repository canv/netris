package com.app.netris.models.source;

import java.util.Objects;

public class CameraSourceDto {
    private Long id;
    private String sourceDataUrl;
    private String tokenDataUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraSourceDto that = (CameraSourceDto) o;
        return Objects.equals(id, that.id) && Objects.equals(sourceDataUrl, that.sourceDataUrl) && Objects.equals(tokenDataUrl, that.tokenDataUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceDataUrl, tokenDataUrl);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceDataUrl() {
        return sourceDataUrl;
    }

    public void setSourceDataUrl(String sourceDataUrl) {
        this.sourceDataUrl = sourceDataUrl;
    }

    public String getTokenDataUrl() {
        return tokenDataUrl;
    }

    public void setTokenDataUrl(String tokenDataUrl) {
        this.tokenDataUrl = tokenDataUrl;
    }
}
