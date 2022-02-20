package elements
/*
A track, containing information about the media content that is played,
as well as the actual media file
 */
class Track(var id: Int, var artist: String, var title: String, var duration: Int,
            var media: Media
) {
    override fun toString(): String {
        return "Track(id=$id, artist='$artist', title='$title', duration=$duration, media=$media)"
    }
}