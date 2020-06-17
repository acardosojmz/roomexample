package dev.cardoso.roomexample.presentation.entities

data class Pasesalida(
    val id : Int,
    val folio:String,
    val fk_id_vehiculo:Int,
    val fecha:String,
    val fk_id_usuario:Int,
    val proyecto:String,
    val estatus:String)