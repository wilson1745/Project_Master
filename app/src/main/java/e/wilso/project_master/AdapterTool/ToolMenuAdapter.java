package e.wilso.project_master.AdapterTool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import e.wilso.project_master.R;

public class ToolMenuAdapter extends BaseAdapter {

   private LayoutInflater mInflater;
   private String[] array;

   private List<Bitmap> bitmaps = new ArrayList<Bitmap>();

   public ToolMenuAdapter(Context context)
   {
      mInflater = LayoutInflater.from(context);
      array = context.getResources().getStringArray(R.array.advance);

      bitmaps.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_camera));
      bitmaps.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_gallery));
      bitmaps.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_manage));
      bitmaps.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_send));
      bitmaps.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_menu_share));
   }

   @Override
   public int getCount()
   {
      return array.length;
   }

   @Override
   public Object getItem(int arg0)
   {
      // TODO Auto-generated method stub
      return array[arg0];
   }

   @Override
   public long getItemId(int arg0)
   {
      // TODO Auto-generated method stub
      return arg0;
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder holder;

      if (convertView == null) {
         convertView = mInflater.inflate(R.layout.list_item, null);

         holder = new ViewHolder();
         holder.text = (TextView) convertView.findViewById(R.id.text);
         holder.icon = (ImageView) convertView.findViewById(R.id.icon);

         convertView.setTag(holder);
      }
      else {

         holder = (ViewHolder) convertView.getTag();
      }

      holder.text.setText(array[position]);
      holder.icon.setImageBitmap(bitmaps.get(position));

      return convertView;
   }

   static class ViewHolder {
      TextView text;
      ImageView icon;
   }

}
