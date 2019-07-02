package com.trance.netstrategy.DesignMode.Template;

import com.trance.netstrategy.DesignMode.o;

public abstract class AbstractSwordman {
    //该方法为final，防止算法框架被复写
    public final void fighting(){
        //运行内功，抽象方法
        neigong();
        //调整经脉，具体方法
        meridian();
        //如果有武器，则准备武器
        if (hasWeapons()) {
            weapons();
        }
        //使用招式
        moves();
        //钩子方法
        hook();
    }

    //空实现方法
    protected void hook(){}
    protected abstract void neigong();
    protected abstract void weapons();
    protected abstract void moves();

    protected void meridian(){
        o.p("开启正经与奇经");
    }

    /**
     * 是否有武器，默认是有武器的，钩子方法
     */
    protected boolean hasWeapons() {
        return true;
    }

}
