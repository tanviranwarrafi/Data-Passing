package com.example.datapassing;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    public FirstFragment() {
    }

    private Button gotoSecondFragment;
    private FrameLayout parentFrameLayout;
    private Button passDataToSecondFragment;
    private EditText firstEditText;
    private EditText secondEditText;
    private Button passDataToSecondActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        gotoSecondFragment = view.findViewById(R.id.gotoSecondFragmentBtn);
        firstEditText = view.findViewById(R.id.firstEdittext);
        secondEditText = view.findViewById(R.id.secondEditText);
        passDataToSecondFragment = view.findViewById(R.id.passDataToSecondFragment);
        parentFrameLayout = getActivity().findViewById(R.id.frameLayout);
        passDataToSecondActivity = view.findViewById(R.id.passDataToSecondActivity);

        passDataToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = firstEditText.getText().toString();
                String data2 = secondEditText.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("first_data", data1);
                bundle.putString("second_data", data2);

                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                setFragment(secondFragment);
            }
        });

        passDataToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data1 = firstEditText.getText().toString();
                String data2 = secondEditText.getText().toString();

                Intent gotoSecondActivityIntent = new Intent(getActivity(), SecondActivity.class);
                gotoSecondActivityIntent.putExtra("data1", data1);
                gotoSecondActivityIntent.putExtra("data2", data2);
                startActivity(gotoSecondActivityIntent);
            }
        });

        return view;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}
