package queue

import elements.Track
import kotlin.IndexOutOfBoundsException

/*
A queue containing a list of elements to be played by the Media Player
 */
class QueueList(tracks: ArrayList<Track>) {
    /*
    The actual queue of elements
     */
    private var queue: ArrayList<Track>
    /*
    The current index of the queue
     */
    private var currentIndex: Int
    /*
    The current track that should be played; by default, the first
    of the queue
     */
    private var currentTrack: Track

    /*
    Initialization block
     */
    init{
        try{
            queue = tracks
            currentTrack = queue.first()
            currentIndex = 0
        }catch(ex: NoSuchElementException){
            error("No track to be played in given list")
        }
    }

    /*
    The explicit public getter for the current track
     */
    fun getCurrentTrack(): Track {
        return currentTrack
    }

    /*
    The next() method that returns the next track to be played
    and updates the current track in the QueueList
     */
    fun next(): Track {
        if(queue.getOrNull(currentIndex + 1) != null) {
            currentTrack = queue[++currentIndex]
        }
        return currentTrack
    }

    /*
    The previous() method that returns the previous track to be played
    and updates the current track in the QueueList
     */
    fun previous(): Track {
        if(queue.getOrNull(currentIndex - 1) != null){
            currentTrack = queue[--currentIndex]
        }
        return currentTrack
    }

    /*
    The add(element) method adds the specified Track element at the end of the queue
     */
    fun add(element: Track){
        try{
            queue.add(element)
        }catch(e: Exception){
            error("The track could not be inserted")
        }
    }

    /*
    The add(elCollection) adds the specified collection of Tracks elements at
    the end of the queue
     */
    fun add(elCollection: Collection<Track>){
        try{
            queue.addAll(elCollection)
        }catch(e: Exception){
            error("An error occurred while inserting the tracks")
        }
    }

    /*
    The removeAt(index) method removes the Track element at the specified
    index of the Queue
     */
    fun removeAt(index: Int){
        try{
            queue.removeAt(index)
        }catch(id: IndexOutOfBoundsException){
            error("Cannot remove element that doesn't exist within queue")
        }
    }
}