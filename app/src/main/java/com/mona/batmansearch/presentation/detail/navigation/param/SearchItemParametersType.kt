package com.mona.batmansearch.presentation.detail.navigation.param

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mona.batmansearch.data.model.searchItem.SearchItemsData

val SearchItemParametersType =
    object : NavType<SearchItemsData.SearchItemData>(isNullableAllowed = false) {

        override fun get(bundle: Bundle, key: String): SearchItemsData.SearchItemData? =
            bundle.getParcelable(key)

        override fun parseValue(value: String): SearchItemsData.SearchItemData =
            Gson().fromJson(value, object : TypeToken<SearchItemsData.SearchItemData>() {}.type)

        override fun put(bundle: Bundle, key: String, value: SearchItemsData.SearchItemData) =
            bundle.putParcelable(key, value)
    }