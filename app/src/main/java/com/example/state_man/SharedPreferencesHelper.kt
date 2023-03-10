package com.example.state_man

import android.content.Context

object SharedPreferencesHelper {
    private const val PREF_FILE = "State_test"
    const val KEY_AUTO_SWITCH_POSITION_DURATION = "KEY_AUTO_SWITCH_LEAD_POSITION"
    const val KEY_AUTO_SWITCH_POSITION_IS_CHECKED = "KEY_AUTO_SWITCH_LEAD_POSITION_IS_CHECKED"
    const val KEY_AUTO_START_TEST = "KEY_AUTO_START_TEST"
    const val KEY_AUTO_START_TEST_IS_CHECKED = "KEY_AUTO_START_TEST_IS_CHECKED"

    /**
     * Set a string shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceString(context: Context, key: String?, value: String?) {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * Set a integer shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceInt(context: Context, key: String?, value: Int?) {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        val editor = settings.edit()
        editor.putInt(key, value!!)
        editor.apply()
    }

    /**
     * Set a long shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceLong(context: Context, key: String?, value: Long?) {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        val editor = settings.edit()
        editor.putLong(key, value!!)
        editor.apply()
    }

    /**
     * Set a Boolean shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceBoolean(context: Context, key: String?, value: Boolean) {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        val editor = settings.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * Get a string shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceString(context: Context, key: String?, defValue: String?): String? {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        return settings.getString(key, defValue)
    }

    /**
     * Get a integer shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceLong(context: Context, key: String?, defValue: Long): Long {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        return settings.getLong(key, defValue)
    }

    fun getSharedPreferenceInt(context: Context, key: String?, defValue: Int): Int {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        return settings.getInt(key, defValue)
    }


    /**
     * Get a boolean shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceBoolean(context: Context, key: String?, defValue: Boolean): Boolean {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        return settings.getBoolean(key, defValue)
    }

    fun removeKey(context: Context,key: String?){
        val settings = context.getSharedPreferences(PREF_FILE,0)
        settings.edit().remove(key).apply()
    }
}