package com.trance.netstrategy.DesignMode.Decorate;

import com.trance.netstrategy.DesignMode.o;

public class OuYangFeng extends Master {
    public OuYangFeng(Swordman swordman) {
        super(swordman);
    }

    public void teachAttachMagic() {
        o.p("欧阳锋教授蛤蟆功");
        o.p("杨过使用蛤蟆功");
    }

    @Override
    public void attachMagic() {
        super.attachMagic();
        teachAttachMagic();
    }
}
