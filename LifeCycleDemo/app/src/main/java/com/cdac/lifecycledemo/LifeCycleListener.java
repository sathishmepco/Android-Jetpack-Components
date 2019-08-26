package com.cdac.lifecycledemo;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class LifeCycleListener implements LifecycleObserver {

    private static final String TAG = LifecycleObserver.class.getCanonicalName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.d(TAG,"OnCreate Called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.d(TAG,"OnStart Called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.d(TAG,"OnResume Called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        Log.d(TAG,"OnPause Called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        Log.d(TAG,"OnStop Called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        Log.d(TAG,"OnDestroy Called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAnyEvent(LifecycleOwner owner,Lifecycle.Event event){
        Log.d(TAG,"OnAny Event : "+owner.getLifecycle().getCurrentState().name());
    }
}
