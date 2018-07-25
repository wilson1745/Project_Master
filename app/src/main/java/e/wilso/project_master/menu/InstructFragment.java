package e.wilso.project_master.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import e.wilso.project_master.MainActivity;
import e.wilso.project_master.R;
import e.wilso.project_master.expand_list.ParentLevelAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstructFragment extends Fragment {

   private View view;
   private Context context;

   public InstructFragment() {
      // Required empty public constructor
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      ((MainActivity) getActivity()).setActionBartTitle("Instructions");
      context = getActivity();
      view = inflater.inflate(R.layout.fragment_instruct, container, false);

      // Init top level data
      List<String> listDataHeader = new ArrayList<>();
      final String[] mItemHeaders = getResources().getStringArray(R.array.instructions_main);
      Collections.addAll(listDataHeader, mItemHeaders);
      final ExpandableListView mExpandableListView = view.findViewById(R.id.expandableListView_Parent); //expand_main.xml

      if(mExpandableListView != null) {
         ParentLevelAdapter parentLevelAdapter = new ParentLevelAdapter(context, listDataHeader);
         mExpandableListView.setAdapter(parentLevelAdapter);
      }

      mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
         @Override
         public void onGroupExpand(int groupPosition) {
            for (int i = 0; i < mItemHeaders.length; i++) {
               if (groupPosition != i) {
                  mExpandableListView.collapseGroup(i);
               }
            }
         }
      });

      return view;
   }
}
