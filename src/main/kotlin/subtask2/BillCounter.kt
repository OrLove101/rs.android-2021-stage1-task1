package subtask2

class BillCounter {
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val price = bill.filterNot { it == bill[k] }.sum() / 2
        val charge = b - price

        if ( charge > 0 ) {
            return "$charge"
        }
        return "Bon Appetit"
    }
}
