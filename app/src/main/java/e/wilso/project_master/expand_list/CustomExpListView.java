package e.wilso.project_master.expand_list;

import android.content.Context;
import android.widget.ExpandableListView;

public class CustomExpListView extends ExpandableListView {

   public CustomExpListView(Context context) {
        super(context);
   }

   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      // 螢幕寬度的關鍵
      widthMeasureSpec = MeasureSpec.makeMeasureSpec(1400, MeasureSpec.EXACTLY);
      //widthMeasureSpec = MeasureSpec.makeMeasureSpec(960, MeasureSpec.AT_MOST);
      heightMeasureSpec = MeasureSpec.makeMeasureSpec(20000, MeasureSpec.AT_MOST);
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
   }
}

