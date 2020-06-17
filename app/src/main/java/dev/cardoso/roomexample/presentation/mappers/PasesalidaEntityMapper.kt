package dev.cardoso.roomexample.presentation.mappers

import dev.cardoso.roomexample.domain.common.Mapper
import dev.cardoso.roomexample.domain.entities.PasesalidaEntity
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import dev.cardoso.roomexample.presentation.entities.Pasesalida
import dev.cardoso.roomexample.presentation.entities.PasesalidaSource


class PasesalidaEntityMapper : Mapper<PasesalidaSourceEntity, PasesalidaSource>() {

    override fun mapFrom(from: PasesalidaSourceEntity): PasesalidaSource = PasesalidaSource(
        status = from.status,
        pasesalida = mapListPasesalidaToPresentation(from.pasesalida)
    )

    private fun mapListPasesalidaToPresentation(pasesalida: List<PasesalidaEntity>?)
            : List<Pasesalida> = pasesalida?.map { mapPasesalidaToPresentation(it) }
        ?: emptyList()

    private fun mapPasesalidaToPresentation(response: PasesalidaEntity): Pasesalida = Pasesalida(
        id = response.id,
        folio = response.folio,
        fecha = response.fecha,
        fk_id_usuario = response.fk_id_usuario,
        fk_id_vehiculo = response.fk_id_vehiculo,
        proyecto = response.proyecto,
        estatus = response.estatus
    )
}