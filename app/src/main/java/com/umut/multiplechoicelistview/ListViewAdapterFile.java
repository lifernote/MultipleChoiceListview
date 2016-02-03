package com.umut.multiplechoicelistview;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapterFile extends BaseAdapter {



	private ArrayList<Integer> list = new ArrayList<>();
	private Context context;
	private ArrayList<Case> caseArrayList;
	private final String TAG = ListViewAdapterFile.class.getSimpleName();
	static ArrayList<String> listPK = new ArrayList<>();


	public ListViewAdapterFile(Context context, int item_listview, ArrayList<Case> products) {
		this.context = context;
		this.caseArrayList = products;
		Log.i(TAG, "init adapter");
	}




	@Override
	public int getCount() {
		return caseArrayList.size();
	}

	@Override
	public Object getItem(int i) {
		return caseArrayList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		final ViewHolder viewHolder;

		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_listview, null);
			viewHolder = new ViewHolder(convertView);


			viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

					int getPosition = (Integer) compoundButton.getTag();

					if (viewHolder.checkBox.isChecked()) {
						viewHolder.checkBox.setTag(getPosition);

						if(!list.contains(viewHolder.checkBox.getTag()))
							list.add((Integer) viewHolder.checkBox.getTag());

						caseArrayList.get(getPosition).setState(true);
						viewHolder.linearLayout.setBackgroundResource(R.color.checked);

						if(!listPK.contains(viewHolder.tv4.getText().toString()))
							listPK.add(viewHolder.tv4.getText().toString());


					} else {
						caseArrayList.get(getPosition).setState(false);
						viewHolder.checkBox.setTag(getPosition);

						if (list.contains(viewHolder.checkBox.getTag()))
							list.remove(viewHolder.checkBox.getTag());

						viewHolder.linearLayout.setBackgroundResource(R.color.unchecked);

						if(listPK.contains(viewHolder.tv4.getText().toString()))
							listPK.remove(viewHolder.tv4.getText().toString());

					}
				}
			});



			convertView.setTag(viewHolder);
			convertView.setTag(R.id.textViewListitem1,viewHolder.tv1);
			convertView.setTag(R.id.textViewListitem2,viewHolder.tv2);
			convertView.setTag(R.id.textViewListitem3,viewHolder.tv3);
			convertView.setTag(R.id.textViewListitem4,viewHolder.tv4);
			convertView.setTag(R.id.textViewListitemId,viewHolder.tvID);
			convertView.setTag(R.id.checkBox_itemstate, viewHolder.checkBox);
			convertView.setTag(R.id.listitemLayout,viewHolder.linearLayout);



		}else{
			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.checkBox.setTag(position);
		}
		viewHolder.checkBox.setTag(position);

		viewHolder.tv1.setText(caseArrayList.get(position).getStringValue1());
		viewHolder.tv2.setText(caseArrayList.get(position).getStringValue2());
		viewHolder.tv3.setText(caseArrayList.get(position).getStringValue3());
		viewHolder.tv4.setText(caseArrayList.get(position).getStringValue4());
		viewHolder.tvID.setText(caseArrayList.get(position).getStringValue5());

		if (list.contains(position) && caseArrayList.get(position).getState()){
			viewHolder.checkBox.setChecked(true);
		}else {
			viewHolder.checkBox.setChecked(false);
		}




		return convertView;
	}


	private class ViewHolder{

		private TextView tv1;
		private TextView tv2;
		private TextView tv3;
		private TextView tv4;
		private TextView tvID;
		private CheckBox checkBox;
		private LinearLayout linearLayout;



		public ViewHolder(View convertView) {

			tv1 = (TextView) convertView.findViewById(R.id.textViewListitem1);
			tv2 = (TextView) convertView.findViewById(R.id.textViewListitem2);
			tv3 = (TextView) convertView.findViewById(R.id.textViewListitem3);
			tv4 = (TextView) convertView.findViewById(R.id.textViewListitem4);
			tvID = (TextView) convertView.findViewById(R.id.textViewListitemId);
			checkBox = (CheckBox) convertView.findViewById(R.id.checkBox_itemstate);
			linearLayout = (LinearLayout) convertView.findViewById(R.id.listitemLayout);
		}

	}




}
