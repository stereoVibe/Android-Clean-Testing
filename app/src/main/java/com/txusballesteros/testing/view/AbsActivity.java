/*
 * Copyright Txus Ballesteros 2016 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package com.txusballesteros.testing.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.txusballesteros.testing.Application;
import com.txusballesteros.testing.internal.di.ApplicationComponent;
import com.txusballesteros.testing.internal.di.DependenciesInjector;

import butterknife.ButterKnife;

public abstract class AbsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onRequestLayout());
        initializeInjection();
        initializeViewsInjection();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((Application)getApplication()).getApplicationComponent();
    }

    protected DependenciesInjector getDependenciesInjector() {
        return ((Application)getApplication()).getDependenciesInjector();
    }

    private void initializeInjection() {
        onInitializeInjection();
    }

    private void initializeViewsInjection() {
        ButterKnife.bind(this);
        onViewReady();
    }

    abstract void onViewReady();

    abstract int onRequestLayout();

    abstract void onInitializeInjection();
}
