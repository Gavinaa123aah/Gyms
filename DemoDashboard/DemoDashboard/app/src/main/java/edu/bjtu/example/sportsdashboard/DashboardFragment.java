package edu.bjtu.example.sportsdashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v4.view.ViewPager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private Banner myBanner;
    private ListView listView;
    View myZhuYeView;
    List<Integer> ImageUrlData;//注意坑在这里 我之前写的是 List<String> ImageUrlData因为
                             //Glide.with(getActivity()).load(url).into(imageView);load里面需要整形
    List<String> ContentData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflater.inflate(R.layout.dashboard, container, false);
        myZhuYeView=LayoutInflater.from(getActivity()).inflate(R.layout.dashboard,container,false);
        //listView = (ListView)myZhuYeView.findViewById(R.id.iv);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getData());
        initBanner();
        return myZhuYeView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        final Fragment fragment = new WebviewFragment();
        final Bundle bundle = new Bundle();

        super.onActivityCreated(savedInstanceState);

        LinearLayout button = (LinearLayout) myZhuYeView.findViewById(R.id.football_but);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bundle.putString("url", "http://en.bjtu.edu.cn/");
                    //fragment = new WebviewFragment();
                    fragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                            fragment).commit();
                    //Toast.makeText(getActivity(), "Football Section been clicked!", Toast.LENGTH_LONG).show();
                }
            });

        }
    private void initBanner()
    {
       myBanner=(Banner)myZhuYeView.findViewById(R.id.banner);
//
        ImageUrlData=new ArrayList<>();
        ContentData=new ArrayList<>();
        ImageUrlData.add(R.drawable.a1);
        ImageUrlData.add(R.drawable.a2);
        ImageUrlData.add(R.drawable.a3);
        ImageUrlData.add(R.drawable.a4);
        ContentData.add("pic1");
        ContentData.add("pic2");
        ContentData.add("pic3");
        ContentData.add("pic4");

        myBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        myBanner.setImageLoader(new MyLoader());
        myBanner.setImages(ImageUrlData);
        myBanner.setBannerTitles(ContentData);
        myBanner.setBannerAnimation(Transformer.Default);
        myBanner.setDelayTime(3000);
        myBanner.isAutoPlay(true);
        myBanner.setIndicatorGravity(BannerConfig.CENTER);
        myBanner.start();

    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide设置图片的简单用法
            Glide.with(getActivity()).load(path).into(imageView);
        }
        }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        for(int i = 0;i <20;i++) {
            data.add(i+"");
        }
        return data;
    }

}

