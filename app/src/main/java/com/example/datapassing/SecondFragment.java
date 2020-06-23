package com.example.datapassing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondFragment extends Fragment {

    public SecondFragment() {
    }

    private FrameLayout parentFrameLayout;
    private Button gotoFirstFragment;
    private TextView receivedData1;
    private TextView receivedData2;
    private TextView receiveFirstTextFromSecondActivity;
    private TextView receiveSecondTextFromSecondActivity;

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        parentFrameLayout = getActivity().findViewById(R.id.frameLayout);
        gotoFirstFragment = view.findViewById(R.id.gotoFirstFragmentBtn);
        receivedData1 = view.findViewById(R.id.receivedText1);
        receivedData2 = view.findViewById(R.id.receivedText2);
        receiveFirstTextFromSecondActivity = view.findViewById(R.id.receiveFirstTextFromSecondActivity);
        receiveSecondTextFromSecondActivity = view.findViewById(R.id.receiveSecondTextFromSecondActivity);

        gotoFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new FirstFragment());
            }
        });

        Bundle bundleFromFragment = getArguments();
        String data1 = bundleFromFragment.getString("first_data");
        String data2 = bundleFromFragment.getString("second_data");
        receivedData1.setText(data1);
        receivedData2.setText(data2);

        return view;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}
