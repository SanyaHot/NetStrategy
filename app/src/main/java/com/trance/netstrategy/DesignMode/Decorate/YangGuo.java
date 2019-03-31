package com.trance.netstrategy.DesignMode.Decorate;

import com.trance.netstrategy.DesignMode.o;

public class YangGuo extends Swordman {
    @Override
    public void attachMagic() {
        //杨过初始学的是全真剑法
        o.p("杨过使用全真剑法");
    }
}
