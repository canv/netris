package com.app.netris.models.source;

import com.app.netris.models.UrlType;
import com.app.netris.models.ValidatableDataItem;
import com.app.netris.utils.ValidationUtils;

import java.util.Objects;

public class SourceData implements ValidatableDataItem {
    private UrlType urlType;
    private String videoUrl;

    @Override
    public boolean isValid() {
        final boolean isValidUrlType = this.urlType != null;
        final boolean isValidVideoUrl = ValidationUtils.isValidVideoUri(this.videoUrl);
        return isValidUrlType && isValidVideoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceData that = (SourceData) o;
        return urlType == that.urlType && Objects.equals(videoUrl, that.videoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlType, videoUrl);
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
}
