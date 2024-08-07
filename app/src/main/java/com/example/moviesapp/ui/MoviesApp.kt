/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package com.example.moviesapp.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.moviesapp.designsystem.component.MoviesAppBackground


@Composable
fun MoviesApp(
    appState: MoviesAppState,
    modifier: Modifier = Modifier
) {

    MoviesAppBackground(modifier = modifier) {
        MoviesApp(appState)

    }
}



@Composable
internal fun MoviesApp(
//    appState: MoviesAppState,
//    modifier: Modifier = Modifier,
    ){



}