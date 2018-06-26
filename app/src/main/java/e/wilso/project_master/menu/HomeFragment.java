package e.wilso.project_master.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import e.wilso.project_master.MainActivity;
import e.wilso.project_master.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

   private Button btn_alarm, btn_light;
   private View view;
   private Intent intent;

   public HomeFragment() {
      // Required empty public constructor
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      ((MainActivity)getActivity()).setActionBartTitle("Home");
      findView(inflater, container);

      btn_alarm.setOnClickListener(this);
      btn_light.setOnClickListener(this);

      // Inflate the layout for this fragment
      return view;
   }

   private void findView(LayoutInflater inflater, ViewGroup container) {
      view = inflater.inflate(R.layout.fragment_home, container, false);
      btn_alarm = view.findViewById(R.id.btn_alarm);
      btn_light = view.findViewById(R.id.btn_light);

   }

   @Override
   public void onClick(View v) {
      int i = v.getId();

      /*if(i == btn_alarm.getId()) {
         intent = new Intent(getActivity(), AlarmActivity.class);
         startActivity(intent);
         Toast.makeText(getActivity(), "AlarmActivity", Toast.LENGTH_SHORT).show();
      }
      else if(i == btn_light.getId()) {
         intent = new Intent(getActivity(), LightTestActivity.class);
         startActivity(intent);
         Toast.makeText(getActivity(), "LightTestActivity", Toast.LENGTH_SHORT).show();
      }*/
   }
}
