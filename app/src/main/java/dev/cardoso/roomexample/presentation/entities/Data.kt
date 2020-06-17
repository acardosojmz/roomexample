package dev.cardoso.roomexample.presentation.entities

data class Data<RequestData>(var responseType: Status, var data: RequestData? = null, var error: Error? = null)
