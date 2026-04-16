package com.liubz.androidtea.hilt

import javax.inject.Inject

/**
 * @Desc: 名茶数据模型
 */
data class TeaInfo(val name: String, val origin: String, val type: String)

/**
 * @Desc: 名茶数据仓库，使用 @Inject 告知 Hilt 如何提供其实例
 * @Author: liubaozhu
 */
class TeaRepository @Inject constructor() {
    
    fun getTeaList(): List<TeaInfo> {
        return listOf(
            TeaInfo("西湖龙井", "浙江杭州", "绿茶"),
            TeaInfo("安溪铁观音", "福建安溪", "乌龙茶"),
            TeaInfo("云南普洱", "云南西双版纳", "黑茶"),
            TeaInfo("洞庭碧螺春", "江苏苏州", "绿茶"),
            TeaInfo("黄山毛峰", "安徽黄山", "绿茶"),
            TeaInfo("武夷大红袍", "福建武夷山", "乌龙茶")
        )
    }
}
