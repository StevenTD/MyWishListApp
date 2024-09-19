package steve.example.mywishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWatch{
    val wishList = listOf(
        Wish(1L, "Watch 1", "Description 1"),
        Wish(2L, "Watch 2", "Description 2"),
        Wish(3L, "Watch 3", "Description 3"),
        Wish(4L, "Watch 4", "Description 4"),
    )
}