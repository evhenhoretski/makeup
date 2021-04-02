package evhen_project.makeup.stubs;

import evhen_project.makeup.entity.Advertisement;

public final class AdvertisementStub {
    public static final Long ID = 1l;
    public static final String NAME = "NAME";
    public static Advertisement getRandomAdvertisement(){
        return Advertisement.builder()
                .id(ID)
                .name(NAME)
                .build();
    }
}
