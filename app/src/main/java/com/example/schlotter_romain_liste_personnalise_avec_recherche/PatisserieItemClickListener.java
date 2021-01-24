package com.example.schlotter_romain_liste_personnalise_avec_recherche;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class PatisserieItemClickListener implements RecyclerView.OnItemTouchListener {
    private final OnItemClickListener mListener;

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }
    GestureDetector mGestureDetector;

    public PatisserieItemClickListener(Context context, OnItemClickListener listener)
    {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent e)
            {
                return true;
            }
        });
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e)
    {
        View childView = view.findChildViewUnder(e.getX(),e.getY());
        if(childView != null && mListener!=null && mGestureDetector.onTouchEvent(e))
        {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view,MotionEvent motionEvent)
    {}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)
    {}
}
