package hieubui.eup.java_android_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdd = findViewById(R.id.add_fragment);
        Button buttonAddB = findViewById(R.id.add_fragment_b);
        Button buttonBack = findViewById(R.id.back);
        final Fragment fragmentB = new FragmentB();
        final Fragment fragmentA = new FragmentA();
        FragmentManager fragmentManager = getSupportFragmentManager();
        buttonAdd.setOnClickListener(v -> {
            if(fragmentB.isHidden()){
                fragmentManager
                        .beginTransaction()
                        .show(fragmentB)
                        .commit();
            }
        });
        buttonAddB.setOnClickListener(v -> {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container,fragmentB)
                    .addToBackStack("b")
                    .commit();
        });
        buttonBack.setOnClickListener(
                v-> {
                    if(fragmentB.isVisible()){
                        fragmentManager
                                .beginTransaction()
                                .hide(fragmentB)
                                .commit();
                    }
                }
                );
    }
}
