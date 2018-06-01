package b.android.goldstar;

import android.support.v4.app.Fragment;

public class ShopListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){

        return new ShopListFragment();
    }
}
