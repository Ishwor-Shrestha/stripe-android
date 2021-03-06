package com.stripe.android.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.stripe.android.model.ShippingMethod;

import java.util.List;

/**
 * Adapter that populates a list with shipping methods
 */
class ShippingMethodAdapter extends RecyclerView.Adapter<ShippingMethodAdapter.ViewHolder> {

    private List<ShippingMethod> mShippingMethods;
    private int mSelectedIndex = 0;

    ShippingMethodAdapter() {}

    @Override
    public int getItemCount() {
        return mShippingMethods.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public ShippingMethodAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ShippingMethodView shippingMethodView = new ShippingMethodView(viewGroup.getContext());
        return new ViewHolder(shippingMethodView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.setShippingMethod(mShippingMethods.get(i));
        holder.setIndex(i);
        holder.setUIAsSelected(i == mSelectedIndex);
    }

    ShippingMethod getSelectedShippingMethod() {
        return mShippingMethods.get(mSelectedIndex);
    }

    void setShippingMethods(List<ShippingMethod> shippingMethods) {
        mShippingMethods = shippingMethods;
        mSelectedIndex = 0;
        notifyDataSetChanged();
    }

    void setSelectedIndex(int selectedIndex) {
        mSelectedIndex = selectedIndex;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ShippingMethodView shippingMethodView;
        int index;

        ViewHolder(final ShippingMethodView shippingMethodView) {
            super(shippingMethodView);
            this.shippingMethodView = shippingMethodView;
            shippingMethodView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelectedIndex(index);
                }
            });
        }

        void setShippingMethod(ShippingMethod shippingMethod) {
            shippingMethodView.setShippingMethod(shippingMethod);
        }

        void setUIAsSelected(boolean selected) {
            shippingMethodView.setSelected(selected);
        }

        void setIndex(int index) {
            this.index = index;
        }
    }
}
