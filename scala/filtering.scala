object Test {
  case class DiseaseData(sex: String, height: Double, bloodType: String, age: Int, anomalia: String)

  def main(args: Array[String]): Unit = {
    val diseaseDataList = createDiseaseDataList()
    println(diseaseDataList)
    println(getAnomalia(diseaseDataList))
    println(getWomen(diseaseDataList))
    println(getMen(diseaseDataList))
    println(getMaxAge(diseaseDataList))
    println(getMinAge(diseaseDataList))
  }

  def getMaxAge(diseaseDataList: List[DiseaseData]): Int = {
  	return diseaseDataList.map(x => x.age).reduceLeft(_ max _)
  }

  def getMinAge(diseaseDataList: List[DiseaseData]): Int = {
  	return diseaseDataList.map(x => x.age).reduceLeft(_ min _)
  }

  def getAnomalia(diseaseDataList: List[DiseaseData]): List[DiseaseData] = {
  	return diseaseDataList.filter(x => x.anomalia == "YES")	
  }

  def getWomen(diseaseDataList: List[DiseaseData]): List[DiseaseData] = {
  	return diseaseDataList.filter(x => x.sex == "F")	
  }

  def getMen(diseaseDataList: List[DiseaseData]): List[DiseaseData] = {
  	return diseaseDataList.filter(x => x.sex == "M")	
  }

  def createDiseaseDataList(): List[DiseaseData] = {
  	return List(
  	  DiseaseData("F", 63, "O", 22, "YES"),
  	  DiseaseData("F", 58, "O", 27, "NO"),
  	  DiseaseData("M", 76, "A", 34, "NO"),
  	  DiseaseData("F", 56, "B", 29, "YES"),
  	  DiseaseData("M", 130, "O", 23, "NO"),
  	  DiseaseData("F", 57, "O", 24, "YES"),
  	  DiseaseData("F", 66, "O", 24, "YES"),
  	  DiseaseData("F", 82, "AB", 27, "NO"),
  	  DiseaseData("M", 82, "AB", 31, "NO"),
  	  DiseaseData("F", 57, "B", 30, "NO"),
  	  DiseaseData("F", 56, "O", 31, "YES"),
  	  DiseaseData("M", 77, "O", 28, "YES"),
  	  DiseaseData("F", 74, "A", 22, "YES"),
  	  DiseaseData("M", 98, "O", 29, "YES"),
  	  DiseaseData("F", 69, "O", 25, "NO"),
  	  DiseaseData("F", 75, "O", 27, "YES"),
  	  DiseaseData("F", 78, "O", 29, "NO"),
  	  DiseaseData("M", 96, "AB", 30, "YES"),
  	  DiseaseData("M", 93, "A", 34, "YES"),
  	  DiseaseData("M", 90, "O", 31, "NO")
  	  )
  }
}