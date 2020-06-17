package dev.cardoso.roomexample.data.entities

import com.google.gson.annotations.SerializedName

data class PasesalidaSourceData(
    @SerializedName("status")     var status: String? = null,
    @SerializedName("pasesalida") var pasesalida: List<PasesalidaEntityData> = emptyList()
)
