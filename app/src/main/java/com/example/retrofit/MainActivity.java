package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.rest.NetworkService;
import com.example.retrofit.rest.entities.MainWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch;
    private TextView result;
    private EditText cityET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btnSearch);
        result = findViewById(R.id.result);
        cityET = findViewById(R.id.city);


        btnSearch.setOnClickListener(v -> {
            String city = cityET.getText().toString();
            if(!city.isEmpty()){
                NetworkService networkService = NetworkService.getInstance();
                Call<MainWeather> call = networkService.getApiWeather()
                        .getWeather(city, "metric", "6bab4d6713adbf3a428b1f2a7454395d");

                call.enqueue(new Callback<MainWeather>() {
                    @Override
                    public void onResponse(Call<MainWeather> call, Response<MainWeather> response) {
                        MainWeather mainWeather = response.body();
                        Log.i("myTag", mainWeather.getWeatherList().get(0).getDescription());
                        result.setText(mainWeather.toString());
                    }

                    @Override
                    public void onFailure(Call<MainWeather> call, Throwable t) {
                        Toast.makeText(result.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
