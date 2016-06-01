package com.fouliex.android.weather;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by DragonRider on 5/30/2016.
 */
public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Add 'general' preferences, defined in the XML file
        //TODO: Add preferences from XML

        //For all preferences, attach OnPreferenceChangeListener so the UI Summary can be updated when the preference change.
        //TODO : Add preference
    }

    /**
     * Attaches a listener so the summary is always updated with the preference value.
     * Also fires the listener once, to initialize the summary.
     *
     * @param preference
     */
    private void bindPreferenceSummaryToValue(Preference preference) {
        //Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(this);

        //Trigger the listener immediately with the preference's current value.
        onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), " "));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        String stringValue = value.toString();
        if (preference instanceof ListPreference) {
            //For list preferences, look up the correct display value in the preference's 'entries' list.
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            //For other preferences, set the summary to the value's simple string representation.
            preference.setSummary(stringValue);
        }

        return false;
    }
}
