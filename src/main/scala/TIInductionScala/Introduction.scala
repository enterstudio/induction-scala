package TIInductionScala

object Introduction extends App { 
  def isPalindrome(inputString: String) = {
    val strippedInputString =
      inputString.toLowerCase.replaceAll("[^a-z0-9]", "")
    val reversedInputString = strippedInputString.reverse
    strippedInputString == reversedInputString
  }

  println("Is 'Herculaneum' a palidrome? " + isPalindrome("Herculaneum"))
}
