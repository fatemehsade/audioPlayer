package com.example.musicplayer.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicplayer.R;
import com.example.musicplayer.model.MusicModel;

import java.util.List;


public class MusicFragment extends Fragment {
    private RecyclerView mRecyclerView;



    public MusicFragment() {
        // Required empty public constructor
    }


    public static MusicFragment newInstance() {
        MusicFragment fragment = new MusicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_music, container, false);
        findViews(view);
        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void findViews(View view) {
        mRecyclerView=view.findViewById(R.id.recycler_view_music);
    }

    private class MusicAdapter extends RecyclerView.Adapter<MusicHolder>{

        List<MusicModel> mMusicModels;

        public List<MusicModel> getMusicModels() {
            return mMusicModels;
        }

        public void setMusicModels(List<MusicModel> musicModels) {
            mMusicModels = musicModels;
        }

        public MusicAdapter(List<MusicModel> musicModels) {
            mMusicModels = musicModels;
        }

        @NonNull
        @Override
        public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(getActivity()).inflate(
                    R.layout.item_music_row,parent,false);
            return new MusicHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
            MusicModel musicModel=mMusicModels.get(position);
            holder.bindMusic(musicModel);


        }

        @Override
        public int getItemCount() {
            return mMusicModels.size();
        }
    }

    private class MusicHolder extends RecyclerView.ViewHolder{
        private ImageView mImageViewSigner;
        private TextView mTextViewMusicName;
        private TextView mTextViewSignerName;
        private MusicModel mMusicModel;

        public MusicHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewSigner=itemView.findViewById(R.id.image_view_music);
            mTextViewMusicName=itemView.findViewById(R.id.txt_view_name_music);
            mTextViewSignerName=itemView.findViewById(R.id.txt_view_name_signer);
        }

        public void bindMusic(MusicModel music){
            mMusicModel=music;
            mTextViewSignerName.setText(music.getSignerName());
            mTextViewMusicName.setText(music.getMusicName());
            mImageViewSigner.setImageResource(R.drawable.ic_launcher_background);

        }
    }
}