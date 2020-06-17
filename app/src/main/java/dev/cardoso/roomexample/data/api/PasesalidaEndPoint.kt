package dev.cardoso.roomexample.data.api

import dev.cardoso.roomexample.data.entities.PasesalidaSourceData
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

interface PasesalidaEndPoint {
/*
    @FormUrlEncoded
    @POST("pases")
    fun guardarPasesalida(
        @Field("folio") foliodotacion: String,
        @Field("fk_id_vehiculo") id_vehiculo: Int,
        @Field("fecha") fecha: String,
        @Field("fk_id_usuario") id_usuario: Int,
        @Field("proyecto") proyecto: String
    ): Observable<Respuesta<PaseSalida>>
*/
    @GET("pases")
    fun listarpasesalida(): Flowable<PasesalidaSourceData>
/*
    @GET("mostrar/{id}")
    fun getPasesalidaXId(@Path("id") id: Int
    ): Call<PaseUpdate>
*/

}