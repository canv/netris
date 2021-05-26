package com.app.netris.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

public class ValidationUtils {

    public static boolean isValidDataUrl(final String dataUrl) {
        if (dataUrl == null)
            return false;
        else {
            try {
                new URL(dataUrl);
            } catch (MalformedURLException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidVideoUri(final String videoUri) {
        if (videoUri == null)
            return false;
        else {
            try {
                new URI(videoUri);
            } catch (URISyntaxException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidId(final Long cameraId) {
        if (cameraId == null) return false;
        else return cameraId >= 0;
    }

    public static boolean isValidValue(final String cameraValue) {
        if (cameraValue == null) return false;
        try {
            UUID id = UUID.fromString(cameraValue);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidTtl(final Long cameraTtl) {
        if (cameraTtl == null) return false;
        else return cameraTtl >= 0;
    }

    public static boolean isValidValue(final UUID cameraValue) {
        return cameraValue != null;
    }

}
