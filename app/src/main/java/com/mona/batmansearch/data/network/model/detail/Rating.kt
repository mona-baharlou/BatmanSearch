package com.mona.batmansearch.data.network.model.detail

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val Source: String,
    val Value: String
)