package e.wilso.project_master.menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import e.wilso.project_master.MainActivity;
import e.wilso.project_master.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends Fragment {



   public TrendFragment() {
      // Required empty public constructor
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      ((MainActivity)getActivity()).setActionBartTitle("Sleep Trend");

      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_trend, container, false);
   }

}
