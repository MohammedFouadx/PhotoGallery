package sim.coder.photogallery.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sim.coder.photogallery.FlickrFetchr

class PhotoGalleryViewModel : ViewModel() {

    val galleryItemLiveData: LiveData<List<GalleryItem>>

    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }
}