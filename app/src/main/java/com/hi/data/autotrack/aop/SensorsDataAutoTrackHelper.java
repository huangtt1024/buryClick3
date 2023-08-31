/*
 * Created by wangzhuozhou on 2015/08/01.
 * Copyright 2015－2022 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hi.data.autotrack.aop;

import android.content.DialogInterface;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;

@SuppressWarnings("unused")
public class SensorsDataAutoTrackHelper {
    private static final String TAG = "SA.SensorsDataAutoTrackHelper";

    public static void trackRN(Object target, int reactTag, int s, boolean b) {

    }

    public static void trackExpandableListViewOnGroupClick(ExpandableListView expandableListView, View view, int groupPosition) {
        Log.d("helper","trackExpandableListViewOnGroupClick");
        // AppClickTrackImpl.trackExpandableListViewOnGroupClick(SensorsDataAPI.sharedInstance(), expandableListView, view, groupPosition);
    }

    public static void trackExpandableListViewOnChildClick(ExpandableListView expandableListView, View view,
                                                           int groupPosition, int childPosition) {
        Log.d("helper","trackExpandableListViewOnChildClick");

       // AppClickTrackImpl.trackExpandableListViewOnChildClick(SensorsDataAPI.sharedInstance(), expandableListView, view, groupPosition, childPosition);
    }

    public static void trackTabHost(final String tabName) {
        Log.d("helper","trackTabHost");
//        try {
//            ThreadUtils.getSinglePool().execute(new Runnable() {
//                @Override
//                public void run() {
//                    AppClickTrackImpl.trackTabHost(SensorsDataAPI.sharedInstance(), tabName);
//                }
//            });
//        } catch (Exception e) {
//            SALog.printStackTrace(e);
//        }
    }

    public static void trackTabLayoutSelected(Object object, Object tab) {
        Log.d("helper","trackTabLayoutSelected");
       // AppClickTrackImpl.trackTabLayoutSelected(SensorsDataAPI.sharedInstance(), object, tab);
    }

    public static void trackMenuItem(MenuItem menuItem) {
        trackMenuItem(null, menuItem);
    }

    public static void trackMenuItem(final Object object, final MenuItem menuItem) {
        Log.d("helper","trackMenuItem");
//        try {
//            ThreadUtils.getSinglePool().execute(new Runnable() {
//                @Override
//                public void run() {
//                    AppClickTrackImpl.trackMenuItem(SensorsDataAPI.sharedInstance(), object, menuItem);
//                }
//            });
//        } catch (Exception e) {
//            SALog.printStackTrace(e);
//        }
    }

    public static void trackRadioGroup(RadioGroup view, int checkedId) {
        Log.d("helper","trackRadioGroup");
       // AppClickTrackImpl.trackRadioGroup(SensorsDataAPI.sharedInstance(), view, checkedId);
    }

    public static void trackDialog(DialogInterface dialogInterface, int whichButton) {
        Log.d("helper","trackDialog");
       // AppClickTrackImpl.trackDialog(SensorsDataAPI.sharedInstance(), dialogInterface, whichButton);
    }

    public static void trackListView(AdapterView<?> adapterView, View view, int position) {
        Log.d("helper","trackListView");
       // AppClickTrackImpl.trackListView(SensorsDataAPI.sharedInstance(), adapterView, view, position);
    }

    public static void trackDrawerOpened(View view) {
        Log.d("helper","trackDrawerOpened");
       // AppClickTrackImpl.trackDrawerOpened(SensorsDataAPI.sharedInstance(), view);
    }

    public static void trackDrawerClosed(View view) {
        Log.d("helper","trackDrawerClosed");
       // AppClickTrackImpl.trackDrawerClosed(SensorsDataAPI.sharedInstance(), view);
    }

    public static void trackViewOnClick(View view) {
        if (view == null) {
            return;
        }
        trackViewOnClick(view, view.isPressed());
    }

    public static void trackViewOnClick(View view, boolean isFromUser) {
        Log.d("helper","trackViewOnClick");

       // AppClickTrackImpl.trackViewOnClick(SensorsDataAPI.sharedInstance(), view, isFromUser);
    }

    public static void track(final String eventName, String properties) {
        Log.d("helper","track");
       // AppClickTrackImpl.track(SensorsDataAPI.sharedInstance(), eventName, properties);
    }
}