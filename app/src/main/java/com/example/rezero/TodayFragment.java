package com.example.rezero;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import me.relex.circleindicator.CircleIndicator;


public class TodayFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridLayout gridLayout;
    ViewPager pagerBanner;
    CircleIndicator indicator;

    int ImgLen = 10;

    ImageView[] exImg = new ImageView[ImgLen];

    LinearLayout[] basicBtn = new LinearLayout[ImgLen];

    TextView name,price;


    private TodayFragment mViewModel;

    public TodayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodayFragment newInstance(String param1, String param2) {
        TodayFragment fragment = new TodayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_today, container, false);

        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.gridLayout);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pagerBanner);
        CircleIndicator indicator = (CircleIndicator)view.findViewById(R.id.indicator);
        BannerAdapter adapter = new BannerAdapter(getChildFragmentManager());//????????????????????? ?????? ???????????????
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);


        //?????????????????????
        for(int i=0;i<ImgLen;i++){
            exImg[i] = new ImageView(this.getContext());//???????????????????????????
            exImg[i].setImageResource(R.drawable.imgex);//??????????????? ??????
            exImg[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
            exImg[i].setBackground(getResources().getDrawable(R.drawable.shadow_test));
        }

        //???????????????????????? ??????????????? - ??????
        for(int i=0;i< ImgLen;i++){
            gridLayout.addView(exImg[i]);
        }

        return view;
    }


}

