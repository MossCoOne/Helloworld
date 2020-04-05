package com.example.helloworld

class DocumentModel(val description: String, val photoList: MutableList<Photo>) {


    companion object {
        fun getListOfDocuments(): MutableList<DocumentModel> {
            return mutableListOf(
                DocumentModel("Police report", Photo.getSamplePhotoList()),
                DocumentModel("Driver's licence", Photo.getSamplePhotoList()),
                DocumentModel("Witness Licence", Photo.getSamplePhotoList()),
                DocumentModel("Third party licence", Photo.getSamplePhotoList())
            )
        }
    }
}