package lso.naing.lashio;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NaingMyoe on 3/13/2018.
 */

public class ListAdapter extends BaseAdapter {
    private List<MyAdapter> mAdapter;
    private Context mContext;

    public ListAdapter(Context mContex, List<MyAdapter> mAdapter) {
        this.mContext = mContex;
        this.mAdapter = mAdapter;
    }

    @Override
    public int getCount() {
        return mAdapter.size();
    }

    @Override
    public Object getItem(int i) {
        return mAdapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v= View.inflate(mContext,R.layout.custom_list,null);
        TextView title=(TextView)v.findViewById(R.id.title_id);
        TextView description=(TextView)v.findViewById(R.id.description_id);
        ImageView image=(ImageView) v.findViewById(R.id.img_id);
        title.setText(mAdapter.get(i).getTitle());
        description.setText(mAdapter.get(i).getDescription());
        image.setImageResource(mAdapter.get(i).getImage());
        v.getTag(mAdapter.get(i).getId());
        return v;
    }
}
