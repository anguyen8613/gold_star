package b.android.goldstar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopFragment extends Fragment{

    private static final String ARG_SHOP_ID = "shop_id";

    private TextView mShopNameTextView;
    private TextView mShopSilverStarsTextView;
    private TextView mShopGoldStarsTextView;
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

    private ImageView mMs_1;
    private ImageView mMs_0;

    List<ImageView> mStars;
    List<ImageView> mMasterStars;

    private Shop mShop;

    public static ShopFragment newInstance(UUID shopId){

        Bundle args = new Bundle();
        args.putSerializable(ARG_SHOP_ID, shopId);

        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID shopId = (UUID) getArguments().getSerializable(ARG_SHOP_ID);

        mShop = ShopLab.get(getActivity()).getShop(shopId);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, parent, false);

        mShopNameTextView = view.findViewById(R.id.shop_name);
        mShopNameTextView.setText(mShop.getName());

        mShopSilverStarsTextView = view.findViewById(R.id.shop_silver_stars);
        mShopSilverStarsTextView.setText("GoldStars: ");

        mShopGoldStarsTextView = view.findViewById(R.id.shop_gold_stars);
        mShopGoldStarsTextView.setText("MasterStars:  ");


        mBs_0 = view.findViewById(R.id.bs_0);
        mBs_1 = view.findViewById(R.id.bs_1);
        mBs_2 = view.findViewById(R.id.bs_2);
        mBs_3 = view.findViewById(R.id.bs_3);
        mBs_4 = view.findViewById(R.id.bs_4);
        mBs_5 = view.findViewById(R.id.bs_5);
        mBs_6 = view.findViewById(R.id.bs_6);
        mBs_7 = view.findViewById(R.id.bs_7);
        mBs_8 = view.findViewById(R.id.bs_8);
        mBs_9 = view.findViewById(R.id.bs_9);

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

        mMs_0 = view.findViewById(R.id.ms_0);
        mMs_1 = view.findViewById(R.id.ms_1);

        mMasterStars = new ArrayList<>();
        mMasterStars.add(mMs_0);
        mMasterStars.add(mMs_1);

        setStars();
        return view;
    }

    public void setStars(){

        for(int i = 0; i < mShop.getGoldStars(); i++){
            mStars.get(i).setImageDrawable(ContextCompat.getDrawable(getContext(),android.R.drawable.btn_star_big_on));
        }

        for(int i = 0; i < mShop.getMasterStars(); i++){
            mMasterStars.get(i).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.master_star2));
        }



    }

}
