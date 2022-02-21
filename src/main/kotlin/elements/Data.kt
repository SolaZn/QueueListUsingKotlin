package elements

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
A data collection containing an album
 */
@Serializable
class Data(@SerialName("data") val data: Album) {
}