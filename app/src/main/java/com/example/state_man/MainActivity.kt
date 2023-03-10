package com.example.state_man

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.example.state_man.databinding.ActivityMainBinding
import com.saurabhbadola.statesman.BaseActivity
import com.saurabhbadola.statesman.BaseViewModel
import com.saurabhbadola.statesman.NavigationRoute


class MainActivity : BaseActivity<ModelState>() {
    private var auto_switch:Boolean = false
    private var auto_test:Boolean = false
    private var tempswitch_increment:Int = 1
    private var temptest_increment:Int = 1
    private var switch_increment:Int = 1
    private var test_increment:Int = 1
    private var temp_autoswitch:Boolean = false
    private var temp_autotest:Boolean = false
    private lateinit var myviewmodel:MyViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        auto_switch = SharedPreferencesHelper.getSharedPreferenceBoolean(this,SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_IS_CHECKED,false)
        auto_test = SharedPreferencesHelper.getSharedPreferenceBoolean(this,SharedPreferencesHelper.KEY_AUTO_START_TEST_IS_CHECKED,false)
        switch_increment = SharedPreferencesHelper.getSharedPreferenceInt(this,SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_DURATION,1)
        test_increment = SharedPreferencesHelper.getSharedPreferenceInt(this,SharedPreferencesHelper.KEY_AUTO_START_TEST,1)
        temp_autoswitch = auto_switch
        temp_autotest = auto_test
        tempswitch_increment = switch_increment
        temptest_increment = test_increment
        setContentView(binding.root)
        binding.myviewmodel = myviewmodel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        Log.d("def.TAG","activity on create call")
    }


    override fun createViewModel(): BaseViewModel<ModelState> {
        myviewmodel = ViewModelProvider(this).get(MyViewModel::class.java)
        return myviewmodel
    }

    override fun onNavigationRouteChange(newRoute: NavigationRoute, oldRoute: NavigationRoute) {
        when (newRoute.routeName) {

            Route.BACK.name ->{
                Toast.makeText(this, "sdfkjsdkfljsdklf", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().replace(R.id.container,Fragment1()).addToBackStack(null).commit()
            }

            Route.OPEN.name -> {
                supportFragmentManager.beginTransaction().replace(R.id.container,BlankFragment()).addToBackStack(null).commit()
                SharedPreferencesHelper.setSharedPreferenceBoolean(
                    this,
                    SharedPreferencesHelper.KEY_AUTO_START_TEST_IS_CHECKED,
                    auto_test
                )
                SharedPreferencesHelper.setSharedPreferenceBoolean(
                    this,
                    SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_IS_CHECKED,
                    auto_switch
                )
                SharedPreferencesHelper.setSharedPreferenceInt(
                    this,
                    SharedPreferencesHelper.KEY_AUTO_START_TEST,
                    test_increment
                )
                SharedPreferencesHelper.setSharedPreferenceInt(
                    this,
                    SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_DURATION,
                    switch_increment
                )
                Log.d("def.TAG","onnavigationRoute change call")
                myviewmodel.navigationChange()
            }
        }
    }
    override fun onStateChanged(newState: ModelState, oldState: ModelState){
         myviewmodel.setChangeStatus(
             (newState.mAuto_switch != temp_autoswitch ) || (newState.mAuto_test != temp_autotest)
                     || (newState.mSwitch_increment != tempswitch_increment)
                     || (newState.mTest_increment != temptest_increment)
         )
        newState.mAuto_test?.let {
            auto_test = it
        }

        newState.mAuto_switch?.let {
            if(it!=auto_switch && it){
                SharedPreferencesHelper.setSharedPreferenceInt(this,SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_DURATION,1)
                myviewmodel.setState(ModelState(switch_increment = 1))
            }
            auto_switch = it
        }

        newState.mTest_increment?.let {
            test_increment = it
        }

        newState.mSwitch_increment?.let {
            switch_increment = it
        }
        Log.d("def.TAG","onStateChanged")
    }

}