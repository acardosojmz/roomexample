package dev.cardoso.roomexample.data.entities

import dev.cardoso.roomexample.domain.entities.PasesalidaEntity

class PasesalidaEntityToDataMapper constructor() {

    fun mapListPasesalidaToData(pasesalida: List<PasesalidaEntity>?)
            : List<PasesalidaEntityData> = pasesalida?.map { mapPasesalidaToData(it) } ?: emptyList()

    fun mapPasesalidaToData(response: PasesalidaEntity): PasesalidaEntityData = PasesalidaEntityData(

        id = response.id,
        folio = response.folio,
        fecha = response.fecha,
        fk_id_usuario = response.fk_id_usuario,
        fk_id_vehiculo = response.fk_id_vehiculo,
        proyecto = response.proyecto,
        estatus = response.estatus)
}

