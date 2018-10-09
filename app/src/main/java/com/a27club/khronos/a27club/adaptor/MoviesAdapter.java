package com.a27club.khronos.a27club.adaptor;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.a27club.khronos.a27club.R;
import com.a27club.khronos.a27club.entity.PlayLists;
import com.a27club.khronos.a27club.entity.Video;
import com.facebook.drawee.view.SimpleDraweeView;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends ExpandableRecyclerViewAdapter<MoviesAdapter.TitleViewHolder,MoviesAdapter.ItemViewHolder>  implements View.OnClickListener{

    private onMovieAdapter mListener;

    public interface onMovieAdapter{
        void onMovieAdapterClicked(String link);
    }

    public MoviesAdapter(List<? extends ExpandableGroup> groups, onMovieAdapter mListener) {
        super(groups);
        this.mListener = mListener;
    }

    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_playlist,parent,false);
        return  new TitleViewHolder(view);
    }

    @Override
    public ItemViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist,parent,false);
        return  new ItemViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ItemViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Video video = ((PlayLists)group).getItems().get(childIndex);
        holder.setTitle(video.getTitle());
        holder.setSimpleDraweeView(video.getThumb());
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(video.getLink());
    }

    @Override
    public void onBindGroupViewHolder(TitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        PlayLists playLists = (PlayLists)group;
        holder.setGenreTitle(playLists);
    }

    public static  class  ItemViewHolder extends ChildViewHolder{
        @BindView(R.id.title) TextView title;
        @BindView(R.id.imageView) SimpleDraweeView simpleDraweeView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setTitle(String name) {
           title.setText(name);
        }

        public void setSimpleDraweeView(String url) {
            String urlWithoutSpaces = url.replace(" ","");
            simpleDraweeView.setImageURI(Uri.parse(urlWithoutSpaces));
        }
    }

    public class TitleViewHolder  extends GroupViewHolder{

        @BindView(R.id.title) TextView titleName;
        @BindView(R.id.arrow) ImageView arrow;

        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        private  void setGenreTitle(PlayLists playLists){
            titleName.setText(playLists.getTitle());
        }

        @Override
        public void expand() {
            animateExpand();
            itemView.setBackgroundResource(R.color.gray_on_click);
        }
        @Override
        public void collapse() {
            animateCollapse();
            itemView.setBackgroundResource(0);
        }

        private void animateExpand() {
            RotateAnimation rotate = new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }
    }

    @Override
    public void onClick(View v) {
        String link = (String)v.getTag();
        mListener.onMovieAdapterClicked(link);
    }
}
