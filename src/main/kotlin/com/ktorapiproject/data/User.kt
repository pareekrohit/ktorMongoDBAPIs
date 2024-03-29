package com.ktorapiproject.data

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class User(
    @BsonId
    val userId:String= ObjectId().toString(),
    val email:String,
    val name:String
)
