package fd.firad.theinsider.model

data class NewsMainResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)