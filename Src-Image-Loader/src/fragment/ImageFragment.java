package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.R;
import com.example.listener.AnimateFirstDisplayListener;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;


public class ImageFragment extends SherlockFragment
{
	private View mRootView;
	private ImageLoader mImageLoader = ImageLoader.getInstance();
	private DisplayImageOptions mDisplayImageOptions;
	private ImageLoadingListener mImageLoadingListener;

	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		// image caching options
		mDisplayImageOptions = new DisplayImageOptions.Builder()
			.showStubImage(android.R.color.transparent)
			.showImageForEmptyUri(R.drawable.placeholder_photo)
			.showImageOnFail(R.drawable.placeholder_photo)
			.cacheInMemory()
			.cacheOnDisc()
			.displayer(new SimpleBitmapDisplayer())
			.build();
		mImageLoadingListener = new AnimateFirstDisplayListener();
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{	
		mRootView = inflater.inflate(R.layout.fragment_image, container, false);
		return mRootView;
	}
	
	
	private void renderView()
	{
		// reference
		ImageView photoImageView = (ImageView) mRootView.findViewById(R.id.fragment_image_photo);

		// image caching
		mImageLoader.displayImage("http://placehold.it/200x200/ccc/4a4&text=hello", photoImageView, mDisplayImageOptions, mImageLoadingListener);
	}
}
