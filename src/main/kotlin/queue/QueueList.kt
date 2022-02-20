package queue

import elements.Track

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
}