package e.wilso.project_master.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import e.wilso.project_master.R;

public class SettingActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_setting);

      getSupportActionBar().setTitle("Setting");
   }
}
