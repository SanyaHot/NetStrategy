package com.trance.netstrategy.Dagger2;

import javax.inject.Inject;

public class SwordsMan {
    @Inject
    public SwordsMan() {
    }

    public String fighting() {
        return "欲为大树,莫与草争";
    }
}
