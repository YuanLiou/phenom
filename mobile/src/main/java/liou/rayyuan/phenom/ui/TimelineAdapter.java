package liou.rayyuan.phenom.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;

import liou.rayyuan.phenom.BR;
import liou.rayyuan.phenom.R;
import liou.rayyuan.phenom.model.repository.PlurkDataProvider;
import liou.rayyuan.phenom.model.repository.UserDataProvider;
import liou.rayyuan.phenom.viewmodel.PlurkUserViewModel;
import liou.rayyuan.phenom.viewmodel.PlurkViewModel;

/**
 * Created by louis383 on 2016/6/6.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> implements SwipeableItemAdapter<TimelineAdapter.ViewHolder> {

    private PlurkDataProvider plurkDataProvider;
    private UserDataProvider userDataProvider;

    public TimelineAdapter(PlurkDataProvider plurkDataProvider, UserDataProvider userDataProvider) {
        this.plurkDataProvider = plurkDataProvider;
        this.userDataProvider = userDataProvider;
    }

    @Override
    public int getItemCount() {
        return plurkDataProvider.getCount();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.timeline_adapter,
                parent,
                false);

        ViewHolder holder = new ViewHolder(binding.getRoot());
        holder.setBinding(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlurkViewModel plurk = plurkDataProvider.getItem(position).getViewModel();
        PlurkUserViewModel usersDetail = userDataProvider.getUserDetail(plurk.getOwnerId()).getViewModel();
        
        holder.bind(plurk, usersDetail);
    }

    @Override
    public SwipeResultAction onSwipeItem(ViewHolder holder, int position, int result) {
        return null;
    }

    @Override
    public int onGetSwipeReactionType(ViewHolder holder, int position, int x, int y) {
        return 0;
    }

    @Override
    public void onSetSwipeBackground(ViewHolder holder, int position, int type) {
    }

    public static class ViewHolder extends AbstractSwipeableItemViewHolder {

        ViewDataBinding binding;
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

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public void bind(PlurkViewModel plurkViewModel, PlurkUserViewModel userViewModel) {
            binding.setVariable(BR.plurk, plurkViewModel);
            binding.setVariable(BR.user, userViewModel);
            binding.executePendingBindings();
        }
    }
}
