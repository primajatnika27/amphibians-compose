package com.prima.amphibians.data

import com.prima.amphibians.model.Amphibians
import com.prima.amphibians.network.ApiService

interface AmphibiansRepository {
    suspend fun getListAmphibians(): List<Amphibians>
}

class NetworkAmphibiansRepository(
    private val amphibiansService: ApiService
): AmphibiansRepository {

    override suspend fun getListAmphibians(): List<Amphibians> = amphibiansService.getListAmphibians()

}