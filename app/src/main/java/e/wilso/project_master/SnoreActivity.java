package e.wilso.project_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import e.wilso.project_master.audiotest.modules.AudioView;

public class SnoreActivity extends AppCompatActivity {

   AudioView audioView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
   }

   @Override
   protected void onResume() {
      super.onResume();

      audioView = new AudioView(this);
      setContentView(audioView);
      Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
   }

   @Override
   protected void onPause() {
      super.onPause();
      Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
   }
}
