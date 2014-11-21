package com.me.coopapp.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.me.coopapp.ui.IUploadImage;

public class UploadImage implements IUploadImage {
	
	Context appContext;
	
	public UploadImage(Context _appContext) {
		appContext = _appContext;
	}

	@Override
	public void uploadImage() {
		
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
				 "content://media/internal/images/media")); 
				 appContext.startActivity(intent);
		
	}

}
