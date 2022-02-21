import elements.Data
import elements.Track
import queue.QueueList

import java.io.File
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import kotlin.test.*

/*
Tests for the JSON Parse feature
 */
class JSONDataTest {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Test
    fun parseJSON(){
        // Arrange
        val filePath = "./data/tracks.json"
        val fileContent = File(filePath).readText()

        val parseResult = json.decodeFromString<Data>(fileContent)
        val tracks = ArrayList<Track>()

        for(track in parseResult.data.album.tracks){
            tracks.add(track)
        }

        // Act to put the songs in the Queue
        val queueTest = QueueList(tracks)

        // Assert that every song from the JSON file is part of the queue
        for(track in tracks){
            assertEquals(track, queueTest.getCurrentTrack())
            queueTest.next()
        }
    }

}