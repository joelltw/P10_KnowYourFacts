package c347.rp.edu.sg.p10_knowyourfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btnChangeColor;
    View view;
    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);

        btnChangeColor = (Button)view.findViewById(R.id.btnChangeColor);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] androidColors = getResources().getIntArray(R.array.rainbow);
                int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
                view.setBackgroundColor(randomAndroidColor);
            }
        });
        return view;
    }
}
