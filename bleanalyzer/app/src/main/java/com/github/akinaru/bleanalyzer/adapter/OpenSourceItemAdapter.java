/****************************************************************************
 * This file is part of Bluetooth LE Analyzer.                              *
 * <p/>                                                                     *
 * Copyright (C) 2017  Bertrand Martel                                      *
 * <p/>                                                                     *
 * Foobar is free software: you can redistribute it and/or modify           *
 * it under the terms of the GNU General Public License as published by     *
 * the Free Software Foundation, either version 3 of the License, or        *
 * (at your option) any later version.                                      *
 * <p/>                                                                     *
 * Foobar is distributed in the hope that it will be useful,                *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of           *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            *
 * GNU General Public License for more details.                             *
 * <p/>                                                                     *
 * You should have received a copy of the GNU General Public License        *
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.          *
 */
package com.github.akinaru.bleanalyzer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.akinaru.bleanalyzer.R;

/**
 * Adapter for open source projects
 *
 * @author Bertrand Martel
 */
public class OpenSourceItemAdapter extends BaseAdapter {

    private static final String[][] COMPONENTS = new String[][]{

            {"DiscreteSeekBar", "https://github.com/AnderWeb/discreteSeekBar"},
            {"MPAndroidChart",
                    "https://github.com/PhilJay/MPAndroidChart"},
            {"nv-bluetooth", "https://github.com/TakahikoKawasaki/nv-bluetooth"},
            {"RFDuino", "https://github.com/RFduino/RFduino"},
            {"rfduino-makefile", "https://github.com/bertrandmartel/rfduino-makefile"}
    };

    private LayoutInflater mInflater;

    public OpenSourceItemAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return COMPONENTS.length;
    }

    @Override
    public Object getItem(int position) {
        return COMPONENTS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.open_source_items, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView url = (TextView) convertView.findViewById(R.id.url);

        title.setText(COMPONENTS[position][0]);
        url.setText(COMPONENTS[position][1]);

        return convertView;
    }
}