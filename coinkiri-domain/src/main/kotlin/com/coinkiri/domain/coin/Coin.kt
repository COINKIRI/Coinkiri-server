package com.coinkiri.domain.coin

import java.nio.file.Files.readAllBytes
import java.nio.file.Paths
import java.time.LocalDateTime
import java.util.*

data class Coin(
    val marketName: String,
    val koreanName: String,
    val englishName: String,
    var symbol: String, // TODO private set
    val createdAt: LocalDateTime
) {
    companion object {
        fun fromList(coinCreateList: List<CoinCreate>): List<Coin> {
            return coinCreateList.map { from(it) }
        }

        private fun from(coinCreate: CoinCreate): Coin {
            return Coin(
                marketName = coinCreate.marketName,
                koreanName = coinCreate.koreanName,
                englishName = coinCreate.englishName,
                symbol = initSymbol(),
                createdAt = LocalDateTime.now(),
            )
        }

        private fun initSymbol(): String {
            return try {
                val resource = this::class.java.classLoader.getResource("default_image/default_image.png")
                val imagePath = Paths.get(resource.toURI())
                val imageBytes = readAllBytes(imagePath)
                Base64.getEncoder().encodeToString(imageBytes)
            } catch (e: Exception) {
                println("이미지 인코딩에 실패하였습니다: ${e.message}")
                ""
            }
        }
    }

    fun updateSymbolImage(marketName: String) {
        try {
            val marketNameLower = marketName.substring(4).lowercase()
            println("marketNameLower: $marketNameLower")
            val resource = this::class.java.classLoader.getResource("symbol_images_png/$marketNameLower.png")
            val imagePath = Paths.get(resource.toURI())
            val imageBytes = readAllBytes(imagePath)
            this.symbol = Base64.getEncoder().encodeToString(imageBytes)
        } catch (e: Exception) {
            println("이미지 인코딩에 실패하였습니다: ${e.message}")
        }
    }
}
