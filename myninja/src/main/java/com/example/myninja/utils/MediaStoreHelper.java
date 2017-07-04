package com.vikkyb.myninja.utils;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.vikkyb.myninja.FilePickerConst;
import com.vikkyb.myninja.cursors.DocScannerTask;
import com.vikkyb.myninja.cursors.loadercallbacks.FileResultCallback;
import com.vikkyb.myninja.cursors.loadercallbacks.PhotoDirLoaderCallbacks;
import com.vikkyb.myninja.models.Document;
import com.vikkyb.myninja.models.PhotoDirectory;

public class MediaStoreHelper {

  public static void getPhotoDirs(FragmentActivity activity, Bundle args, FileResultCallback<PhotoDirectory> resultCallback) {
    if(activity.getSupportLoaderManager().getLoader(FilePickerConst.MEDIA_TYPE_IMAGE)!=null)
      activity.getSupportLoaderManager().restartLoader(FilePickerConst.MEDIA_TYPE_IMAGE, args, new PhotoDirLoaderCallbacks(activity, resultCallback));
    else
      activity.getSupportLoaderManager().initLoader(FilePickerConst.MEDIA_TYPE_IMAGE, args, new PhotoDirLoaderCallbacks(activity, resultCallback));
  }

  public static void getVideoDirs(FragmentActivity activity, Bundle args, FileResultCallback<PhotoDirectory> resultCallback) {
    if(activity.getSupportLoaderManager().getLoader(FilePickerConst.MEDIA_TYPE_VIDEO)!=null)
      activity.getSupportLoaderManager().restartLoader(FilePickerConst.MEDIA_TYPE_VIDEO, args, new PhotoDirLoaderCallbacks(activity, resultCallback));
    else
      activity.getSupportLoaderManager().initLoader(FilePickerConst.MEDIA_TYPE_VIDEO, args, new PhotoDirLoaderCallbacks(activity, resultCallback));
  }

  public static void getDocs(FragmentActivity activity, FileResultCallback<Document> fileResultCallback)
  {
    new DocScannerTask(activity,fileResultCallback).execute();
  }
}