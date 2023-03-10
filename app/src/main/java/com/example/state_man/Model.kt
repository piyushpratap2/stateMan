package com.example.state_man

import com.saurabhbadola.statesman.annotations.State
import com.saurabhbadola.statesman.annotations.StateField

@State
data class Model(
    @StateField var switch_increment:Int = 1,
    @StateField var test_increment:Int = 1,
    @StateField var auto_switch:Boolean = false,
    @StateField var auto_test:Boolean = false,
    @StateField var changeStatus:Boolean = false
)
