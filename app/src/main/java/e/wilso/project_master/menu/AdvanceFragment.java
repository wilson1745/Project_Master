package e.wilso.project_master.menu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.wilso.project_master.MainActivity;
import e.wilso.project_master.R;
import e.wilso.project_master.advance.EmailActivity;
import e.wilso.project_master.advance.LanguageActivity;
import e.wilso.project_master.advance.PersonalActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvanceFragment extends Fragment {

   private View view;
   private ListView listView;
   private ArrayAdapter adapter;
   private Intent intent;

   public AdvanceFragment() {
      // Required empty public constructor
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      ((MainActivity)getActivity()).setActionBartTitle("Advance");
      final String[] Item = getResources().getStringArray(R.array.advance);

      //ToolMenuAdapter adapter = new ToolMenuAdapter(getActivity());

      view = inflater.inflate(R.layout.fragment_advance, container, false);
      listView = view.findViewById(R.id.ad_list);
      adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, Item);
      //listView.setAdapter(adapter);
      listView.setAdapter(adapter);

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
               case 0:
                  Toast.makeText(getActivity(), "Memo", Toast.LENGTH_SHORT).show();
                  break;
               case 1:
                  intent = new Intent(getActivity(), PersonalActivity.class);
                  startActivity(intent);
                  Toast.makeText(getActivity(), "Personal Information", Toast.LENGTH_SHORT).show();
                  break;
               case 2:
                  Toast.makeText(getActivity(), "Output Result", Toast.LENGTH_SHORT).show();
                  break;
               case 3:
                  intent = new Intent(getActivity(), LanguageActivity.class);
                  startActivity(intent);
                  Toast.makeText(getActivity(), "Languages", Toast.LENGTH_SHORT).show();
                  break;
               case 4:
                  intent = new Intent(getActivity(), EmailActivity.class);
                  startActivity(intent);
                  Toast.makeText(getActivity(), "Feedback", Toast.LENGTH_SHORT).show();
                  break;
            }
         }
      });

      // Inflate the layout for this fragment
      //return inflater.inflate(R.layout.fragment_advance, container, false);
      return view;
   }

}
