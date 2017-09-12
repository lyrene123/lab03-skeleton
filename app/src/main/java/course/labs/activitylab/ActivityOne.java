package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";
		int createCount, startCount, resumeCount, pauseCount, stopCount, destroyCount, restartCount;
		TextView tvCreate, tvStart, tvResume, tvPause, tvStop, tvDestroy, tvRestart;

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			tvCreate = (TextView) findViewById(R.id.create);
			tvStart = (TextView) findViewById(R.id.start);
			tvResume = (TextView) findViewById(R.id.resume);
			tvPause = (TextView) findViewById(R.id.pause);
			tvStop = (TextView) findViewById(R.id.stop);
			tvDestroy = (TextView) findViewById(R.id.destroy);
			tvRestart = (TextView) findViewById(R.id.restart);

			if(savedInstanceState != null){
				createCount = savedInstanceState.getInt("createCount");
				startCount = savedInstanceState.getInt("startCount");
				resumeCount = savedInstanceState.getInt("resumeCount");
				pauseCount = savedInstanceState.getInt("pauseCount");
				stopCount = savedInstanceState.getInt("stopCount");
				destroyCount = savedInstanceState.getInt("destroyCount");
				restartCount = savedInstanceState.getInt("restartCount");
			}else {
				SharedPreferences prefs = getPreferences(MODE_PRIVATE);
				createCount = Integer.parseInt(prefs.getString("restartCount", "0"));
				startCount = Integer.parseInt(prefs.getString("startCount", "0"));
				resumeCount = Integer.parseInt(prefs.getString("resumeCount", "0"));
				pauseCount = Integer.parseInt(prefs.getString("pauseCount","0"));
				stopCount = Integer.parseInt(prefs.getString("stopCount","0"));
				destroyCount = Integer.parseInt(prefs.getString("destroyCount","0"));
				restartCount = Integer.parseInt(prefs.getString("restartCount","0"));

				tvCreate.setText("onCreate() calls: " + prefs.getString("createCount", "0"));
				tvStart.setText("onStart() calls: " + prefs.getString("startCount", "0"));
				tvResume.setText("onResume() calls: " + prefs.getString("resumeCount", "0"));
				tvPause.setText("onPause() calls: " + prefs.getString("pauseCount", "0"));
				tvStop.setText("onStop() calls: " + prefs.getString("stopCount", "0"));
				tvDestroy.setText("onDestroy() calls: " + prefs.getString("destroyCount", "0"));
				tvRestart.setText("onRestart() calls: " + prefs.getString("restartCount", "0"));
			}
			
			//Log cat print out
			Log.i(TAG, "onCreate called");
			createCount++;
			tvCreate.setText("onCreate() calls: " + Integer.toString(createCount));
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");
			startCount++;
			tvStart.setText("onStart() calls: " + Integer.toString(startCount));
		}

		@Override
		public void onResume(){
			super.onResume();

			//Log cat print out
			Log.i(TAG, "onResume called");
			resumeCount++;
			tvResume.setText("onResume() calls " + Integer.toString(resumeCount));
		}

		@Override
		public void onPause(){
			super.onPause();

			//Log cat print out
			Log.i(TAG, "onPause called");
			pauseCount++;
			tvPause.setText("onPause() calls " + Integer.toString(pauseCount));


		}

		@Override
		public void onStop(){
			super.onStop();

			//Log cat print out
			Log.i(TAG, "onStop called");
			stopCount++;
			tvStop.setText("onStop() calls: " + Integer.toString(stopCount));


		}

		@Override
		public void onDestroy(){
			super.onDestroy();

			//Log cat print out
			Log.i(TAG, "onDestroy called");
			destroyCount++;
			tvDestroy.setText("onDestroy() calls: " + Integer.toString(destroyCount));
		}

		@Override
		public void onRestart(){
			super.onRestart();

			//Log cat print out
			Log.i(TAG, "onRestart called");
			restartCount++;
			tvRestart.setText("onRestart() calls: " + Integer.toString(restartCount));
		}

	public void saveState(View view) {
		SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();

		editor.putString("createCount", Integer.toString(createCount));
		editor.putString("startCount", Integer.toString(startCount));
		editor.putString("resumeCount", Integer.toString(resumeCount));
		editor.putString("pauseCount", Integer.toString(pauseCount));
		editor.putString("stopCount", Integer.toString(stopCount));
		editor.putString("destroyCount", Integer.toString(destroyCount));
		editor.putString("restartCount", Integer.toString(restartCount));

		tvCreate.setText("onCreate() calls: ");
		tvStart.setText("onStart() calls: ");
		tvResume.setText("onResume() calls: ");
		tvPause.setText("onPause() calls: ");
		tvStop.setText("onStop() calls: ");
		tvDestroy.setText("onDestroy() calls: ");
		tvRestart.setText("onRestart() calls: ");

		editor.commit();
	}


		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			super.onSaveInstanceState(savedInstanceState);
			savedInstanceState.putInt("createCount", createCount);
			savedInstanceState.putInt("startCount", startCount);
			savedInstanceState.putInt("resumeCount", resumeCount);
			savedInstanceState.putInt("pauseCount", pauseCount);
			savedInstanceState.putInt("stopCount", stopCount);
			savedInstanceState.putInt("destroyCount", destroyCount);
			savedInstanceState.putInt("restartCount", restartCount);


		}


		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}
