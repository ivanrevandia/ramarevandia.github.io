package ivancorp.menuslidenavigation;

import android.app.Activity;
import android.app.Fragment;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;



public class Splashscreen extends Activity {
    // tracks when the activity is at least partially visible (e.g. under a dialog)
    private boolean mStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // your current code
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setContentView(R.layout.activity_splashscreen);

        if (savedInstanceState == null) {
            // first time onCreate, create fragment which starts countdown
            getFragmentManager()
                    .beginTransaction()
                    .add(SplashFinishFragment.newInstance(), SplashFinishFragment.TAG)
                    .commit();
        } else {
            // fragment already set up from first onCreate after screen rotation
        }
    }

    @Override
    protected void onStart() {
        // the activity becomes at least partially visible
        mStarted = true;

        super.onStart();
    }

    @Override
    protected void onStop() {
        // the activity is no longer visible
        mStarted = false;

        super.onStop();
    }

    public boolean isStarted2() {
        // there is already hidden method isStarted() in the framework
        // you can't use it and are not allowed to override it
        return mStarted;
    }

    public static class SplashFinishFragment extends Fragment {
        private static final String TAG = SplashFinishFragment.class.getSimpleName();

        private static final int DELAY = 1000; // one second delay

        private static final Handler mHandler = new Handler(); // one main thread anyway

        private final Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                if (getActivity() == null) {
                    // this should never happen, there is no activity, so no fragment
                    Log.e(TAG, "No activity!");
                    return;
                }

                Splashscreen a = (Splashscreen) getActivity();

                if (a.isStarted2() || a.isChangingConfigurations()) {
                    // if activity is even partially visible or is rotating screen right now, continue
                    Intent i = new Intent(a, MainActivity.class);
                    a.startActivity(i);
                }

                // in any case close splash
                a.finish();
            }
        };

        public static SplashFinishFragment newInstance() {
            return new SplashFinishFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // the countdown will continue (not reset) across screen rotations
            setRetainInstance(true);

            // try running the main activity after specified time
            mHandler.postDelayed(mRunnable, DELAY);
        }

        @Override
        public void onDestroy() {
            // if the fragment gets destroyed (e.g. activity closes) do not launch main activity
            mHandler.removeCallbacks(mRunnable);

            super.onDestroy();
        }
    }
}