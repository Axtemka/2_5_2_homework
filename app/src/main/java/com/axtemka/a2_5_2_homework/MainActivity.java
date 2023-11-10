package com.axtemka.a2_5_2_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.axtemka.a2_5_2_homework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final String username = "Axtemka";
    private final String password = "qwerty123465";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogin.setOnClickListener(view -> {
            String getNameText = String.valueOf(binding.editTextUsername.getText());
            String getPassText = String.valueOf(binding.editTextPassword.getText());
            binding.signalText.setVisibility(View.VISIBLE);
            if (getNameText.isEmpty() || getPassText.isEmpty()) binding.signalText.setText("Укажите все данные!");
            else{
                if (!getNameText.equals(username) || !getPassText.equals(password)) {
                    binding.signalText.setTextColor(Color.argb(255, 255, 0, 0));
                    binding.signalText.setText("Ошибка в логине или пароле");
                }
                else{
                    binding.signalText.setTextColor(Color.argb(255, 0, 255, 0));
                    binding.signalText.setText("Успешный вход");
                }
            }
            binding.editTextUsername.setText("");
            binding.editTextPassword.setText("");
        });
    }
}