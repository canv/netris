package com.app.netris.models.source;

import com.app.netris.models.ValidatableDataItem;
import com.app.netris.utils.ValidationUtils;

import java.util.Objects;


public class CameraSource implements ValidatableDataItem {
    private Long id;
    private String sourceDataUrl;
    private String tokenDataUrl;

    public CameraSource() {
    }

    public CameraSource(Long id, String sourceDataUrl, String tokenDataUrl) {
        this.id = id;
        this.sourceDataUrl = sourceDataUrl;
        this.tokenDataUrl = tokenDataUrl;
    }

    @Override
    public boolean isValid() {
        final boolean isValidId = ValidationUtils.isValidId(this.id);
        final boolean isValidSourceDataUrl = ValidationUtils.isValidDataUrl(this.sourceDataUrl);
        final boolean isValidTokenDataUrl = ValidationUtils.isValidDataUrl(this.sourceDataUrl);
        return isValidId && isValidSourceDataUrl && isValidTokenDataUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraSource that = (CameraSource) o;
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
