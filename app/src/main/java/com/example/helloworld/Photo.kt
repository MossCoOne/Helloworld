package com.example.helloworld

data class Photo(val title: String, val description: String, val imageResourceId: Int) {

    companion object {
        fun getSamplePhotoList(): MutableList<Photo> {
            return mutableListOf(
                Photo("Movie", "You watch it when you are bored", R.drawable.ic_movie_black_24dp),
                Photo("Motorcycle", "It is very fast", R.drawable.ic_motorcycle_black_24dp),
                Photo(
                    "Mouse",
                    "It is used to navigate your computer",
                    R.drawable.ic_mouse_black_24dp
                ),
                Photo("Inbox icon", "Move to inbox icon", R.drawable.ic_move_to_inbox_black_24dp),
                Photo(
                    "Accident report",
                    "Police report deatiling what happened at the accident",
                    R.drawable.ic_movie_black_24dp
                )
            )
        }
        fun savePhoto(photo:Photo){

        }
    }

}