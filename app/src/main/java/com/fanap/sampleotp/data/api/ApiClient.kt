import com.google.gson.GsonBuilder
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


/**
 *
 * Created by arvin
 * on Tue, 22 January 2019 at 1:13 PM.
 */
class ApiClient {

    companion object {

        private const val SERVER_ADDRESS: String = "https://SERVER_ADDRESS.com"

        @Volatile
        private var CLIENT: Retrofit? = null

        fun getClient(): Retrofit {
            return CLIENT ?: synchronized(this) {
                val gson = GsonBuilder().create()
                return Retrofit.Builder()
                    .baseUrl(SERVER_ADDRESS)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build().also { CLIENT = it }
            }
        }
    }
}