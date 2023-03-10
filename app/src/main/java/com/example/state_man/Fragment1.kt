package com.example.state_man

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.state_man.databinding.Fragment1Binding
import com.saurabhbadola.statesman.BaseFragment
import com.saurabhbadola.statesman.NavigationRoute

class Fragment1 : BaseFragment<MyViewModel>(){
    private val TAG = "Fragment1.TAG"
    private lateinit var binding:Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        binding.myviewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()
        Log.d("df.TAG", "onCreateView: ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
    }

    override fun onStart(){
        super.onStart()
          viewModel.setStateChecked(
auto_test = SharedPreferencesHelper.getSharedPreferenceBoolean(
requireContext(),
SharedPreferencesHelper.KEY_AUTO_START_TEST_IS_CHECKED,
false),
auto_switch = SharedPreferencesHelper.getSharedPreferenceBoolean(
requireContext(),
SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_IS_CHECKED,
false),
test_increment = SharedPreferencesHelper.getSharedPreferenceInt(
requireContext(),
SharedPreferencesHelper.KEY_AUTO_START_TEST,
1
),
switch_increment = SharedPreferencesHelper.getSharedPreferenceInt(
requireContext(),
SharedPreferencesHelper.KEY_AUTO_SWITCH_POSITION_DURATION,
1
)
)
Toast.makeText(requireContext(),"On Start call",Toast.LENGTH_LONG).show()
}

}