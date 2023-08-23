package hieubui.eup.java_android_tutorial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentA extends Fragment {
    private VoidCallBack goToScreenB;
    Button buttonGoToB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        buttonGoToB = view.findViewById(R.id.btn_go_to_b);
        buttonGoToB.setOnClickListener(v -> {
            goToScreenB.execute();
        });
    }

    public static FragmentA newInstance(VoidCallBack goToScreenB){
        FragmentA instance = new FragmentA();
        instance.goToScreenB = goToScreenB;
        return instance;
    }
}