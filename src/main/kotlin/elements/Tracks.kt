package elements

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
A list of tracks
 */
@Serializable
class Tracks(@SerialName("tracks") val tracks: List<Track>) {
}