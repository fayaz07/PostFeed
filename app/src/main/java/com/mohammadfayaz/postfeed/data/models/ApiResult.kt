package com.mohammadfayaz.postfeed.data.models

data class ApiResult<T>(val data: T?, val success: Boolean, val message: String = "")
