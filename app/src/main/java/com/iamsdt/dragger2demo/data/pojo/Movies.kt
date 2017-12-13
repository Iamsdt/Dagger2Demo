package com.iamsdt.dragger2demo.data.pojo

import com.google.gson.annotations.SerializedName

data class Movies(val page: Int = 0,
                  @SerializedName("total_pages")
                  val totalPages: Int = 0,
                  val results: List<ResultsItem>?,
                  @SerializedName("total_results")
                  val totalResults: Int = 0)