package liou.rayyuan.phenom.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;

import liou.rayyuan.phenom.R;

/**
 * Created by louis383 on 2016/6/6.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    public static class ViewHolder extends AbstractSwipeableItemViewHolder {

        RelativeLayout container;
        SimpleDraweeView userCover;
        TextView userNickName;
        TextView userAction;
        TextView replurkUserName;
        TextView timeText;
        TextView messageCount;
        TextView message;

        public ViewHolder(View itemView) {
            super(itemView);
            container = (RelativeLayout) itemView.findViewById(R.id.timeline_adapter_layout);
            userCover = (SimpleDraweeView) itemView.findViewById(R.id.timeline_profile_image);
            userNickName = (TextView) itemView.findViewById(R.id.timeline_user_name);
            userAction = (TextView) itemView.findViewById(R.id.timeline_user_feel);
            replurkUserName = (TextView) itemView.findViewById(R.id.timeline_user_replurk);
            timeText = (TextView) itemView.findViewById(R.id.timeline_timestamp);
            messageCount = (TextView) itemView.findViewById(R.id.timeline_number);
            message = (TextView) itemView.findViewById(R.id.timeline_message);
        }

        @Override
        public View getSwipeableContainerView() {
            return container;
        }
    }
}
