package sim.coder.photogallery.model

import android.app.Application
import android.app.DownloadManager
import androidx.lifecycle.*
import sim.coder.photogallery.FlickrFetchr
import sim.coder.photogallery.QueryPreferences

class PhotoGalleryViewModel(val app : Application) : AndroidViewModel(app) {

    val galleryItemLiveData: LiveData<List<GalleryItem>>
    private val flickrFetchr = FlickrFetchr()
    private val mutableSearchTerm= MutableLiveData<String>()

    val searchTerm : String
    get() = mutableSearchTerm.value?:""

    init {

        mutableSearchTerm.value= QueryPreferences.getStoredQuery(app)
        galleryItemLiveData = Transformations.switchMap(mutableSearchTerm){searchTerm ->
            if (searchTerm.isBlank()) {
                flickrFetchr.fetchPhotos()
            } else {
                flickrFetchr.searchPhotos(searchTerm)
            }
        }


        //FlickrFetchr().fetchPhotos()
    }

    fun fetchPhotos(query : String="") {
        QueryPreferences.setStoredQuery(app,query)
        mutableSearchTerm.value = query
    }
}