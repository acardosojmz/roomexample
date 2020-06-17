package dev.cardoso.roomexample.domain.entities


data class PasesalidaSourceEntity(
    var status: String? = null,
    var pasesalida: List<PasesalidaEntity> = emptyList()
)