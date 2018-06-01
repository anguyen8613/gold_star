package b.android.goldstar;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class ShopActivity extends SingleFragmentActivity {

    public static final String EXTRA_SHOP_ID = "b.android.goldstar.shop_id";


    @Override
    protected Fragment createFragment(){

        UUID shopId = (UUID) getIntent().getSerializableExtra(EXTRA_SHOP_ID);
        ShopFragment fragment = ShopFragment.newInstance(shopId);

        return fragment;
    }

    public static Intent newIntent(Context packageContext, UUID shopId) {

        Intent intent = new Intent(packageContext, ShopActivity.class);
        intent.putExtra(EXTRA_SHOP_ID, shopId);

        return intent;
    }
}