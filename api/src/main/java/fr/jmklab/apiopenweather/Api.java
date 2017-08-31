package fr.jmklab.apiopenweather;

import fr.jmklab.apiopenweather.exceptions.ApiHttpError;
import fr.jmklab.apiopenweather.exceptions.ApiRestError;
import fr.jmklab.apiopenweather.exceptions.ApiUnthorizedException;
import fr.jmklab.apiopenweather.models.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;

import java.io.IOException;

public class Api {

    private String uri = "http://api.openweathermap.org/data/2.5/weather?q=";

    private String API_KEY;
    private String city;
    private String units = "metric";
    private String lang = "fr";

    private OkHttpClient client = new OkHttpClient();

    public Api(String API_KEY, String city) {

        this.API_KEY = API_KEY;
        this.city = city;

    }

    public Api(String API_KEY, String city, String units) {

        this.API_KEY = API_KEY;
        this.city = city;
        this.units = units;

    }

    public Api( String API_KEY, String city, String units, String lang) {

        this.API_KEY = API_KEY;
        this.units = units;
        this.lang = lang;
        this.city = city;

    }

    public void runCurrent(final ApiCallback callback) throws IOException {

        createUri();

        Request request = new Request.Builder()
                .url(this.uri)
                .build();

        client.newCall(request).enqueue(new Callback() {

            public void onFailure(Call call, IOException e) {
                ApiHttpError apiHttpError = new ApiHttpError("Warning", e);
                callback.onFailure(apiHttpError);
            }

            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Gson gson = new GsonBuilder().create();

                ApiResponse decode = gson.fromJson(response.body().string(), ApiResponse.class);

                if (response.isSuccessful()) {

                    callback.onReponse(decode);

                } else if (response.code() == 401) {

                    ApiUnthorizedException e = new ApiUnthorizedException("Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");
                    callback.onUnthorized(e);

                } else {

                    ApiRestError e = new ApiRestError("HTTP Error : " + response.code() + " error. " + response.body().string());
                    callback.onRestError(e);

                }


            }
        });
    }

    public void setAPI_KEY(String API_KEY) {

        this.API_KEY = API_KEY;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public void setLang(Langs lang) {

        this.lang = lang.toString();
    }

    public void setUnits(Units units) {

        this.units = units.toString();
    }

    private void createUri() {

        this.uri += city;
        this.uri += "&APPID=" + this.API_KEY + "&units=" + this.units + "&lang=" + this.lang;

    }
}
