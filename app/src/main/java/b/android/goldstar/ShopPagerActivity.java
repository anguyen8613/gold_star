package b.android.goldstar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class ShopPagerActivity extends AppCompatActivity {

    private static final String EXTRA_SHOP_ID = "b.android.goldstar_shop_id";
    private ViewPager mShopViewPager;

    private List<Shop> mShops;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_pager);

        UUID shopId = (UUID) getIntent().getSerializableExtra(EXTRA_SHOP_ID);

        mShopViewPager = findViewById(R.id.shop_view_pager);

        mShops = ShopLab.get(this).getShops();

        FragmentManager fm = getSupportFragmentManager();

        mShopViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Shop shop = mShops.get(position);
                return ShopFragment.newInstance(shop.getId());
            }

            @Override
            public int getCount() {
               return mShops.size();
            }
        });

        for(int i = 0; i < mShops.size(); i++) {
            if(mShops.get(i).getId().equals(shopId)){
                mShopViewPager.setCurrentItem(i);
                break;
            }
        }

    }








    public static Intent newIntent(Context packageContext, UUID shopId) {

        Intent intent = new Intent(packageContext, ShopPagerActivity.class);
        intent.putExtra(EXTRA_SHOP_ID, shopId);

        return intent;
    }
}
