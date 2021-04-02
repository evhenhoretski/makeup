package evhen_project.makeup.stubs;

import evhen_project.makeup.entity.Information;

public final class InformationStub {
    public static final Long ID = 1l;
    public static final String NAME = "NAME";
    public static Information getRandomInformation(){
        return Information.builder()
                .id(ID)
                .name(NAME)
                .build();
    }
}
