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

interface VoidCallBack{
    void execute();
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment fragmentB = new FragmentB();
        final Fragment fragmentA = FragmentA.newInstance(() -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,fragmentB)
                    .addToBackStack(null)
                    .commit();
        });

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container,fragmentA)
                .addToBackStack(null)
                .commit();
    }
}
