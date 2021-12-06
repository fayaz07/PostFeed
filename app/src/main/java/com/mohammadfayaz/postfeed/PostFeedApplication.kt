package com.mohammadfayaz.postfeed

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PostFeedApplication: Application() {

  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG){
      Timber.plant(Timber.DebugTree())
    }
  }

}
