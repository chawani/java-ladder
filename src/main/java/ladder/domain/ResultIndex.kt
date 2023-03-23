package ladder.domain

import java.util.stream.Collectors

class ResultIndex(val resultIndex: List<Int>) {

    init {
        validateResultIndex(resultIndex)
    }

    fun findIndex(target: Int): Int {
        return resultIndex.indexOf(target)
    }

    companion object {
        private fun validateResultIndex(resultIndex: List<Int>) {
            validateEmpty(resultIndex)
            validateDuplication(resultIndex)
            validateRange(resultIndex)
        }

        fun validateEmpty(resultIndex: List<Int>?) {
            require(!(resultIndex == null || resultIndex.size == 0)) { "결과값 생성 중 결과가 없습니다" }
        }

        fun validateDuplication(resultIndex: List<Int>) {
            require(resultIndex.stream().distinct().collect(Collectors.toList()).size == resultIndex.size) { "결과값 생성 중 중복된 Index가 있습니다." }
        }

        fun validateRange(resultIndex: List<Int>) {
            require(
                !(
                    resultIndex.stream().mapToInt { v: Int? -> v!! }.max().asInt >= resultIndex.size ||
                        resultIndex.stream().mapToInt { v: Int? -> v!! }.min().asInt < 0
                    )
            ) { "결과값 생성 중 연속되지 않은 Index가 있습니다." }
        }
    }
}
