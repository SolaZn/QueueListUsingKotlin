package elements

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
A media file
 */
@Serializable
data class Media(@SerialName("id") var id: Int)