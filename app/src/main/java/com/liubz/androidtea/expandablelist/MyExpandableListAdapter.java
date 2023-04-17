package com.liubz.androidtea.expandablelist;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/4/17 3:39 PM
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;

    //父列表数据
    private String[] groups = {"group1", "group2", "group3", "group4"};

    //子列表数据
    private String[][] children = {
      {"child1"},
      {"child1", "child2"},
      {"child1", "child2", "child3"},
      {"child1", "child2", "child3", "child4"},
    };

    MyExpandableListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return children[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    //取子列表中的某一项的view
    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = getGenericView();
        ;
        textView.setText(getChild(groupPosition, childPosition).toString());
        return textView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return children[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return groups.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        TextView textView = getGenericView();
        textView.setText(getGroup(groupPosition).toString());

        return textView;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

    //获取某一项的view的逻辑
    private TextView getGenericView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(mContext);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(80, 20, 20, 20);
        return textView;
    }

}