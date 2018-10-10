package com.a27club.khronos.a27club.presenter;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

private final int mSpace;

    public SpacesItemDecoration(int mSpace) {
        this.mSpace = mSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left=mSpace;
        outRect.right=mSpace;
        outRect.bottom=mSpace;
        if (parent.getChildAdapterPosition(view)==0){
            outRect.top=mSpace;
        }
    }

}
