package queue

import elements.Media
import elements.Track

import kotlin.test.*

/*
Tests for the QueueList class
 */
class QueueListTest {
    private val media = Media(123)
    private val track1 = Track(1, "Kojima Mayumi", "Amai Koi", 120, media)
    private val track2 = Track(2, "Jacques Revaux", "Chanson de Maxence", 120, media)
    private val track3 = Track(3, "Earth, Wind & Fire", "September", 120, media)

    private val track4 = Track(4, "Nino Ferrer", "Mirza", 120, media)
    private val track5 = Track(5, "Julie London", "Fly Me To The Moon", 120, media)
    private val track6 = Track(6, "Anderson .Paak", "Fire In The Sky", 120, media)

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

    @Test
    fun add(){
        // Arrange
        val songs: ArrayList<Track> = ArrayList()
        songs.add(track1)
        songs.add(track2)
        songs.add(track3)

        val queueTest = QueueList(songs)

        val songs2: ArrayList<Track> = ArrayList()
        songs2.add(track5)
        songs2.add(track6)
        // Act to reach end of queue
        queueTest.next()
        queueTest.next()

        // Assert that track 3 is last track of queue
        assertEquals(track3, queueTest.next())

        // Act to add ONE more song
        queueTest.add(track4)

        // Assert that new song is now last track of queue
        assertEquals(track4, queueTest.next())

        // Act to add TWO other songs as part of a collection
        queueTest.add(songs2)

        // Assert that both songs were added to end of queue
        assertEquals(track5, queueTest.next())
        assertEquals(track6, queueTest.next())
    }

    @Test
    fun removeAt(){
        // Arrange
        val songs: ArrayList<Track> = ArrayList()
        songs.add(track1)
        songs.add(track2)
        songs.add(track3)
        val queueTest = QueueList(songs)

        // Act to remove second song
        queueTest.removeAt(1)

        // Assert that third song is not in queue anymore
        assertNotEquals(track2, queueTest.getCurrentTrack())
        assertNotEquals(track2, queueTest.next())
        assertNotEquals(track2, queueTest.next())
    }
}