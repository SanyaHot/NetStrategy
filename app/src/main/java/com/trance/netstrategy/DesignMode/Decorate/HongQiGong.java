package com.trance.netstrategy.DesignMode.Decorate;

import com.trance.netstrategy.DesignMode.o;

public class HongQiGong extends Master {

    public HongQiGong(Swordman swordman) {
        super(swordman);
    }

    public void teachAttachMagic() {
        o.p("洪七公教授打狗棒法");
        o.p("杨过使用打狗棒法");
    }

    @Override
    public void attachMagic() {
        super.attachMagic();
        teachAttachMagic();
    }
}
