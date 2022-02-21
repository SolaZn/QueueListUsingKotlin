package elements

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
An album containing multiple tracks
 */
@Serializable
class Album(@SerialName("album") val album: Tracks) {
}