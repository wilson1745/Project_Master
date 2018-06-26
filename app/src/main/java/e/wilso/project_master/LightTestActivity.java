package e.wilso.project_master;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.hardware.Sensor.TYPE_LIGHT;

public class LightTestActivity extends AppCompatActivity {

   private TextView tv1;
   private ImageView imageView1;
   private SensorManager sensor_manager;
   private MySensorEventListener listener;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_light_test);

      getSupportActionBar().setTitle("Lux Test");
      setBackbutton();

      sensor_manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
      tv1 = findViewById(R.id.msg1);
      imageView1 = findViewById(R.id.imageView1);
      imageView1.setVisibility(View.INVISIBLE);

      // Light傳感器
      Sensor sensor = sensor_manager.getDefaultSensor(TYPE_LIGHT);
      listener = new MySensorEventListener();
      sensor_manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_FASTEST);
   }

   private void setBackbutton() {
      if (getSupportActionBar() != null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setDisplayShowHomeEnabled(true);
      }
   }

   @Override
   public void onBackPressed() {
      int count = getFragmentManager().getBackStackEntryCount();

      if (count == 0) super.onBackPressed();
      else getFragmentManager().popBackStack();
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if (item.getItemId() == android.R.id.home) finish();

      return super.onOptionsItemSelected(item);
   }

   // 感應器事件監聽器
   private class MySensorEventListener implements SensorEventListener {

      // 監控感應器改變
      @Override
      public void onSensorChanged(SensorEvent event) {
         StringBuilder sb = new StringBuilder();
         sb.append("sensor : " + event.sensor.getName() + "\n");

         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();

         // Android 的 Light Sensor 照度偵測內容只有 values[0] 有意義!
         final float lux = event.values[0];
         sb.append("values : " + lux + " Lux\n");
         sb.append("timestamp : " + event.timestamp + " ns\n");
         sb.append("current time : " + sdf.format(date));
         final String msg = sb.toString();

         runOnUiThread(new Runnable() {
            @Override
            public void run() {
               tv1.setText(msg);
               if(lux <= 20) imageView1.setVisibility(View.VISIBLE);
               else imageView1.setVisibility(View.INVISIBLE);
            }
         });
      }

      // 對感應器精度的改變做出回應
      @Override
      public void onAccuracyChanged(Sensor sensor, int accuracy) {

      }
   }

   @Override
   public void onPause() {
      super.onPause();
      sensor_manager.unregisterListener(listener);
   }
}
