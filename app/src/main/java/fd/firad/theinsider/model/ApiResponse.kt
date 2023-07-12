package fd.firad.theinsider.model

sealed class ApiResponse {
    object Loading : ApiResponse()
    class Success(val newsResponse: NewsMainResponse) : ApiResponse()
    class Error(val error: String) : ApiResponse()
}
