package queue

import elements.Media
import elements.Track
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class QueueListTest {
    private val media = Media(123)
    private val track1 = Track(1, "Kojima Mayumi", "Amai Koi", 120, media)
    private val track2 = Track(2, "Jacques Revaux", "Chanson de Maxence", 120, media)
    private val track3 = Track(3, "Earth, Wind & Fire", "September", 120, media)

    @Test
    fun getCurrentTrack() {
        // Arrange
        val songs: ArrayList<Track> = ArrayList()

        // if the given list of elements to be played is empty
        // Assert that queue creation with empty track list fails
        assertFailsWith<IllegalStateException>("No track to be played in given list") { QueueList(songs) }

        // if the given list is not empty
        // Arrange
        songs.add(track1)
        songs.add(track2)
        songs.add(track3)
        val queueTest = QueueList(songs)

        // Assert that you can get the first track as the current track
        assertEquals(track1, queueTest.getCurrentTrack())
    }

    @Test
    fun next() {
        // Arrange
        val songs: ArrayList<Track> = ArrayList()
        songs.add(track1)
        songs.add(track2)
        songs.add(track3)
        val queueTest = QueueList(songs)

        // Assert second track is next track
        assertEquals(track2, queueTest.next())

        // (if there is no next track)
        // Act to reach last track
        queueTest.next()
        queueTest.next()

        // Assert next track still returns currentTrack
        assertEquals(track3, queueTest.next())
    }

    @Test
    fun previous() {
        // Arrange
        val songs: ArrayList<Track> = ArrayList()
        songs.add(track1)
        songs.add(track2)
        songs.add(track3)
        val queueTest = QueueList(songs)

        // (if there is no previous track)
        // Assert previousTrack still returns currentTrack
        assertEquals(track1, queueTest.previous())

        // Act to move to next track
        queueTest.next()

        // Assert previous track returns the track played before moving
        assertEquals(track1, queueTest.previous())
    }
}