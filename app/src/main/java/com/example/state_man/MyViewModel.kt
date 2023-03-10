package com.example.state_man

import android.app.Application
import com.saurabhbadola.statesman.BaseViewModel
import com.saurabhbadola.statesman.NavigationRoute


class MyViewModel(application: Application): BaseViewModel<ModelState>(application = application) {
    override fun createInitialState(): ModelState {
        return ModelState(1,1)
    }

    fun navigation(){
        navigateTo(NavigationRoute(Route.OPEN.name,Route.OPEN.ordinal))
    }

    fun setStateChecked(switch_increment:Int,test_increment:Int,auto_switch:Boolean,auto_test:Boolean){
          setState(
              ModelState(
                  auto_switch  = auto_switch,
                  auto_test = auto_test,
                  switch_increment = switch_increment,
                  test_increment = test_increment
              )
          )
    }

    fun setSwitchIncrement(time:Int){
        setState(
            ModelState(
                switch_increment = time+1
            )
        )
    }

    fun setTestIncrement(time:Int){
        setState(
            ModelState(
                test_increment = time+1
            )
        )
    }
    fun setSwitchDecrement(time:Int){
        if(time>1){
            setState(
                ModelState(
                    switch_increment = time-1
                )
            )
        }
    }
    fun setTestDecrement(time:Int){
        if(time>1){
            setState(
                ModelState(
                    test_increment = time-1
                )
            )
        }
    }

    fun setChangeStatus(value:Boolean){
        setState(
            ModelState(
                changeStatus = value
            )
        )
    }

    fun navigationChange(){
        navigateTo(NavigationRoute(Route.NOT_OPEN.name,Route.NOT_OPEN.ordinal))
    }


    fun backPress(){
        navigateTo(NavigationRoute(Route.BACK.name,Route.BACK.ordinal))
    }
}

enum class Route {
    OPEN,
    NOT_OPEN,
    BACK,
}