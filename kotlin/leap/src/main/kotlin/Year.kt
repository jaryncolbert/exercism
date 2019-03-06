
class Year(year: Int) {

    val isLeap = year.rem(4) == 0 && (year.rem(10) != 0 || year.rem(40) == 0)

}