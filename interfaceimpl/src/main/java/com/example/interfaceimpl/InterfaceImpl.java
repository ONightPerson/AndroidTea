package com.example.interfaceimpl;

import com.example.baseinterface.BaseInterface;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2022/11/28 8:04 PM
 */
public class InterfaceImpl implements BaseInterface {
    @Override
    public String name() {
        return "InterfaceImpl";
    }
}
