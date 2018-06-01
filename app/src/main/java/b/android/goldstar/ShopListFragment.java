package b.android.goldstar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShopListFragment extends Fragment {

    private RecyclerView mShopRecyclerView;
    private ShopAdapter mAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_shop_list, parent,false);

        mShopRecyclerView = view.findViewById(R.id.shop_recycler_view);
        mShopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();


        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    private void updateUI(){

        ShopLab shopLab = ShopLab.get(getActivity());
        List<Shop> shops = shopLab.getShops();

        if(mAdapter == null) {
            mAdapter = new ShopAdapter(shops);

            mShopRecyclerView.setAdapter(mAdapter);
        }

    }

    private class ShopHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mShopNameTextView;
        private TextView mShopSilverStarsTextView;
        private TextView mShopGoldStarsTextView;
        private List<ImageView> mStars;
        private ImageView mBs_0;
        private ImageView mBs_1;
        private ImageView mBs_2;
        private ImageView mBs_3;
        private ImageView mBs_4;
        private ImageView mBs_5;
        private ImageView mBs_6;
        private ImageView mBs_7;
        private ImageView mBs_8;
        private ImageView mBs_9;





        private Shop mShop;

        public ShopHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_shop, parent, false));
            itemView.setOnClickListener(this);
            mShopNameTextView = itemView.findViewById(R.id.shop_name);
            mShopSilverStarsTextView = itemView.findViewById(R.id.shop_silver_stars);
            mShopGoldStarsTextView = itemView.findViewById(R.id.shop_gold_stars);

            mBs_0 = itemView.findViewById(R.id.bs_0);
            mBs_1 = itemView.findViewById(R.id.bs_1);
            mBs_2 = itemView.findViewById(R.id.bs_2);
            mBs_3 = itemView.findViewById(R.id.bs_3);
            mBs_4 = itemView.findViewById(R.id.bs_4);
            mBs_5 = itemView.findViewById(R.id.bs_5);
            mBs_6 = itemView.findViewById(R.id.bs_6);
            mBs_7 = itemView.findViewById(R.id.bs_7);
            mBs_8 = itemView.findViewById(R.id.bs_8);
            mBs_9 = itemView.findViewById(R.id.bs_9);

            mStars = new ArrayList<>();
            mStars.add(mBs_0);
            mStars.add(mBs_1);
            mStars.add(mBs_2);
            mStars.add(mBs_3);
            mStars.add(mBs_4);
            mStars.add(mBs_5);
            mStars.add(mBs_6);
            mStars.add(mBs_7);
            mStars.add(mBs_8);
            mStars.add(mBs_9);




        }

        @Override
        public void onClick(View view) {
            Intent intent = ShopPagerActivity.newIntent(getActivity(), mShop.getId());
            startActivity(intent);
        }



        public void bind(Shop shop) {
            mShop = shop;
            mShopNameTextView.setText(mShop.getName());
            mShopSilverStarsTextView.setText("SilverStars: " + mShop.getGoldStars());
            mShopGoldStarsTextView.setText("GoldStars: " + mShop.getMasterStars());
            setStars();
        }

        public void setStars(){

            for(int i = 0; i < mShop.getGoldStars(); i++){
                mStars.get(i).setImageDrawable(ContextCompat.getDrawable(getContext(),android.R.drawable.btn_star_big_on));
            }
        }



    }

    private class ShopAdapter extends RecyclerView.Adapter<ShopHolder> {

        private List<Shop> mShops;

        public ShopAdapter(List<Shop> shops) {
            mShops = shops;
        }

        public ShopHolder onCreateViewHolder(ViewGroup parent, int viewType){

            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new ShopHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(ShopHolder holder, int position) {

            Shop shop = mShops.get(position);

            holder.bind(shop);
        }


        @Override
        public int getItemCount(){
            return mShops.size();
        }
    }



}
