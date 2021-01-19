package sim.coder.photogallery.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class GalleryItem(
        var title: String = "",
        var id: String = "",

        @SerializedName("url_s")
        var url: String = "",

        @SerializedName("owner")
        var owner:String = ""


){
    val pageUri:Uri
    get() {

        return Uri.parse("https://flickr.com/photos").buildUpon().appendPath(owner).appendPath(id).build()
    }
}