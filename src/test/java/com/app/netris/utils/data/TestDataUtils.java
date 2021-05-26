package com.app.netris.utils.data;

import com.app.netris.models.Camera;
import com.app.netris.models.CameraDto;
import com.app.netris.models.UrlType;
import com.app.netris.models.mapper.CameraMapper;
import com.app.netris.models.mapper.CameraSourceMapper;
import com.app.netris.models.source.CameraSource;
import com.app.netris.models.source.CameraSourceDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TestDataUtils {

    final public static String TEST_JSON_DATA_URL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";

    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    public static int getRandom(int max){
        return getRandom(0, max);
    }

    public static int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }


    public static List<Camera> getCameras() {
        ArrayList<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera(
                1L,
                UrlType.LIVE,
                "rtsp://127.0.0.1/1",
                UUID.fromString("fa4b588e-249b-11e9-ab14-d663bd873d93"),
                120L));

        cameras.add(new Camera(
                20L,
                UrlType.ARCHIVE,
                "rtsp://127.0.0.1/2",
                UUID.fromString("fa4b5b22-249b-11e9-ab14-d663bd873d93"),
                60L));

        cameras.add(new Camera(
                3L,
                UrlType.ARCHIVE,
                "rtsp://127.0.0.1/3",
                UUID.fromString("fa4b5d52-249b-11e9-ab14-d663bd873d93"),
                120L));

        cameras.add(new Camera(
                2L,
                UrlType.LIVE,
                "rtsp://127.0.0.1/20",
                UUID.fromString("fa4b5f64-249b-11e9-ab14-d663bd873d93"),
                180L));

        return cameras;
    }

    public static List<CameraDto> getCamerasDto() {
        List<Camera> allCamerasObj = getCameras();
        ArrayList<CameraDto> camerasDto = new ArrayList<>();

        for (Camera camera : allCamerasObj)
            camerasDto.add(CameraMapper.INSTANCE.fromCamera(camera));

        return camerasDto;
    }

    public static String getAllJsonCamerasDto() {
        return new Gson().toJson(getCamerasDto());
    }


    public static String getAllJsonCameraSourcesDto() {
        return jsonGetRequest(TEST_JSON_DATA_URL);
    }

    public static List<CameraSourceDto> getCameraSourcesDto() {
        return getCameraSourcesDto(getAllJsonCameraSourcesDto());
    }

    public static List<CameraSourceDto> getCameraSourcesDto(final String json) {
        Type type = new TypeToken<ArrayList<CameraSourceDto>>() {}.getType();
        return new Gson().fromJson(json, type);
    }

    public static List<CameraSource> getCameraSources() {
        return getCameraSources(getCameraSourcesDto());
    }

    public static List<CameraSource> getCameraSources(final List<CameraSourceDto> cameraSourcesDto) {
        List<CameraSource> cameraSources = new ArrayList<>();

        for (CameraSourceDto cameraSourceDto : cameraSourcesDto)
            cameraSources.add(CameraSourceMapper.INSTANCE.toCameraSource(cameraSourceDto));

        return cameraSources;
    }

}
