package e.wilso.project_master.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import e.wilso.project_master.MainActivity;
import e.wilso.project_master.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstructFragment extends Fragment {

   private ArrayList<String> groups;
   private ArrayList<ArrayList<ArrayList<String>>> childs;

   private ExpandableListView expandableListView;

   private View view;
   private Context context;

   private int mCurrentPosition = -1;//开关标志

   public InstructFragment() {
      // Required empty public constructor
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      ((MainActivity)getActivity()).setActionBartTitle("Instructions");
      context = getActivity();

      view = inflater.inflate(R.layout.fragment_instruct, container, false);
      expandableListView = view.findViewById(R.id.ins_list);

      loadData();

      myExpandableAdapter adapter = new myExpandableAdapter(context, groups, childs);
      expandableListView.setAdapter(adapter);

      expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
         @Override
         public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
// 自己控制他们打开或者关闭
            // elCommonNum.expandGroup(groupPos);// 打开
            // elCommonNum.collapseGroup(groupPos)// 关闭
            // elCommonNum.setSelectedGroup(groupPosition);//置顶
            if (mCurrentPosition == -1) {// 一个没有打开
               expandableListView.expandGroup(groupPosition);
               mCurrentPosition=groupPosition;
               expandableListView.setSelectedGroup(groupPosition);
            } else {// 至少有一个打开
               // 判断一下是否点击自己
               if(mCurrentPosition==groupPosition){
                  expandableListView.collapseGroup(mCurrentPosition);
                  mCurrentPosition=-1;
                  return true;
               }
               // 关闭上一个
               expandableListView.collapseGroup(mCurrentPosition);
               expandableListView.expandGroup(groupPosition);
               expandableListView.setSelectedGroup(groupPosition);
               // 更新position
               mCurrentPosition=groupPosition;
            }
            return true;
         }
      });

      // Inflate the layout for this fragment
      return view;
   }

   public class myExpandableAdapter extends BaseExpandableListAdapter {

      private ArrayList<String> groups;

      private ArrayList<ArrayList<ArrayList<String>>> children;

      private Context context;

      public myExpandableAdapter(Context context, ArrayList<String> groups, ArrayList<ArrayList<ArrayList<String>>> children) {
         this.context = context;
         this.groups = groups;
         this.children = childs;
      }

      @Override
      public boolean areAllItemsEnabled() {
         return true;
      }

      @Override
      public ArrayList<String> getChild(int groupPosition, int childPosition) {
         return children.get(groupPosition).get(childPosition);
      }

      //Action되는곳
      @Override
      public long getChildId(int groupPosition, int childPosition) {
         Log.v("부모Position", Integer.toString(groupPosition));
         Log.v("자식Position", Integer.toString(childPosition));
         return childPosition;

         //
      }


      @Override
      public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

         String child = (String) ((ArrayList<String>) getChild(groupPosition, childPosition)).get(0);

         if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandablelistview_child, null);
         }

         TextView childtxt = (TextView) convertView.findViewById(R.id.TextViewChild01);

         childtxt.setText(child);

         return convertView;
      }

      @Override
      public int getChildrenCount(int groupPosition) {
         return children.get(groupPosition).size();
      }

      @Override
      public String getGroup(int groupPosition) {
         return groups.get(groupPosition);
      }

      @Override
      public int getGroupCount() {
         return groups.size();
      }

      @Override
      public long getGroupId(int groupPosition) {
         return groupPosition;
      }

      @Override
      public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

         String group = (String) getGroup(groupPosition);

         if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandablelistview_group, null);
         }

         TextView grouptxt = (TextView) convertView.findViewById(R.id.TextViewGroup);

         grouptxt.setText(group);

         return convertView;
      }

      @Override
      public boolean hasStableIds() {
         return true;
      }

      @Override
      public boolean isChildSelectable(int arg0, int arg1) {
         return true;
      }
   }

   private void loadData() {
      final String[] instructions_main = getResources().getStringArray(R.array.instructions_main);
      final String[] welcome = getResources().getStringArray(R.array.welcome);
      final String[] instructions = getResources().getStringArray(R.array.instructions);
      final String[] about_snoring = getResources().getStringArray(R.array.about_snoring);
      final String[] about_diabetes = getResources().getStringArray(R.array.about_diabetes);
      final String[] faqs = getResources().getStringArray(R.array.faqs);

      groups= new ArrayList<String>();
      childs= new ArrayList<ArrayList<ArrayList<String>>>();

      for(int i = 0; i < instructions_main.length; i++) {
         groups.add(instructions_main[i]);
      }

      childs.add(new ArrayList<ArrayList<String>>());
      for(int i = 0; i < welcome.length; i++) {
         childs.get(0).add(new ArrayList<String>());
         childs.get(0).get(i).add(welcome[i]);
      }

      childs.add(new ArrayList<ArrayList<String>>());
      for(int i = 0; i < instructions.length; i++) {
         childs.get(1).add(new ArrayList<String>());
         childs.get(1).get(i).add(instructions[i]);
      }

      childs.add(new ArrayList<ArrayList<String>>());
      for(int i = 0; i < about_snoring.length; i++) {
         childs.get(2).add(new ArrayList<String>());
         childs.get(2).get(i).add(about_snoring[i]);
      }

      childs.add(new ArrayList<ArrayList<String>>());
      for(int i = 0; i < about_diabetes.length; i++) {
         childs.get(3).add(new ArrayList<String>());
         childs.get(3).get(i).add(about_diabetes[i]);
      }

      childs.add(new ArrayList<ArrayList<String>>());
      for(int i = 0; i < faqs.length; i++) {
         childs.get(4).add(new ArrayList<String>());
         childs.get(4).get(i).add(faqs[i]);
      }
   }

}
