package com.uktamov.mvpinstagram.model

data class UserResponse(
    val `data`: List<Data>,
    val page:Int,
    val per_page:Int,
    val total:Int,
    val total_pages:Int

)
