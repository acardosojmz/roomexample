package dev.cardoso.roomexample.data.entities

import dev.cardoso.roomexample.domain.entities.PasesalidaEntity
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity


class PasesalidaDataToEntityMapper constructor() {

    fun mapToEntity(data: PasesalidaSourceData): PasesalidaSourceEntity =
        PasesalidaSourceEntity(
            status = data.status,
            pasesalida = mapListPasesalidaToEntity(data.pasesalida)
        )

    fun mapToEntity(pasesalida: List<PasesalidaEntityData>):
            PasesalidaSourceEntity? = PasesalidaSourceEntity(
        pasesalida = mapListPasesalidaToEntity(pasesalida)

    )

    fun mapListPasesalidaToEntity(pasesalida: List<PasesalidaEntityData>?)
            : List<PasesalidaEntity> = pasesalida?.map { mapPasesalidaToEntity(it) }?: emptyList()

    fun mapPasesalidaToEntity(response: PasesalidaEntityData): PasesalidaEntity = PasesalidaEntity(
        id = response.id,
        folio = response.folio,
        fecha = response.fecha,
        fk_id_usuario = response.fk_id_usuario,
        fk_id_vehiculo = response.fk_id_vehiculo,
        proyecto = response.proyecto,
        estatus = response.estatus)
}
