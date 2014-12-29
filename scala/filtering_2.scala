object Test {

  sealed trait Gender
  case class Male() extends Gender
  case class Female() extends Gender

  sealed trait Blood
  case class O() extends Blood
  case class A() extends Blood
  case class B() extends Blood
  case class AB() extends Blood

  sealed trait Anomalia
  case class Yes() extends Anomalia
  case class No() extends Anomalia

  case class DiseaseData(sex: Gender, weight: Double, bloodType: Blood, age: Int, anomalia: Anomalia)

  def main(args: Array[String]): Unit = {
    val diseaseDataList = createDiseaseDataList()
    println(diseaseDataList)
    
    diseaseDataList.foreach(_ match {
          case DiseaseData(sex:Male,_,_,_,_)   => println("Male")
          case DiseaseData(sex:Female,_,_,_,_) => println("Female")
          case _                               => println("Ricky Martin")
      }
    )

    println(getAnomalia(diseaseDataList))
    println(getWomen(diseaseDataList))
    println(getMen(diseaseDataList))
    println(getMaxAge(diseaseDataList))
    println(getMinAge(diseaseDataList))
  }

  def getMaxAge(diseaseDataList: List[DiseaseData]): Int = diseaseDataList.map(x => x.age).reduceLeft(_ max _)
  
  def getMinAge(diseaseDataList: List[DiseaseData]): Int = diseaseDataList.map(x => x.age).reduceLeft(_ min _)

  def getAnomalia(diseaseDataList: List[DiseaseData]): List[DiseaseData] = diseaseDataList.filter(x => x.anomalia == Yes())
 
  def getWomen(diseaseDataList: List[DiseaseData]): List[DiseaseData] = diseaseDataList.filter(x => x.sex == Female())
 
  def getMen(diseaseDataList: List[DiseaseData]): List[DiseaseData] = diseaseDataList.filter(x => x.sex == Male())

  def createDiseaseDataList(): List[DiseaseData] = 
      List(
      	  DiseaseData(Female(), 63, O(), 22, Yes()),
      	  DiseaseData(Female(), 58, O(), 27, No()),
      	  DiseaseData(Male(), 76, A(), 34, No()),
      	  DiseaseData(Female(), 56, B(), 29, Yes()),
      	  DiseaseData(Male(), 130, O(), 23, No()),
      	  DiseaseData(Female(), 57, O(), 24, Yes()),
      	  DiseaseData(Female(), 66, O(), 24, Yes()),
      	  DiseaseData(Female(), 82, AB(), 27, No()),
      	  DiseaseData(Male(), 82, AB(), 31, No()),
      	  DiseaseData(Female(), 57, B(), 30, No()),
      	  DiseaseData(Female(), 56, O(), 31, Yes()),
      	  DiseaseData(Male(), 77, O(), 28, Yes()),
      	  DiseaseData(Female(), 74, A(), 22, Yes()),
      	  DiseaseData(Male(), 98, O(), 29, Yes()),
      	  DiseaseData(Female(), 69, O(), 25, No()),
      	  DiseaseData(Female(), 75, O(), 27, Yes()),
      	  DiseaseData(Female(), 78, O(), 29, No()),
      	  DiseaseData(Male(), 96, AB(), 30, Yes()),
      	  DiseaseData(Male(), 93, A(), 34, Yes()),
      	  DiseaseData(Male(), 90, O(), 31, No())
  	  )
}