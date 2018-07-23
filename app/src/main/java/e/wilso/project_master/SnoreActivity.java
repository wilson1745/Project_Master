package e.wilso.project_master;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import e.wilso.project_master.audiotest.modules.AudioView;
import e.wilso.project_master.audiotest.modules.AudioViewLayout;

public class SnoreActivity extends AppCompatActivity {

   AudioView audioView;
   AudioViewLayout audioViewLayout;
   Button btn_test;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_snore);

      btn_test = findViewById(R.id.btn_test);
      btn_test.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(SnoreActivity.this, AudioViewLayout.class);
            startActivity(intent);
         }
      });

      /*audioView = new AudioView(this);
      setContentView(audioView);*/
      Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
   }

   @Override
   protected void onResume() {
      super.onResume();
      /*audioView = new AudioView(this);
      setContentView(audioView);*/
      Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
   }

   @Override
   protected void onPause() {
      super.onPause();
      Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
   }
}
