package com.example.akangfood.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.akangfood.R;
import com.example.akangfood.RecyclerView.FnBAdapter;
import com.example.akangfood.RecyclerView.FnBModel;

import java.util.ArrayList;

public class MinumanFragment extends Fragment implements FnBAdapter.FnBAdapterListener {

    RecyclerView rvFood;
    ArrayList<FnBModel> fnbList;
    private FnBAdapter adapterFnBList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_fnb, container, false);

        fnbList = new ArrayList<>();
        rvFood = view.findViewById(R.id.rvFood);

        fnbList.add(new FnBModel("Bajigur", "80cal", "Manis","Rp. 5.000 - 10.000" ,R.drawable.bajigur, false));
        fnbList.add(new FnBModel("Bandrek", "65cal", "Manis","Rp. 5.000 - 25.000" ,R.drawable.bandrek, false));
        fnbList.add(new FnBModel("Es Mang Utuy", "120cal", "Manis","Rp. 10.000 - 20.000" ,R.drawable.es_mang_utuy, false));
        fnbList.add(new FnBModel("Es Oyen", "108cal", "Manis","Rp. 10.000 - 20.000" ,R.drawable.es_oyen, false));
        fnbList.add(new FnBModel("Yogurt Cisangkuy", "59cal", "Manis","Rp. 10.000 - 30.000" ,R.drawable.yougurt, false));

        adapterFnBList = new FnBAdapter(fnbList, this);
        rvFood.setAdapter(adapterFnBList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvFood.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void onFnBSelected(FnBModel fnbSelect) {

    }
}
