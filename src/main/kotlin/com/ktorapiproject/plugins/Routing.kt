package com.ktorapiproject.plugins

import com.ktorapiproject.data.User
import com.ktorapiproject.repository.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    db:DatabaseFactory
) {
    routing {

        post("/user") {
            val requestBody = call.receive<User>()
            val user=db.addUser(requestBody)
            call.respond(user)
        }

        get("/user/{id}") {
            val id = call.parameters["id"]
            val user=db.getUserById(id!!)
            call.respond(user)
        }

        delete("/user/{id}") {
            val id = call.parameters["id"]
            val isDeleted=db.deleteUserById(id!!)

            if (isDeleted) {
                call.respond("User deleted successfully..")
            }else{
                call.respond("User not deleted..")
            }
        }
    }


}
