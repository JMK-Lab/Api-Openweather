package fr.jmklab.apiopenweather;

import fr.jmklab.apiopenweather.exceptions.ApiUnthorizedException;
import fr.jmklab.apiopenweather.models.ApiResponse;

import java.io.IOException;

public interface ApiCallback {

    void onReponse(ApiResponse apiResponse);

    void onFailure(IOException e);

    void onUnthorized(ApiUnthorizedException e);

}
