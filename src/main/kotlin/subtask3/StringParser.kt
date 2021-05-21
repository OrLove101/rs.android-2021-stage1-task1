package subtask3

class StringParser {
    fun getResult(inputString: String): Array<String> {
        val result = mutableListOf<String>()

        var startSubstr: Int
        var endSubstr: Int
        var substr: String
        var hasSubstr = false

        for ( i in 0..inputString.lastIndex ) {
            if ( inputString[i] == '[' || inputString[i] == '<' || inputString[i] == '(' ) {
                startSubstr = i
                for ( j in inputString.lastIndex downTo i ) {
                    if ( when {
                        inputString[startSubstr] == '[' && inputString[j] == ']' -> true
                            inputString[startSubstr] == '<' && inputString[j] == '>' -> true
                            inputString[startSubstr] == '(' && inputString[j] == ')' -> true
                            else -> false
                    } ) {
                        endSubstr = j
                        for ( k in j-1 downTo i+1 ) {
                            if ( when {
                                inputString[startSubstr] == '[' && inputString[k] == ']' -> true
                                    inputString[startSubstr] == '<' && inputString[k] == '>' -> true
                                    inputString[startSubstr] == '(' && inputString[k] == ')' -> true
                                    else -> false
                            } ) {
                                for ( m in i+1..k ) {
                                    if ( inputString[m] == '[' || inputString[m] == '<' || inputString[m] == '(' ) {
                                        hasSubstr = true
                                    }
                                }
                                if ( !hasSubstr ) {
                                    endSubstr = k
                                }
                            }
                        }
                        substr = inputString.substring(startSubstr+1, endSubstr)
                        if ( substr !in result ) {
                            result.add(substr)
                        }
                    }
                }
            }
        }
        return result.toTypedArray()
    }
}
