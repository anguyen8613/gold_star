package b.android.goldstar;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShopLab {

    private static ShopLab sShopLab;
    private Map<UUID, Shop> mShops;

    private ShopLab(Context context){
        mShops = new LinkedHashMap<>();

        for(int i= 0; i < 20; i++){
            Shop shop = new Shop();
            shop.setName("Shop number: " + i);
            shop.setGoldStars(i % 10);
            shop.setMasterStars(i % 3);
            shop.setImgUrl(i + ".png");
            mShops.put(shop.getId(), shop);
        }
    }

    public static ShopLab get(Context context){
        if(sShopLab == null) {
            sShopLab = new ShopLab(context);
        }
            return sShopLab;

    }

    public List<Shop> getShops(){
        return new ArrayList<>(mShops.values());
    }

    public Shop getShop(UUID shopId){
        return mShops.get(shopId);

    }

}
