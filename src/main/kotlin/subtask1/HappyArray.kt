package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        var flag: Boolean = true
        var inputArray = sadArray

        if ( sadArray.isEmpty() ) {
            return sadArray
        }
        while (flag) {
            val happyArray = mutableListOf<Int>()
            flag = false

            happyArray.add(inputArray.first())
            for ( i in 1 until inputArray.lastIndex) {
                if ( inputArray[i] < inputArray[i-1] + inputArray[i+1] ) {
                    happyArray.add(inputArray[i])
                } else {
                    flag = true
                }
            }
            happyArray.add(inputArray.last())
            inputArray = happyArray.toIntArray();
        }
        return inputArray
    }
}
