package com.alexilinskiy.nytimescomposeapp.model

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val abstract: String,
    val byline: String,
    val created_date: String,
    val des_facet: List<String>,
    val geo_facet: List<String>,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    val multimedia: List<Multimedia>?,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String,
    val section: String,
    val short_url: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
    val url: String
): Parcelable

class ItemType : NavType<Result>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Result? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): Result {
        return Gson().fromJson(value, Result::class.java)
    }
    override fun put(bundle: Bundle, key: String, value: Result) {
        bundle.putParcelable(key, value)
    }
}
