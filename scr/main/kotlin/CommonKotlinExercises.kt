//run with ./gradlew run

data class Trade(
    val symblo: String,
    val quanity: Int,
    val price: Double
)

/**
 * EXERCISE 1:
 * Use map, filter, and sortedBy.
 *
 * Goal:
 *  - Filter trades where quantity >= minQty
 *  - Sort them by symbol (alphabetically)
 *  - Return just a list of symbols
 */

fun filterAndsortSymbols(
    trades: List<Trade>,
    minQty: Int
): List<String> {
    // TODO: implement using filter + sortBy + map
    return trades
        .filter { it.quanity >= minQty }
        .sortedBy { it.symbol }
        .map { it.symbol} 

}
/**
 * EXERCISE 2:
 * Null safety with ?. and ?:
 *
 * Given a nullable string that may contain a stock symbol,
 * return it uppercased, or "UNKNOWN" if it is null or blank.
 */
fun normalizeSymbol(raw: String?): String {

    return raw
        ?.trim()
        ?.takif { it.isNotEmpty() }
        ?.uppercase()
        
}

/**
 * EXERCISE 3:
 * Scope functions: apply / also / let
 *
 * Build a mutable list using apply, and log using also.
 */

 fun buildWatchlist(): MutableList<String> {
    val watchlist = MutableListof<String>().apply {
        add("AAPL")
        add("MSFT")
        add("TSLA")
    }.also { list ->
        println("watchlist built with ${list.size} symbols: $list")    
    }

    return watchlist
 }


/**
 * EXERCISE 4:
 * Extension function.
 *
 * Add an extension function on List<Trade> that calculates
 * the total market value (quantity * price summed).
 */

 fun List<Trade>.totalMarketValue(): Double{
    return this.sumOf {it.quantity}
 }