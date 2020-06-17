package dev.cardoso.roomexample.presentation.entities

data class PasesalidaSource(
    var status: String? = null,
    var pasesalida:  List<Pasesalida> = emptyList()
)