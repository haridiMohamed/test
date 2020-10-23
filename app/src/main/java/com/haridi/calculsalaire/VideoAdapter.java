package com.haridi.calculsalaire;

//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebChromeClient;
//import android.webkit.WebView;
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.NativeExpressAdView;
//
//import java.util.List;
//
////public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
//public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    List<YouTubeVideos> mList;
//    private Context context;
//
//    public VideoAdapter(List<YouTubeVideos> list_Item, Context context) {
//        mList = list_Item;
//        this.context = context;
//
//    }
//
//    public VideoAdapter() {
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        RecyclerView.ViewHolder viewHolder = null;
//        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        switch (viewType) {
//            case 1: {
//                View v1 = inflater.inflate(R.layout.video_view, viewGroup, false);
//                viewHolder = new VideoViewHolder(v1);
//                break;
//            }
//            case 2: {
//                View v2 = inflater.inflate(R.layout.list_item_native, viewGroup, false);
//                viewHolder = new ViewHolderNative_main(v2);
//                break;
//            }
//
//        }
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
//      // holder.videoWeb.loadData( youtubeVideoList.get(i).getVideoUrl(), "text/html" , "utf-8" );
//
//        final YouTubeVideos model = mList.get(holder.getAdapterPosition());
//        switch (holder.getItemViewType()) {
//            case 1: {
//                VideoViewHolder menuItemHolder = (VideoViewHolder) holder;
//                String TBooks = model.getVideoUrl();
//                menuItemHolder.videoWeb.loadData( model.getVideoUrl(), "text/html" , "utf-8" );
//            }
//            break;
//
//            case 2: {
//                ///ADS
//
//                break;
//            }
//        }
//
//    }
//
//    public VideoAdapter(List<YouTubeVideos> youtubeVideoList) {
//        this.mList = youtubeVideoList;
//    }
////
////    @Override
////    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////
////        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.video_view, parent, false);
////
////        return new VideoViewHolder(view);
////
////    }
//
//
//
////    @Override
////    public void onBindViewHolder(VideoViewHolder holder, int position) {
////
////        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );
////
////    }
//
//    @Override
//    public int getItemCount() {
//        return mList.size();
//    }
//
//    public class VideoViewHolder extends RecyclerView.ViewHolder{
//
//        WebView videoWeb;
//
//        public VideoViewHolder(View itemView) {
//            super(itemView);
//
//            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);
//
//            videoWeb.getSettings().setJavaScriptEnabled(true);
//            videoWeb.setWebChromeClient(new WebChromeClient() {
//
//            } );
//        }
//    }
//
//
//    public static class ViewHolderNative_main extends RecyclerView.ViewHolder {
//        public NativeExpressAdView adView;
//
//        public ViewHolderNative_main(View view) {
//            super(view);
//            adView = (NativeExpressAdView) view.findViewById(R.id.adView);
//            AdRequest request = new AdRequest.Builder()
//                    // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                    .build();
//            adView.loadAd(request);
//        }
//    }
//
//}

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.ArrayList;
import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<YouTubeVideos> mList;
    private Context context;

    public VideoAdapter(List<YouTubeVideos> list_Item, Context context) {
        mList = list_Item;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;


        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case 1: {
                View v1 = inflater.inflate(R.layout.row_item_main, viewGroup, false);
                viewHolder = new MenuItemViewHolder_main(v1);

                break;
            }
            case 2: {
                View v2 = inflater.inflate(R.layout.list_item_native, viewGroup, false);
                viewHolder = new ViewHolderNative_main(v2);
                break;
            }
        }
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i) {

        final YouTubeVideos model = mList.get(holder.getAdapterPosition());
          System.out.println("ViewType"+holder.getItemViewType());
        switch (holder.getItemViewType()) {
            case 1: {
                final MenuItemViewHolder_main menuItemHolder = (MenuItemViewHolder_main) holder;

//                String TBooks = model.getVideoUrl();
                menuItemHolder.TV_Title.setText(model.getImgUrl());
//             //   menuItemHolder.videoWeb.loadData(model.getVideoUrl() , "text/html" , "utf-8" );
//
                menuItemHolder.TV_Title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  context.startActivity(new Intent(context, FullScrenVideo.class));
                        Intent mIntent = new Intent(context, FullScrenVideo.class);
                        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mIntent.putExtra("pos", i);
                        mIntent.putExtra("video", model.getVideoUrl());
                        context.startActivity(mIntent);
                    }
                });
            }
            break;

            case 2: {

            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class MenuItemViewHolder_main extends RecyclerView.ViewHolder {

        TextView TV_Title;
      // WebView videoWeb;
        MenuItemViewHolder_main(View view) {
            super(view);
            TV_Title = view.findViewById(R.id.TV_Title);
        //  videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);
//          videoWeb.setWebChromeClient(new WebChromeClient() {
        //   } );

        }
    }

    public static class ViewHolderNative_main extends RecyclerView.ViewHolder {
        public NativeExpressAdView adView;

        public ViewHolderNative_main(View view) {
            super(view);
            adView = (NativeExpressAdView) view.findViewById(R.id.adView);
            AdRequest request = new AdRequest.Builder()
                     //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            adView.loadAd(request);
        }
    }

}