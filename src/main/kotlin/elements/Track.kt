package elements

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
A track, containing information about the media content that is played,
as well as the actual media file
 */
@Serializable
data class Track(@SerialName("id") var id: Int, @SerialName("artist") var artist: String,
                 @SerialName("title") var title: String, @SerialName("duration") var duration: Int,
                 @SerialName("media") var media: Media
)