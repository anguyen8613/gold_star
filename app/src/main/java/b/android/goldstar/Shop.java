package b.android.goldstar;

import java.util.UUID;

public class Shop {

    private UUID mId;
    private String mName;
    private int mGoldStars;
    private int mMasterStars;
    private String mImgUrl;

    public Shop(){
        mId = UUID.randomUUID();
        mGoldStars = 0;
        mMasterStars = 0;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getGoldStars() {
        return mGoldStars;
    }

    public void setGoldStars(int goldStars) {
        mGoldStars = goldStars;
    }

    public int getMasterStars() {
        return mMasterStars;
    }

    public void setMasterStars(int masterStars) {
        mMasterStars = masterStars;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        mImgUrl = imgUrl;
    }
}
