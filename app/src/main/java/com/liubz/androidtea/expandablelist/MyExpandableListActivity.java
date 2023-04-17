package com.liubz.androidtea.expandablelist;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/4/17 3:38 PM
 */
public class MyExpandableListActivity extends ExpandableListActivity {
    private static final String TAG = "MyExpandableListActivity";
    private ExpandableListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("MyExpandableListActivity");
        mAdapter = new MyExpandableListAdapter(this);
        setListAdapter(mAdapter);
        registerForContextMenu(this.getExpandableListView());
    }


    //为列表的每一项创建上下文菜单（即长按后 呼出的菜单）
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("ContexMenu");
        menu.add(0, 0, 0, "ContextMenu");
    }

    //单击上下文菜单后的逻辑
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo) item.getMenuInfo();
        String title = ((TextView) info.targetView).getText().toString();

        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {

            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
            int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
            Toast.makeText(this, title + "-Group Index" + groupPos + "Child Index:" + childPos,
              Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Log.i(TAG, "onChildClick: groupPosition: " + groupPosition + ", childPosition: " + childPosition + ", id: " + id);
        ListAdapter adapter = parent.getAdapter();

        return true;
    }
}