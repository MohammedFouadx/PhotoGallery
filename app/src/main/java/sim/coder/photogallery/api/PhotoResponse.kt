package sim.coder.photogallery.api

import com.google.gson.annotations.SerializedName
import sim.coder.photogallery.model.GalleryItem


class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}